import java.util.ArrayList;

public class Tombolone {
    private ArrayList<Integer> numeri_estratti = new ArrayList<Integer>();

    public void stampaTombolone() {
        numeri_estratti.add(2);
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
                if(i % 5 == 0 && i % 10 != 0) {
                    System.out.print("| ");
                }
            }
            if(i % 30 == 0 && i != 90) {
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