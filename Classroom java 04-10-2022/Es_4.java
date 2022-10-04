// Dato un vettore di N elementi, determinare se ciascun elemento è pari o dispari

import java.util.Scanner;

public class Es_4 {
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

        for (int i = 0; i < N; i++) {
            if (vettore[i] % 2 == 0) {
                System.out.println("L'elemento all'indice " + i + " è pari");
            } else {
                System.out.println("L'elemento all'indice" + i + " è dispari");
            }
        }
    }
}