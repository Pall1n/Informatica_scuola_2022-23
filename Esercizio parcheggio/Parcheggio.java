public class Parcheggio {
    private Veicolo[] parcheggio;

    public Parcheggio() {
        parcheggio = new Veicolo[12];
    }

    public boolean addVeicolo(Veicolo v) {
        for (int i = 0; i < parcheggio.length; i++) {
            if (parcheggio[i] == null) {
                parcheggio[i] = v;
                return true;
            }
        }
        return false;
    }

    public boolean removeVeicolo(int i) {
        if (parcheggio[i] != null) {
            parcheggio[i] = null;
            return true;
        }
        return false;
    }

    public void getParcheggio() {
        for (int i = 0; i < parcheggio.length; i++) {
            if (parcheggio[i] != null) {
                System.out.println(i + ") " + parcheggio[i].toString());
            } else {
                System.out.println(i + ") Posto vuoto");
            }
        }
    }
}