/*
    Creare una classe immobile con i relativi attributi (come il numero di stanze) 
    e con almeno due metodi a vostra scelta. Implementare tre oggetti da esso.
*/

public class Immobile {
    private int metriQuadri;
    private int numeroStanzeTotali;
    private int numeroBagni;
    private int numeroPiani;
    private int numeroBalconi;

    public Immobile(int metriQuadri, int numeroStanzeTotali, int numeroBagni, int numeroPiani, int numeroBalconi) {
        this.metriQuadri = metriQuadri;
        this.numeroStanzeTotali = numeroStanzeTotali;
        this.numeroBagni = numeroBagni;
        this.numeroPiani = numeroPiani;
        this.numeroBalconi = numeroBalconi;
    }

    public void stampaInfo() {
        System.out.println("Metri quadri: " + metriQuadri);
        System.out.println("Numero stanze totali: " + numeroStanzeTotali);
        System.out.println("Numero bagni: " + numeroBagni);
        System.out.println("Numero piani: " + numeroPiani);
        System.out.println("Numero balconi: " + numeroBalconi);
    }

    public int getMetriQuadri() {
        return metriQuadri;
    }

    public void setMetriQuadri(int metriQuadri) {
        if(metriQuadri > 0) {
            this.metriQuadri = metriQuadri;
        } else {
            System.out.println("Numero metri quadri non valido, riprova!");
        }
    }

    public int getNumeroStanzeTotali() {
        return numeroStanzeTotali;
    }

    public void setNumeroStanzeTotali(int numeroStanzeTotali) {
        if(numeroStanzeTotali > 0) {
            this.numeroStanzeTotali = numeroStanzeTotali;
        } else {
            System.out.println("Numero stanze totali non valido, riprova!");
        }
    }

    public int getNumeroBagni() {
        return numeroBagni;
    }

    public void setNumeroBagni(int numeroBagni) {
        if(numeroBagni > 0) {
            this.numeroBagni = numeroBagni;
        } else {
            System.out.println("Numero bagni non valido, riprova!");
        }
    }

    public int getNumeroPiani() {
        return numeroPiani;
    }

    public void setNumeroPiani(int numeroPiani) {
        if(numeroPiani > 0) {
            this.numeroPiani = numeroPiani;
        } else {
            System.out.println("Numero piani non valido, riprova!");
        }
    }

    public int getNumeroBalconi() {
        return numeroBalconi;
    }

    public void setNumeroBalconi(int numeroBalconi) {
        if(numeroBalconi >= 0) {
            this.numeroBalconi = numeroBalconi;
        } else {
            System.out.println("Numero balconi non valido, riprova!");
        }
    }
}