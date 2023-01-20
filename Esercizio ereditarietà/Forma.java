public class Forma {
    private String nome;

    public Forma(String nome) {
        this.nome = nome;
    }

    public void stampa(double perimetro, double area) {
        System.out.println("Nome: " + nome);
        System.out.println("Perimetro: " + perimetro);
        System.out.println("Area: " + area);
    }
}