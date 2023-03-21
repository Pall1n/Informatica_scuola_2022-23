import java.util.Date;

public class Alimentari extends Merce {
    private Date dataScadenza;
    private boolean contieneLattosio;
    private boolean contieneGlutine;

    public Alimentari(int numeroprogressivo, String descrizione, String codiceFornitore, int quantita, double prezzoUnitario, int scortaMinima, Date dataScadenza, boolean contieneLattosio, boolean contieneGlutine) {
        super(numeroprogressivo, descrizione, codiceFornitore, quantita, prezzoUnitario, scortaMinima);
        this.dataScadenza = dataScadenza;
        this.contieneLattosio = contieneLattosio;
        this.contieneGlutine = contieneGlutine;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public boolean contieneLattosio() {
        return contieneLattosio;
    }

    public void setContieneLattosio(boolean contieneLattosio) {
        this.contieneLattosio = contieneLattosio;
    }

    public boolean contieneGlutine() {
        return contieneGlutine;
    }

    public void setContieneGlutine(boolean contieneGlutine) {
        this.contieneGlutine = contieneGlutine;
    }
}