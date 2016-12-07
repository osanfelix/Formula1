/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formula1;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Oscar
 */
public class Coche implements Comparable<Coche>
{
	protected Map<String, Float> params = new HashMap<>();
	protected Escuderia escuderia = null;
	protected String modelo = null;
	
	public Coche(String modelo, float velMedia, float factAcc, float factFren, float peso) throws ConstruccioCotxeExcepcio
	{
		if(velMedia == 0 || factAcc == 0 || factFren == 0 || peso == 0 )
		{
			// Get zero parameters
			// TODO 
			//return new ConstruccioCotxeExcepcio(new String[2]{"test1", "test2"});
		}
		this.modelo = modelo;
		params.put("velMedia", velMedia );
		params.put("factAcc", factAcc );
		params.put("factFren", factFren );
		params.put("peso", peso );
	}
	
	public float getCalidad()
	{
		return params.get("factFren") + (params.get("factAcc") + params.get("velMedia"))/params.get("peso");
	}

	@Override
	public int compareTo(Coche otro) {
		return (int)Math.round(getCalidad() - otro.getCalidad());
	}
}
