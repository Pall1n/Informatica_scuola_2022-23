public class Immobile{
    private String tipoImmobile;
    private int metriQuadri, vetusta, totaleValore, redidenzaValoremq = 700, pertinenzaValoremq = 500, commercialevaloremq = 950;
    private int residenziaCorrettivoVetusta10_20 = 15, residenziaCorrettivoVetusta20_oltre = 27, pertinenzaCorrettivoVetusta10_20 = 10, pertinenzaCorrettivoVetusta20_oltre = 18, commercialeCorrettivoVetusta10_20 = 13, commercialeCorrettivoVetusta20_oltre = 22;

    public Immobile(String tipoImmobile, int metriQuadri, int vetusta) throws Exception{
        setMetriQuadri(metriQuadri);
        setTipoImmobile(tipoImmobile);
        setVetusta(vetusta);
    }

    public void setTipoImmobile(String tipo) throws Exception {
        if(tipo.equals("residenza")) {
            this.tipoImmobile = tipo;
        } else if(tipo.equals("pertinenza")) {
            this.tipoImmobile = tipo;
        } else if(tipo.equals("commerciale")) {
            this.tipoImmobile = tipo;
        } else {
            throw new Exception("Tipo inserito non valido");
        }
    }

    public void setMetriQuadri(int mq) throws Exception {
        if(mq > 0) {
            this.metriQuadri = mq;
        } else {
            throw new Exception("Metri quadrati inseriti non validi");
        }
    }

    public void setVetusta(int vet) throws Exception {
        if(vet > 0 && vet < 30) {
            this.vetusta = vet;
        } else {
            throw new Exception("Il valore della vetusta deve essere compreso tra 1 e 30 (inclusi)");
        }
    }

    public int getValoreImmobile() {
        if(totaleValore == 0) {
            calcValoreImmobile();
        }
        return totaleValore;
    }

    public int getTasseRegistro() {
        if(totaleValore == 0) {
            calcValoreImmobile();
        }
        try {
            return (totaleValore/100)*6;
        } catch (Exception e) {
            System.out.print("Errore nel calcolo delle tasse di registro: " + e.getMessage());
            return 0;
        }
    }

    public int getCanoneAffitto() {
        if(totaleValore == 0) {
            calcValoreImmobile();
        }
        try {
            if(tipoImmobile.equals("residenza") || tipoImmobile.equals("pertinenza")){
                return metriQuadri * 7;
            }else if(tipoImmobile.equals("commerciale")){
                return metriQuadri * 9;
            } else {
                throw new Exception("Tipo di immobile non definibile");
            }
        } catch(Exception e) {
            System.out.print("Errore nel calcolo del canone di affitto: " + e.getMessage());
            return 0;
        }
    }

    private void calcValoreImmobile(){
        try {
            int valore = 0;
            if(tipoImmobile.equals("residenza")){
                valore = (metriQuadri * redidenzaValoremq);
                valore = calcoloCorrettivoVetusta(valore);
            }else if(tipoImmobile.equals("pertinenza")){
                valore = metriQuadri * pertinenzaValoremq;
                valore = calcoloCorrettivoVetusta(valore);
            }else if(tipoImmobile.equals("commerciale")){
                valore = metriQuadri * commercialevaloremq;
                valore = calcoloCorrettivoVetusta(valore);
            }
            totaleValore = valore;
        } catch (Exception e) {
            System.out.println("Errore nel calcolo del valore: " + e.getMessage());
            totaleValore = -1;
        }
    }

    private int calcoloCorrettivoVetusta(int valore){
        try {
            if(vetusta >= 10 && vetusta < 20){
                if(tipoImmobile.equals("residenza")){
                    valore -= (valore/100) * residenziaCorrettivoVetusta10_20;
                }else if(tipoImmobile.equals("pertinenza")){
                    valore -= (valore/100) * pertinenzaCorrettivoVetusta10_20;
                }else if(tipoImmobile.equals("commerciale")){
                    valore -= (valore/100) * commercialeCorrettivoVetusta10_20;
                }
            }else if(vetusta >= 20 && vetusta < 30){
                if(tipoImmobile.equals("residenza")){
                    valore -= (valore/100) * residenziaCorrettivoVetusta20_oltre;
                }else if(tipoImmobile.equals("pertinenza")){
                    valore -= (valore/100) * pertinenzaCorrettivoVetusta20_oltre;
                }else if(tipoImmobile.equals("commerciale")){
                    valore -= (valore/100) * commercialeCorrettivoVetusta20_oltre;
                }
            }
            return valore;
        } catch (Exception e) {
            System.out.println("Errore nel calcolo del percentuale della vestuta: " + e.getMessage());
            return -1;
        }
    }
}