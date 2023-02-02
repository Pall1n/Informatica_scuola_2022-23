public abstract class Veicolo {
    public int numero_ruote;
    public int velocita_massima;
    public String colore;

    public abstract void accelera();

    public void setRuote(int numero_ruote) {
        this.numero_ruote = numero_ruote;
    }

    public int getRuote() {
        return numero_ruote;
    }

    public void setVelocitaMassima(int velocita_massima) {
        this.velocita_massima = velocita_massima;
    }

    public int getVelocitaMassima() {
        return velocita_massima;
    }

    public void setColore(String colore) {
        this.colore = colore;
    }

    public String getColore() {
        return colore;
    }
}