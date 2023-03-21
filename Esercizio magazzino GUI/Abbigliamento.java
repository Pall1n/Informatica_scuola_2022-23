public class Abbigliamento extends Merce {
    private String taglia;
    private String colore;
    private String tipo;

    public Abbigliamento(int numeroprogressivo, String descrizione, String codiceFornitore, int quantita, double prezzoUnitario, int scortaMinima, String taglia, String colore, String tipo) {
        super(numeroprogressivo, descrizione, codiceFornitore, quantita, prezzoUnitario, scortaMinima);
        this.taglia = taglia;
        this.colore = colore;
        this.tipo = tipo;
    }

    public String getTaglia() {
        return taglia;
    }

    public void setTaglia(String taglia) {
        this.taglia = taglia;
    }

    public String getColore() {
        return colore;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}