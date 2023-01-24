public class Animale {
    private String nome;
    private int numeroZampe;

    public Animale(String nome, int numeroZampe) {
        this.nome = nome;
        this.numeroZampe = numeroZampe;
    }

    public void stampa() {
        System.out.println("Nome animale: " + nome);
        System.out.println("Numero zampe: " + numeroZampe);
    }
}