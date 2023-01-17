import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int numero_cartelle;
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero di cartelle: ");
        numero_cartelle = input.nextInt();
        Cartella[] cartelle = new Cartella[numero_cartelle];
        for (int i = 0; i < numero_cartelle; i++) {
            cartelle[i] = new Cartella();
        }
        for (int i = 0; i < numero_cartelle; i++) {
            cartelle[i].stampaCartella();
        }
        input.close();
    }
}
