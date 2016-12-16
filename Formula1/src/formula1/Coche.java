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
	protected Map<String, Float> _params = new HashMap<>();
	protected Escuderia _escuderia = null;
	protected String _modelo = null;
	
	public Coche(String modelo, float velMedia, float factAcc, float factFren, float peso) throws ConstruccioCotxeExcepcio
	{
		if(velMedia == 0 || factAcc == 0 || factFren == 0 || peso == 0 )
		{
			// Get zero parameters
			// TODO 
			//return new ConstruccioCotxeExcepcio(new String[2]{"test1", "test2"});
		}
		_modelo = modelo;
		_params.put("velMedia", velMedia );
		_params.put("factAcc", factAcc );
		_params.put("factFren", factFren );
		_params.put("peso", peso );
	}
	
	public String getModelo()
	{
		return _modelo;
	}
	public float getCalidad()
	{
		return _params.get("factFren") + (_params.get("factAcc") + _params.get("velMedia"))/_params.get("peso");
	}

	public void setEscuderia(Escuderia escuderia)
	{
		_escuderia = escuderia;
	}
	
	public Escuderia getEscuderia()
	{
		return _escuderia;
	}
	@Override
	public int compareTo(Coche otro) {
		return (int)Math.round(getCalidad() - otro.getCalidad());
	}
}
