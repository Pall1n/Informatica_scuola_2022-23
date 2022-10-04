// Caricare un vettore di N posizioni, stampando la somma dei suoi elementi

import java.util.Scanner;

public class Es_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N;

        System.out.print("Inserisci il numero di elementi del vettore: ");
        N = input.nextInt();
        int[] vettore = new int[N];

        for (int i = 0; i < N; i++) {
            System.out.print("Inserisci il valore dell'elemento " + i + ": ");
            vettore[i] = input.nextInt();
        }

        input.close();

        int somma = 0;
        for (int i = 0; i < N; i++) {
            somma += vettore[i];
        }

        System.out.println("La somma dei valori del vettore è: " + somma);
    }
}