import java.util.ArrayList;

public class Cartella {
    private int numeri_ordinati[][] = new int[3][9];

    public Cartella() {
        ArrayList<Integer> numeri = new ArrayList<Integer>();

        for (int i = 0; i < 15; i++) {
            int numero = (int) (Math.random() * 90) + 1;
            while (numeri.contains(numero)) {
                numero = (int) (Math.random() * 90) + 1;
            }
            numeri.add(numero);

            int decina = numero / 10;
            int contatore = 0;
            for (int j = 0; j < numeri.size(); j++) {
                if (numeri.get(j) / 10 == decina) {
                    contatore++;
                }
            }
            if (contatore > 3) {
                numeri.remove(i);
                i--;
            }
        }

        for (int i = 0; i < 15; i++) {
            int numero = numeri.get(i);
            int decina = numero / 10;
            if (decina == 9) {
                decina--;
            }
            for (int j = 0; j < 3; j++) {
                int contatore = 0;
                for(int l = 0; l < 9; l++) {
                    if (numeri_ordinati[j][l] != 0) {
                        contatore++;
                    }
                }
                if (contatore < 5) {
                    if (numeri_ordinati[j][decina] == 0) {
                        numeri_ordinati[j][decina] = numero;
                        break;
                    }
                }
            }
        }
    }

    public void stampaCartella() {
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                if(numeri_ordinati[i][j] == 0) {
                    if(j == 0) {
                        System.out.print("   ");
                    } else {
                        System.out.print("    ");
                    }
                } else {
                    System.out.print(" " + numeri_ordinati[i][j] + " ");
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------");
    }
}