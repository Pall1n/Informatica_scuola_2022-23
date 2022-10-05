import java.util.*;

public class Conto {
    private String nome;
    private String cognome;
    private double saldo;
    private String iban;
    private Map<String, String> prelievi = new HashMap<String, String>();
    private Map<String, String> versamenti = new HashMap<String, String>();
    private String username;
    private String password;

    public Conto (String nome, String cognome, double saldo, String iban,  String prelievi, String versamenti, String username, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = saldo;
        this.iban = iban;
        this.username = username;
        this.password = password;
    }

    public void prova (){
        System.out.println (prelievi);
    }
}