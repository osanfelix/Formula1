/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

/**
 *
 * @author Oscar
 */
public class ConstruccioCotxeExcepcio extends Exception
{
	String[] parametrosQueFaltan = null;
	public ConstruccioCotxeExcepcio(String[] parametrosQueFaltan)
	{
		this.parametrosQueFaltan = parametrosQueFaltan;
	}
	
	@Override
	public String toString()
	{
		String out = "Error al crear el coche. Faltan por definir los siguientes parámetros:\n";
		for(String param : parametrosQueFaltan)
		{
			out += param + "\n";
		}
		
		return out;
	}
}