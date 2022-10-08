import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conto {
    public String nome;
    public String cognome;
    public double saldo;
    public String iban;
    public Map<String, Double> uscite = new HashMap<String, Double>();
    public Map<String, Double> entrate = new HashMap<String, Double>();
    public String username;
    public String password;

    public Conto (String nome, String cognome, double saldo, String iban, String usciteInput, String entrateInput, String username, String password){
        this.nome = nome;
        this.cognome = cognome;
        this.saldo = saldo;
        this.iban = iban;
        this.username = username;
        this.password = password;
        if(usciteInput.substring(1,usciteInput.length() - 1) != "") {
            String[] coppieUscite = usciteInput.substring(1,usciteInput.length() - 1).split(", ");
            for (int i=0; i<coppieUscite.length; i++) {
                String coppia = coppieUscite[i];
                String[] chiaveValore = coppia.split("=");
                this.uscite.put(chiaveValore[0], Double.parseDouble(chiaveValore[1]));
            }
        } else {
            this.uscite = new HashMap<String, Double>(){{}};
        }
        if(entrateInput.substring(1,entrateInput.length() - 1) != "") {
            String[] coppieEntrate = entrateInput.substring(1,entrateInput.length() - 1).split(", ");
            for (int i=0; i<coppieEntrate.length; i++) {
                String coppia = coppieEntrate[i];
                String[] chiaveValore = coppia.split("=");
                this.entrate.put(chiaveValore[0], Double.parseDouble(chiaveValore[1]));
            }
        } else {
            this.entrate = new HashMap<String, Double>(){{}};;
        }
    }

    public void versamento (String tipo, double importo) {
        saldo += importo;
        LocalDateTime data = LocalDateTime.now();
        String dataFormattata = DateTimeFormatter.ofPattern("dd-MM-yyyy/HH:mm:ss").format(data);
        if(entrate.isEmpty()) {
            entrate = new HashMap<String, Double>(){{
                put(tipo + "/" + dataFormattata, importo);
            }};
        } else {
            entrate.put(tipo + "/" + dataFormattata, importo);
        }
    }

    public boolean prelievo (String tipo, double importo) {
        if(saldo >= importo) {
            saldo -= importo;
            LocalDateTime data = LocalDateTime.now();
            String dataFormattata = DateTimeFormatter.ofPattern("dd-MM-yyyy/HH:mm:ss").format(data);
            if(uscite.isEmpty()) {
                uscite = new HashMap<String, Double>(){{
                    put(tipo + "/" + dataFormattata, importo);
                }};
            } else {
                uscite.put(tipo + "/" + dataFormattata, importo);
            }
            return true;
        } else {
            return false;
        }
    }
}