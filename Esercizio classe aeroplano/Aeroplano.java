/*
    Implementare la classe aeroplano con i seguenti attributi: velocità massima, 
    velocità di crociera, nome aereo, numero di motori. Implementare il metodo info
*/

public class Aeroplano{
    private int vel_massima;
    private int vel_crociera;
    private String nome;
    private int num_motori;
    
    public Aeroplano(int vel_massima, int vel_crociera, String nome, int num_motori) {
        if(this.vel_massima > 2000) {
            throw new IllegalArgumentException("La velocità massima supera il limite consentito (2000)");
        } else {
            this.vel_massima = vel_massima;
        }
        if(vel_crociera >= vel_massima) {
            throw new IllegalArgumentException("La velocità di crociera non può essere superiore della velocità massima (" + vel_massima + ")");
        } else {
            this.vel_crociera = vel_crociera;
        }
        this.nome = nome;
        if(num_motori <= 0) {
            throw new IllegalArgumentException("Il numero dei motori non deve essere negativo o pari a 0!");
        } else {
            this.num_motori = num_motori;
        }
    }
    
    public void info() {
        System.out.print("Nome: " + nome + ";\nVelocità massima: " + vel_massima + ";\nVelocità di crociera: " + vel_crociera + ";\nNumero motori: " + num_motori + ".");
    }
    
    public int getVelMassima() {
        return vel_massima;
    }
    
    public void setVelMassima(int vel_massima) {
        if(vel_massima > 2000) {
            throw new IllegalArgumentException("La velocità massima supera il limite consentito (2000)");
        } else {
            this.vel_massima = vel_massima;
        }
    }
    
    public int getVelCrociera() {
        return vel_crociera;
    }
    
    public void setVelCrociera(int vel_crociera) {
        if(vel_crociera >= vel_massima) {
            throw new IllegalArgumentException("La velocità di crociera non può essere superiore della velocità massima (" + vel_massima + ")");
        } else {
            this.vel_crociera = vel_crociera;
        }
    }
    
    public String getName() {
        return nome;
    }
    
    public void setName(String nome) {
        this.nome = nome;
    }
    
    public int getNumMotori() {
        return num_motori;
    }
    
    public void setNumMotori(int num_motori) {
        if(num_motori <= 0) {
            throw new IllegalArgumentException("Il numero dei motori non deve essere negativo o pari a 0!");
        } else {
            this.num_motori = num_motori;
        }
    }
}