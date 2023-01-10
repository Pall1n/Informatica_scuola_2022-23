public class Palazzo {
    private int nPiani, mq, nCivico, cap;
    private String via, citta;

    public Palazzo(int nPiani, int mq, String via, int nCivico, String citta, int cap) {
        this.nPiani = setNumPiani(nPiani);
        this.mq = setMq(mq);
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
        System.out.println("Indirizzo: " + via + " " + nCivico + ", " + citta + " (" + cap + ")");
        System.out.println("Numero piani: " + nPiani);
        System.out.println("Superficie: " + mq + " mq");
        System.out.println("Valore complessivo: " + calcValore(valMq) + " euro");
        System.out.println("Valore per singolo appartamento: " + calcValore(valMq) / nPiani + " euro");
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

    public String getIndirizzo() {
        return (via + " " + nCivico + ", " + citta + " (" + cap + ")");
    }
}