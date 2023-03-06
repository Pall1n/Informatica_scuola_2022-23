public class Moto extends Veicolo {
    public int cilindrata;

    public Moto(String motore, String targa, String marca, String nome, int cilindrata) {
        super(motore, targa, marca, nome);
        this.cilindrata = cilindrata;
    }

    public String toString() {
        return "Moto: targa: " + targa + ", marca: " + marca + ", nome: " + nome + ", motore: " + motore + ", cilindrata: " + cilindrata;
    }
}
