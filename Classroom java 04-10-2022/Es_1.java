// Costruire un vettore di N elementi con valori letti da tastiera e visualizzarli

import java.util.Scanner;

public class Es_1 {
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

        System.out.println("I valori del vettore sono: ");
        for (int i = 0; i < N; i++) {
            System.out.println(vettore[i]);
        }
    }
}