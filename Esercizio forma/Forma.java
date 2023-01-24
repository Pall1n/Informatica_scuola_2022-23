public class Forma {
    private String nome;
    protected double perimetro, area;

    public Forma(String nome) {
        this.nome = nome;
    }

    public void stampa() {
        System.out.println("Nome: " + nome);
        System.out.println("Perimetro: " + perimetro);
        System.out.println("Area: " + area);
    }

    public double perimetro() {
        return perimetro;
    }

    public double area() {
        return area;
    }
}