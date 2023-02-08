/*
    Scrivi un programma che simuli il lancio di un dado e di una moneta 
    stampandone il risultato con l'utilizzo di una classe astratta che 
    rappresenti i comportamenti comuni degli oggetti dado e moneta istanziati.
*/

public class Es_2 {
    public static void main(String[] args) {
        Dado dado = new Dado();
        Moneta moneta = new Moneta();
        dado.stampaRisultato();
        moneta.stampaRisultato();
    }
}

abstract class OggettoCasuale {
    public void stampaRisultato() {
        System.out.println("Risultato: " + lancio());
    }

    public abstract int lancio();
}

class Dado extends OggettoCasuale {
    public int lancio() {
        return (int) (Math.random() * 6) + 1;
    }
}

class Moneta extends OggettoCasuale {
    public int lancio() {
        return (int) (Math.random() * 2) + 1;
    }
}