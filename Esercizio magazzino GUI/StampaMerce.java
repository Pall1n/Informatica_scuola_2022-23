import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StampaMerce extends JFrame {
    public StampaMerce(ArrayList<Merce> magazzino) {
        String[] columnNames = {"Numero progressivo", "Tipo", "Descrizione", "Codice fornitore", "Quantità", "Prezzo unitario", "Scorta minima"};
        String[][] data = new String[magazzino.size()][7];
        for(Merce m : magazzino) {
            data[magazzino.indexOf(m)][0] = String.valueOf(m.getNumeroprogressivo());
            data[magazzino.indexOf(m)][1] = m.getClass().getSimpleName();
            data[magazzino.indexOf(m)][2] = m.getDescrizione();
            data[magazzino.indexOf(m)][3] = m.getCodiceFornitore();
            data[magazzino.indexOf(m)][4] = String.valueOf(m.getQuantita());
            data[magazzino.indexOf(m)][5] = String.valueOf(m.getPrezzoUnitario());
            data[magazzino.indexOf(m)][6] = String.valueOf(m.getScortaMinima());
        }

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setSize(800, 300);
        setResizable(false);
        setVisible(true);
    }
}