/*
    Implementare una classe che rappresenti le caratteristiche e le funzionalità 
    di un computer. Di questa classe implementare due metodi, uno che stampi le 
    caratteristiche dell'oggetto e l'altro per il potenziamento della RAM: dato 
    in ingresso il numero di Gigabyte aggiuntivi ne registri l'incremento sull'oggetto. 
    Implementare, inoltre, all'interno del metodo main più oggetti, cioè più computer 
    con caratteristiche diverse e per ogni caso richiamare i metodi.
*/

public class Main {
    public static void main(String[] args) {
        Computer pc = new Computer("i7-12700k", "MSI TOMAHAWK Z690 DDR4 WI-FI", "Nvdia GeForce RTX 3080 TI",
                "Seasonic gold 850w", "Noctua NH-D15", "NZXT H510", 0, 1, new int[] {16, 32, 0, 0},
                new int[] {}, new int[] {1024}, 2, 4);
        pc.printSpecs();
        pc.upgradeRam(32);

        System.out.println("--------------------------------------------");

        Computer pc2 = new Computer("R7-5800x3D", "Asus ROG Strix X570-F", "AMD Radeon RX 6900 XT",
                "Corsair 850w", "Artic Freezer 50 TR", "Corsair Carbide 275Q", 1, 0, new int[] {32, 32, 0, 0},
                new int[] {512}, new int[] {}, 2, 4);
        pc2.printSpecs();
        pc2.upgradeRam(16);

        System.out.println("--------------------------------------------");

        Computer pc3 = new Computer("i5-11600k", "Asus TUF Z590-PLUS", "Gigabyte GeForce RTX 3060",
                "Corsair RM850x", "ARCTIC Liquid Freezer II 240", "Cooler Master MasterBox MB511", 1, 1, new int[] {8, 8, 0, 0},
                new int[] {512}, new int[] {1024}, 2, 4);
        pc3.printSpecs();
        pc3.upgradeRam(8);
        pc3.upgradeRam(16);
    }
}