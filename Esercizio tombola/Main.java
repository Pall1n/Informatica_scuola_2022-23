import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static int vincitore;

    public static void main(String[] args) throws Exception {
        int numero_cartelle;
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il numero di cartelle: ");
        numero_cartelle = input.nextInt();
        Cartella[] cartelle = new Cartella[numero_cartelle];
        for (int i = 0; i < numero_cartelle; i++) {
            cartelle[i] = new Cartella();
        }

        Tombolone tombolone = new Tombolone();
        tombolone.stampaTombolone();

        for (int i = 0; i < numero_cartelle; i++) {
            cartelle[i].stampaCartella();
        }
        int numero_estratto, vincita = -1;
        String vincite[] = {"Tombola", "Ambo", "Terno", "Quaterna", "Cinquina"};
        Boolean vincite_uscite[] = {false, false, false, false, false};
        final String os = System.getProperty("os.name");

        do {
            System.out.print("Premi qualsiasi cosa per estrarre un numero: ");
            input.nextLine();
            numero_estratto = tombolone.estraiNumero();

            if (os.contains("Windows")) {
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Numero estratto: " + numero_estratto);
            vincita = tombolone.verificaVincita(vincite_uscite);
            tombolone.stampaTombolone();
            System.out.println();
            for (int i = 0; i < numero_cartelle; i++) {
                cartelle[i].verificaNumero(numero_estratto);
            }
            for (int i = 0; i < numero_cartelle; i++) {
                vincita = cartelle[i].verificaVincita(vincite_uscite);
                if (vincita != -1) {
                    System.out.println("Cartella " + (i + 1) + " ha fatto " + vincite[vincita]);
                    vincite_uscite[vincita] = true;
                    if(vincita == 0) {
                        vincitore = i;
                    }
                }
                cartelle[i].stampaCartella();
                System.out.println();
            }
        } while (vincita != 0);

        System.out.println("La cartella " + (vincitore + 1) + " ha vinto la tombola!");

        input.close();
    }
}
