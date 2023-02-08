/*
    Realizza un programma che sia in grado di valutare il volume di oggetti 
    tridimensionali come cilindri e parallelepipedi basandosi sul valore 
    della loro area e dell'altezza. Delegare i metodi comuni, come il calcolo 
    e la stampa del volume ad una classe astratta.
*/

public class Es_1 {
    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro(10, 5);
        Parallelepipedo parallelepipedo = new Parallelepipedo(10, 5, 2);
        cilindro.stampaVolume();
        parallelepipedo.stampaVolume();
    }
}

class Cilindro extends OggettoTridimensionale {
    private double raggio;
    private double altezza;

    public Cilindro(double raggio, double altezza) {
        this.raggio = raggio;
        this.altezza = altezza;
    }

    public double calcolaVolume() {
        return Math.PI * Math.pow(raggio, 2) * altezza;
    }
}

class Parallelepipedo extends OggettoTridimensionale {
    private double a;
    private double b;
    private double c;

    public Parallelepipedo(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcolaVolume() {
        return a * b * c;
    }
}

abstract class OggettoTridimensionale {
    public void stampaVolume() {
        System.out.println("Volume: " + calcolaVolume());
    }

    public abstract double calcolaVolume();
}