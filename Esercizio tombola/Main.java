import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class Main {
    private static int vincitore = -2;

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
        int numero_estratto, vincita;
        String vincite[] = {"Tombola", "Ambo", "Terno", "Quaterna", "Cinquina"};
        Boolean vincite_uscite[] = {false, false, false, false, false};
        ArrayList<Integer> numeri_vincite = new ArrayList<Integer>();
        final String os = System.getProperty("os.name");

        while(vincitore == -2) {
            System.out.print("Premi invio per estrarre un numero: ");
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

            System.out.println("Numero estratto: \u001B[4;36m" + numero_estratto + "\u001B[0m");
            vincita = tombolone.verificaVincita(vincite_uscite);
            tombolone.stampaTombolone();
            System.out.println();
            for (int i = 0; i < numero_cartelle; i++) {
                cartelle[i].verificaNumero(numero_estratto);
            }
            for (int i = 0; i < numero_cartelle; i++) {
                vincita = cartelle[i].verificaVincita(vincite_uscite);
                if (vincita > -1) {
                    numeri_vincite.add(i);
                    if(vincita == 0) {
                        vincitore = i;
                    }
                }
                cartelle[i].stampaCartella();
                System.out.println();
            }

            vincita = tombolone.verificaVincita(vincite_uscite);
            if (vincita > -1) {
                numeri_vincite.add(-1);
                if(vincita == 0) {
                    vincitore = -1;
                }
            }

            if(numeri_vincite.size() > 0 && vincita > -1) {
                System.out.print("\u001B[1;31mHanno fatto " + vincite[vincita] + ": ");
                for (int i = 0; i < numeri_vincite.size(); i++) {
                    if(numeri_vincite.get(i) == -1) {
                        System.out.print("Tombolone");
                    } else {
                        System.out.print("Cartella " + (numeri_vincite.get(i) + 1));
                    }
                    if(i != numeri_vincite.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("\u001B[0m");
                vincite_uscite[vincita] = true;
            }

            numeri_vincite.clear();
        }

        input.close();

        if(vincitore == -1) {
            System.out.println("\u001B[33mIl tombolone ha vinto la tombola!\u001B[0m");
        } else {
            System.out.println("\u001B[33mLa cartella " + (vincitore + 1) + " ha vinto la tombola!\u001B[0m");
        }
    }
}
