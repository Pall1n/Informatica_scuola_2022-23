import java.util.ArrayList;

public class Tombolone {
    private ArrayList<Integer> numeri_estratti = new ArrayList<Integer>();

    public int estraiNumero() {
        if(numeri_estratti.size() == 89) {
            return 0;
        }
        int numero = (int) (Math.random() * 90) + 1;
        while (numeri_estratti.contains(numero)) {
            numero = (int) (Math.random() * 90) + 1;
        }
        numeri_estratti.add(numero);
        return numero;
    }

    public int verificaVincita(Boolean vincite_uscite[]) {
        int contatore = 0, vincita = -1, contatore_tot = 0;
        for (int i = 0; i != 90; i+=30) {
            for(int l = 0; l < 3; l++) {
                for(int j = 1; j <= 5; j++) {
                    if(numeri_estratti.contains(l * 10 + j + i)) {
                        contatore++;
                        contatore_tot++;
                    }
                }
                if(contatore > 1 && vincite_uscite[(contatore - 1)] == false) {
                    vincita = contatore - 1;
                }
                contatore = 0;
            }
            if(contatore_tot == 15) {
                vincita = 0;
            }
            contatore_tot = 0;

            for(int l = 0; l < 3; l++) {
                for(int j = 6; j <= 10; j++) {
                    if(numeri_estratti.contains(l * 10 + j + i)) {
                        contatore++;
                        contatore_tot++;
                    }
                }
                if(contatore > 1 && vincite_uscite[(contatore - 1)] == false) {
                    vincita = contatore - 1;
                }
                contatore = 0;
            }
            if(contatore_tot == 15) {
                vincita = 0;
            }
            contatore_tot = 0;
        }
        return vincita;
    }

    public void stampaTombolone() {
        System.out.println("-----------------------------------");
        System.out.print("| ");
        for(int i = 1; i <= 90; i++) {
            if(numeri_estratti.contains(i)) {
                if(i < 10) {
                    System.out.print("X  ");
                } else {
                    System.out.print("XX ");
                }
            } else {
                if(i < 10) {
                    System.out.print(i + "  ");
                } else {
                    System.out.print(i + " ");
                }
            }
            if(i % 5 == 0 && i % 10 != 0) {
                System.out.print("| ");
            } else if(i % 30 == 0 && i != 90) {
                System.out.println("|");
                System.out.println("|----------------|----------------|");
                System.out.print("| ");
            } else if(i % 10 == 0 && i != 90) {
                System.out.println("|");
                System.out.print("| ");
            }
        }
        System.out.println("|");
        System.out.println("-----------------------------------");
    }
}