/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Oscar
 */
public class Circuito
{
	//protected List<Coche> coches = new ArrayList<>();
	protected Map<Coche, Float> cocheConSuDistancia
			= new HashMap<>();	// Aqui guardare cada coche con su distancia recorrida
	
	List<Coche> cochesQueHanTerminado = new ArrayList<>();
	
	protected String nombre;
	protected int laps;
	protected int longitud;
	
	// Opcional
	float tiempoDeCarrera;
	
	public Circuito(String nombre, int longitud, int laps)
	{
		this. nombre = nombre;
		this.longitud = longitud;
		this.laps = laps;
	}
	
	public void apuntarEscuderia(Escuderia escuderia)
	{
		// Añado sus dos coches a la carrera
		cocheConSuDistancia.put(escuderia.getDosMejoresCoches()[0], 0f);
		cocheConSuDistancia.put(escuderia.getDosMejoresCoches()[1], 0f);
	}
	
	public void startRace()
	{
		// TODO
		tiempoDeCarrera = 0;
		
		// A correr!!!
		while(!actualizaTiempo())
		{
			// Do nothing
		}
		
		// Guardamos el resultado en un fichero
		try
		{
			FileWriter fw = new FileWriter("C:\\Users\\Oscar\\Desktop\\Formula1.txt", true );
			
			// Primero la fecha
			String out = new SimpleDateFormat("dd/MM/yyyy").format(new Date()) + "\r\n";
			out += "Circuit: " + nombre +"\r\n";
			for(int pos = 0; pos < cochesQueHanTerminado.size(); pos++)
			{
				out += (pos + 1) + "r: " + cochesQueHanTerminado.get(pos).getEscuderia().getNombre()
						+ " - " + cochesQueHanTerminado.get(pos).getModelo()
						+ "\t (" + "Qualitat: " + cochesQueHanTerminado.get(pos).getCalidad() + ")" + "\r\n";
				
			}
			out += "\r\n";
			fw.write(out);
			fw.close();				
		}
		catch(IOException ex)
		{
			System.err.println("Error al escribir en el fichero");
		}
	}
	
	public boolean actualizaTiempo()
	{
		
		tiempoDeCarrera += 1;		// 1 segon
		
		// Actualiza las distáncias recorridas por cada coche
		for (Entry<Coche, Float> entrada : cocheConSuDistancia.entrySet())
		{
			Coche coche = entrada.getKey();		// Saco el coche del map
			
			// Distancia antes de ejecutar este incremento
			float distanciaTotalRecorridaAntes = entrada.getValue();
			int vueltaActualAnterior = calculaVuelta(distanciaTotalRecorridaAntes);
			
			
			// Distancia despues de ejecutar este incremento. Ojo!!!
			float distanciaRecorridaEsteTiempo = coche.getCalidad() * (float)(Math.random() / 2f + 0.5f) * 60; 
			
			float distanciaTotalRecorrida = distanciaTotalRecorridaAntes + distanciaRecorridaEsteTiempo;
			int vueltaActual = calculaVuelta(distanciaTotalRecorrida);
			
			entrada.setValue(distanciaTotalRecorrida);		// Actualizo la distancia recorrida
			//System.out.println("Coche: " + coche.getModelo() + "tiempo: " + distanciaRecorridaEsteTiempo);
			// Este coche completó vuelta?
			if(vueltaActual > vueltaActualAnterior)
			{
				System.out.println("El coche " + coche.getModelo() + " de " + coche.getEscuderia().getNombre() + " completó vuelta " + vueltaActualAnterior);
			}
			
			// Este coche terminó la carrera?
			if(distanciaTotalRecorrida > (longitud * laps))
			{
				System.out.println("El coche " + coche.getModelo() + " de "
						+ coche.getEscuderia().getNombre() + " ha acabado la carrera"
						+ ". Tiempo: " + calculaTiempo(tiempoDeCarrera));	
				cochesQueHanTerminado.add(coche);
			}
		}
		
		// Quito del map los coches que han terminado
		for(Coche coche : cochesQueHanTerminado)
			cocheConSuDistancia.remove(coche);
		
		if(cocheConSuDistancia.size() == 0)
			return true;
		
		return false;
	}
	
	protected String calculaTiempo(float time)
	{
		int horas = (int)time/3600;
		int minutos = (int)(time - horas*3600) / 60;
		int segundos = (int)(time - horas*3600 - minutos*60);
		return Integer.toString(horas) + "h " + Integer.toString(minutos) + "m " + Integer.toString(segundos) + "s";
	}
	
	protected int calculaVuelta(float distancia)	// Vuelta 1 hasta la vuelta 'laps'
	{
		return (int)(distancia / (float) (longitud) + 1f);
	}
}
