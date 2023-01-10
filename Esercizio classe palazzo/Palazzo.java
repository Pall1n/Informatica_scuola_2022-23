public class Palazzo {
    private final String RESET_COLOR = "\u001B[0m";
    private int nPiani, mq, nCivico, cap;
    private String via, citta;

    public Palazzo(int nPiani, int mq, String via, int nCivico, String citta, int cap) {
        setNumPiani(nPiani);
        setMq(mq);
        this.via = via;
        this.nCivico = nCivico;
        this.cap = cap;
        this.citta = citta;
    }

    public void setNumPiani(int nPiani) {
        if(nPiani >= 3 && nPiani <= 30) {
            this.nPiani = nPiani;
        } else {
            throw new IllegalArgumentException("Numero di piani non valido");
        }
    }

    public void setMq(int mq) {
        if(mq > 0 && mq <= 200) {
            this.mq = mq;
        } else {
            throw new IllegalArgumentException("Dimensione superficie non valida");
        }
    }

    public float calcValore(float valMq) {
        if(valMq > 0) {
            return (float) (valMq * mq * nPiani);
        }
        return 0;
    }

    public void stampaInfo(float valMq) {
        System.out.println("\u001B[36mIndirizzo: \u001B[4;36m" + via + " " + nCivico + ", " + citta + " (" + cap + ")" + RESET_COLOR);
        System.out.println("\u001B[34mNumero piani: \u001B[1;34m" + nPiani + RESET_COLOR);
        System.out.println("\u001B[31mSuperficie: \u001B[1;31m" + mq + "\u001B[0;31m mq" + RESET_COLOR);
        System.out.println("\u001B[32mValore complessivo: \u001B[1;32m" + calcValore(valMq) + "\u001B[0;32m euro");
        System.out.println("Valore per singolo appartamento: \u001B[1;32m" + calcValore(valMq) / nPiani + "\u001B[0;32m euro" + RESET_COLOR);
    }

    public String getIndirizzo() {
        return ("\u001B[1;36m" + via + " " + nCivico + ", " + citta + " (" + cap + ")" + RESET_COLOR);
    }

    public int getnPiani() {
        return nPiani;
    }

    public int getMq() {
        return mq;
    }

    public int getnCivico() {
        return nCivico;
    }

    public int getCap() {
        return cap;
    }

    public String getVia() {
        return via;
    }

    public String getCitta() {
        return citta;
    }
}