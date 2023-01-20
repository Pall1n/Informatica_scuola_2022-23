import java.util.Scanner;

public class Triangolo extends Forma {
    private double base, altezza;
    private String tipo;

    public Triangolo(String nome, String tipo, double base, double altezza) {
        super(nome);
        this.tipo = tipo;
        this.base = base;
        this.altezza = altezza;
    }

    public double perimetro() {
        if (tipo.equals("equilatero")) {
            return base * 3;
        } else if (tipo.equals("isoscele")) {
            return base + Math.sqrt(base/2 * base/2 + altezza * altezza)*2;
        } else {
            Scanner input = new Scanner(System.in);
            System.out.print("Inserisci un lato: ");
            double lato1 = input.nextDouble();
            System.out.print("Inserisci l'altro lato: ");
            double lato2 = input.nextDouble();
            return base + lato1 + lato2;
            input.close();
        }
    }

    public double area() {
        return base*altezza/2;
    }
}