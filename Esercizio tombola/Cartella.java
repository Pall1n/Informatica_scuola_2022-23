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
            switch (contatore) {
                case 5:
                    if(vincite_uscite[4] == false) {
                        vincita = 4;
                    }
                    break;
                case 4:
                    if(vincite_uscite[3] == false) {
                        vincita = 3;
                    }
                    break;
                case 3:
                    if(vincite_uscite[2] == false) {
                        vincita = 2;
                    }
                    break;
                case 2:
                    if(vincite_uscite[1] == false) {
                        vincita = 1;
                    }
                    break;
                default:
                    break;
            }
            contatore = 0;
        }
        if(contatore_tot == 15) {
            if(vincite_uscite[0] == false) {
                vincita = 0;
            }
        }
        return vincita;
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
                } else if(numeri_ordinati[i][j] == -1) {
                    if(j == 0) {
                        System.out.print(" X ");
                    } else {
                        System.out.print(" XX ");
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