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
        return 0;
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