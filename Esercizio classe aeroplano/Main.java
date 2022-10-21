/*
    Implementare la classe aeroplano con i seguenti attributi: velocità massima, 
    velocità di crociera, nome aereo, numero di motori. Implementare il metodo info
*/

public class Main
{
	public static void main(String[] args) {
		Aeroplano aeroplano = new Aeroplano(1400, 1000, "Boeing 747", 10);
		System.out.println("Velocità massima: " + aeroplano.getVelMassima());
		aeroplano.setVelMassima(1500);
		aeroplano.setName("Boeing 737");
		
		System.out.println("-----------------------------------");
		aeroplano.info();
	}
}
