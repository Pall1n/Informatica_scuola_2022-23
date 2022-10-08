import java.util.Scanner;

import javax.xml.catalog.CatalogException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Banca {
    private int numeroAccount = 3;
    private int indexLogin = -1;
    private Conto[] conti = new Conto[numeroAccount];
    private File file = new File("src/conti.csv");

    public Banca() {
        try {
            Scanner fileScanner = new Scanner(file);
            for (int i = 0; fileScanner.hasNextLine(); i++) {
                String line = fileScanner.nextLine();
                String[] data = line.split(";");
                conti[i] = new Conto (data[0], data[1], Double.parseDouble(data[2]), data[3], data[4], data[5], data[6], data[7]);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean login(String username, String password) {
        for (int i = 0; i < conti.length; i++) {
            if (conti[i].username.equals(username) && conti[i].password.equals(password)) {
                indexLogin = i;
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return conti[indexLogin].nome;
    }

    public String getCognome() {
        return conti[indexLogin].cognome;
    }

    public Double getSaldo() {
        return conti[indexLogin].saldo;
    }

    public String getIban() {
        return conti[indexLogin].iban;
    }

    public String getUscite() {
        if(conti[indexLogin].uscite.isEmpty()) {
            return "";
        } else {
            return conti[indexLogin].uscite.toString();
        }
    }

    public String getEntrate() {
        if(conti[indexLogin].entrate.isEmpty()) {
            return "";
        } else {
            return conti[indexLogin].entrate.toString();
        }
    }

    public boolean cambioIntestatario(String nome, String cognome) {
        try {
            conti[indexLogin].nome = nome;
            conti[indexLogin].cognome = cognome;
            aggiorna();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean prelievo(Double importo) {
        if(conti[indexLogin].prelievo("prelievo", importo)) {
            aggiorna();
            return true;
        } else {
            return false;
        }
    }

    public boolean versamento(Double importo) {
        try {
            conti[indexLogin].versamento("versamento", importo);
            aggiorna();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public int bonifico(String ibanRicevente, double importo) {
        try {
            for (int i = 0; i < conti.length; i++) {
                if(conti[i].iban.equals(ibanRicevente)) {
                    if(!conti[indexLogin].prelievo(ibanRicevente, importo)) {
                        return 1;
                    }
                    conti[i].versamento(conti[indexLogin].iban, importo);
                    aggiorna();
                    return 0;
                }
            }
            return 2;
        } catch (Exception e) {
            return 3;
        }
    }

    private void aggiorna() {
        File tempFile = new File("src/temp.csv");
        try {
            tempFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(tempFile);
            for (int i = 0; i < conti.length; i++) {
                writer.write(conti[i].nome + ";" + conti[i].cognome + ";" + conti[i].saldo + ";" + conti[i].iban + ";" +  (conti[i].uscite.isEmpty() ? "{}" : conti[i].uscite) + ";" + (conti[i].entrate.isEmpty() ? "{}" : conti[i].entrate) + ";" + conti[i].username + ";" + conti[i].password + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!file.delete()) {
            System.out.println("Impossibile cancellare il file");
            return;
        } else {
            if(!tempFile.renameTo(file)) {
                System.out.println("Impossibile rinominare il file");
            }
        }
    }
}