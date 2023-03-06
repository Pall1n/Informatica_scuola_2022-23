public class Furgone extends Veicolo {
    public int capacita;

    public Furgone(String motore, String targa, String marca, String nome, int capacita) {
        super(motore, targa, marca, nome);
        this.capacita = capacita;
    }

    public String toString() {
        return "Furgone: targa: " + targa + ", marca: " + marca + ", nome: " + nome + ", motore: " + motore + ", capacita: " + capacita;
    }
}
