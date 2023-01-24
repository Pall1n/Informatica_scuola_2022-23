import java.util.Scanner;

public class Triangolo extends Forma {

    public Triangolo(String nome, String tipo, double base, double altezza) {
        super(nome);
        if (tipo.equals("equilatero")) {
            super.perimetro = base * 3;
        } else if (tipo.equals("isoscele")) {
            super.perimetro = base + Math.sqrt(base/2 * base/2 + altezza * altezza)*2;
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Inserisci un lato: ");
            double lato1 = input.nextDouble();
            System.out.print("Inserisci l'altro lato: ");
            double lato2 = input.nextDouble();
            input.close();
            super.perimetro = base + lato1 + lato2;
        }
        super.area = base*altezza/2;
    }

    public double perimetro() {
        return super.perimetro;
    }

    public double area() {
        return super.area;
    }
}