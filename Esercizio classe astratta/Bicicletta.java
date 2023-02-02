public class Bicicletta extends Veicolo {
    public Bicicletta(int numero_ruote, int velocita_massima, String colore) {
        this.numero_ruote = numero_ruote;
        this.velocita_massima = velocita_massima;
        this.colore = colore;
    }

    public void accelera() {
        System.out.println("La bicicletta sta pedalando più velocemente.");
    }
}