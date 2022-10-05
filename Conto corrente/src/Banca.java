import java.util.Scanner;
import java.io.*;

public class Banca {
    public Conto[] conti = new Conto[1];

    public Banca() {
        try {
            File file = new File("conti.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String[] dati = sc.nextLine().split(";");
                conti[0] = new Conto(dati[0], dati[1], Double.parseDouble(dati[2]), dati[3], dati[4], dati[5], dati[6], dati[7]);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        file.useDelimiter(",");

        for(int i = 0; file.hasNext(); i++) {
            conti[i] = new Conto(file.next(), file.next(), file.nextDouble(), file.next(), file.next().toString(), file.next().toString(), file.next(), file.next());
        }
    }
}