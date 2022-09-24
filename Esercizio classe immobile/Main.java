/*
    Creare una classe immobile con i relativi attributi (come il numero di stanze) 
    e con almeno due metodi a vostra scelta. Implementare tre oggetti da esso.
*/

public class Main {
    public static void main(String[] args) {
        Immobile casa = new Immobile(200, 7, 3, 2, 5);
        System.out.println("\nCasa:\n");
        casa.stampaInfo();
        casa.setMetriQuadri(150);
        casa.setNumeroStanzeTotali(5);
        System.out.println("\nIn questa casa ci sono " + casa.getMetriQuadri() + " bagni");

        System.out.println("\n--------------------");

        Immobile appartamento = new Immobile(80, 5, 1, 1, 2);
        System.out.println("Appartamento:\n");
        appartamento.stampaInfo();
        appartamento.setNumeroBagni(2);
        appartamento.setNumeroPiani(2);
        System.out.println("\nIn questo appartamento ci sono " + appartamento.getNumeroBalconi() + " balconi");

        System.out.println("\n--------------------");

        Immobile casetta = new Immobile(50, 3, 1, 1, 0);
        System.out.println("Casetta:\n");
        casetta.stampaInfo();
        casetta.setNumeroStanzeTotali(4);
        casetta.setNumeroBalconi(2);
        System.out.println("\nIn questa casetta ci sono " + casetta.getNumeroBagni() + " bagni\n");
    }
}