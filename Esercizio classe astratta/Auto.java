public class Auto extends Veicolo {
    public Auto(int numero_ruote, int velocita_massima, String colore) {
        this.numero_ruote = numero_ruote;
        this.velocita_massima = velocita_massima;
        this.colore = colore;
    }

    public void accelera() {
        System.out.println("L'auto sta accelerando");
    }
}