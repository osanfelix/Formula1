package formula1;

public class Carrera
{

	public static void main(String[] args) {
		

		try
		{
			// Coches de MCLaren
			Coche mac1 = new Coche("MP4-31", 190f, 6f, 8f,750f);
			Coche mac2 = new Coche("MP4-30", 175f, 6.5f, 7.5f,730f);
			Coche mac3 = new Coche("MP3-55", 170f, 7f, 7f,700f);
			
			// Coches de Renault
			Coche ren1 = new Coche("FW25", 170f, 7f, 8f,760f);
			Coche ren2 = new Coche("FW30", 180f, 8f, 7f,780f);
			
			// Coches de Ferrari
			Coche fer1 = new Coche("F138", 200f, 15f, 5f,710f);
			Coche fer2 = new Coche("F14T", 180f, 10f, 6f,70f);
			
			// Creamos las escuderia
			Escuderia mclaren = new Escuderia("Mclaren");
			Escuderia ferrari = new Escuderia("Ferrari");
			Escuderia renault = new Escuderia("Renault");
			
			// Añadir los coches a las escuderias
			mclaren.addCoche(mac1);
			mclaren.addCoche(mac2);
			mclaren.addCoche(mac3);
			
			renault.addCoche(ren1);
			renault.addCoche(ren2);
			
			ferrari.addCoche(fer1);
			ferrari.addCoche(fer2);
			
			
			// Creamos el circuito
			Circuito circuito = new Circuito("Circuito Internacional de Baréin", 5412, 57);
			
			// Apuntamos las escuderias al circuito/carrera
			circuito.apuntarEscuderia(mclaren);
			circuito.apuntarEscuderia(renault);
			circuito.apuntarEscuderia(ferrari);
			
			// Empezamos la carrera
			circuito.startRace();
		}
		catch(ConstruccioCotxeExcepcio ex){}	
	}
	
}
