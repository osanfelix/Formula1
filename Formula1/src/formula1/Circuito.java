/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Oscar
 */
public class Circuito
{
	protected List<Coche> coches = new ArrayList<>();
	protected Map<Coche, Float> longitudRecorridaPorCoche
			= new HashMap<>();	// Aqui guardare lo recorrido x cada coche
	
	protected String nombre;
	protected int laps;
	protected int longitud;
	
	public Circuito(String nombre, int longitud, int laps)
	{
		this. nombre = nombre;
		this.longitud = longitud;
		this.laps = laps;
	}
	
}
