/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Oscar
 */
public class Escuderia
{
	protected List<Coche> coches = new ArrayList<>();
	protected String nombre = null;
	
	
	public Escuderia(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void addCoche(Coche coche)
	{
		coches.add(coche);
	}
	
	public Coche[] getDosMejoresCoches()
	{
		Coche[] mejoresCoches = new Coche[2];
		Collections.sort(coches);
		
		mejoresCoches[0] = coches.get(0);
		mejoresCoches[1] = coches.get(1);
		
		return mejoresCoches;
	}
}
