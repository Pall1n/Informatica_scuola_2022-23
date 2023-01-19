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
                if((numeri.get(j)-1) / 10 == decina) {
                    contatore++;
                }
            }
            if (contatore > 3) {
                numeri.remove(i);
                i--;
            }
        }

        int numero, decina, row;

        for (int i = 0; i < 15; i++) {
            numero = numeri.get(i);
            decina = numero / 10;
            int contatore = 0;
            if (numero % 10 == 0) {
                decina--;
            }
            do {
                row = 0;
                for (int j = 0; j < 3; j++) {
                    contatore = 0;
                    for(int l = 0; l < 9; l++) {
                        if (numeri_ordinati[j][l] != 0) {
                            contatore++;
                        }
                    }
                    if (contatore < 5) {
                        if (numeri_ordinati[j][decina] == 0) {
                            numeri_ordinati[j][decina] = numero;
                            break;
                        } else {
                            row = j;
                        }
                    }
                }
                if (row == 2) {
                    int where_to_move = 0;
                    for(int k = 0; k < 3; k++) {
                        if(numeri_ordinati[k][decina] == 0) {
                            where_to_move = k;
                            break;
                        }
                    }
                    for(int k = 0; k < 9; k++) {
                        if(numeri_ordinati[where_to_move][k] != 0 && numeri_ordinati[2][k] == 0) {
                            numeri_ordinati[2][k] = numeri_ordinati[where_to_move][k];
                            numeri_ordinati[where_to_move][k] = 0;
                            break;
                        }
                    }
                }
            } while (row == 2);
        }
    }

    public void verificaNumero (int numero) {
        int decina = numero / 10;
        if (decina == 9) {
            decina--;
        }
        for (int i = 0; i < 3; i++) {
            if (numeri_ordinati[i][decina] == numero) {
                numeri_ordinati[i][decina] = -1;
            }
        }
    }

    public int verificaVincita(Boolean vincite_uscite[]) {
        int contatore = 0, vincita = -1, contatore_tot = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                if (numeri_ordinati[i][j] == -1) {
                    contatore++;
                    contatore_tot++;
                }
            }
            if(contatore > 1 && vincite_uscite[(contatore - 1)] == false) {
                vincita = contatore - 1;
                break;
            }
            contatore = 0;
        }
        if(contatore_tot == 15) {
            vincita = 0;
        }
        return vincita;
    }

    public void stampaCartella() {
        System.out.println("----------------------------------------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 9; j++) {
                if(numeri_ordinati[i][j] == 0) {
                    if(j == 0) {
                        System.out.print("    ");
                    } else {
                        System.out.print("    ");
                    }
                } else if(numeri_ordinati[i][j] == -1) {
                    if(j == 0) {
                        System.out.print("\u001B[36m  X \u001B[0m");
                    } else {
                        System.out.print("\u001B[36m XX \u001B[0m");
                    }
                } else {
                    if(numeri_ordinati[i][j] < 10) {
                        System.out.print(" 0" + numeri_ordinati[i][j] + " ");
                    } else {
                        System.out.print(" " + numeri_ordinati[i][j] + " ");
                    }
                }
                System.out.print("|");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }
}