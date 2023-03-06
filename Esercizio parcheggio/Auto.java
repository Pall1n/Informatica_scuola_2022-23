public class Auto extends Veicolo {
    public int posti;
    public int porte;

    public Auto(String motore, String targa, String marca, String nome, int posti, int porte) {
        super(motore, targa, marca, nome);
        this.posti = posti;
        this.porte = porte;
    }

    public String toString() {
        return "Auto: targa: " + targa + ", marca: " + marca + ", nome: " + nome + ", motore: " + motore + ", posti: " + posti + ", porte: " + porte;
    }
}
