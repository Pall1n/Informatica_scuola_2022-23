public class Casalinghi extends Merce {
    private String tipo;

    public Casalinghi(int numeroprogressivo, String descrizione, String codiceFornitore, int quantita, double prezzoUnitario, int scortaMinima, String tipo) {
        super(numeroprogressivo, descrizione, codiceFornitore, quantita, prezzoUnitario, scortaMinima);
        setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if(!tipo.equals("polvere") && !tipo.equals("liquido") && !tipo.equals("solido")) {
            throw new IllegalArgumentException("Tipo non valido");
        } else {
            this.tipo = tipo;
        }
    }
}