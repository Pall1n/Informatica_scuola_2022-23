public class Merce {
    private int numeroprogressivo;
    private String descrizione;
    private String codiceFornitore;
    private int quantita;
    private double prezzoUnitario;
    private int scortaMinima;

    public Merce(int numeroprogressivo, String descrizione, String codiceFornitore, int quantita, double prezzoUnitario, int scortaMinima) {
        this.numeroprogressivo = numeroprogressivo;
        this.descrizione = descrizione;
        this.codiceFornitore = codiceFornitore;
        this.scortaMinima = scortaMinima;
        if(scortaMinima < 0) {
            throw new IllegalArgumentException("Scorta minima non valida");
        }
        this.quantita = quantita;
        this.prezzoUnitario = prezzoUnitario;
    }

    public int getNumeroprogressivo() {
        return numeroprogressivo;
    }

    public void setNumeroprogressivo(int numeroprogressivo) {
        this.numeroprogressivo = numeroprogressivo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodiceFornitore() {
        return codiceFornitore;
    }

    public void setCodiceFornitore(String codiceFornitore) {
        this.codiceFornitore = codiceFornitore;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public double getPrezzoUnitario() {
        return prezzoUnitario;
    }

    public void setPrezzoUnitario(double prezzoUnitario) {
        this.prezzoUnitario = prezzoUnitario;
    }

    public int getScortaMinima() {
        return scortaMinima;
    }

    public void setScortaMinima(int scortaMinima) {
        this.scortaMinima = scortaMinima;
    }
}