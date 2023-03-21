/*
Si implementi una classe che modelli il magazzino sopradescritto
offrendo le seguenti operazioni di gestione utilizzando l’interfaccia
grafica:

1] immissione di un nuovo articolo;
2] estrazione dal magazzino di una merce il cui codice viene dato in
input;
3] stampa della situazione della merce sotto scorta;
4] stampa degli alimenti con data di scadenza inferiore a 5 giorni.
*/

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.ArrayList;

public class Magazzino extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JButton btn1, btn2, btn3, btn4;
    private ArrayList<Merce> magazzino = new ArrayList<Merce>();

    public Magazzino() {
        super("Magazzino");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        btn1 = new JButton("Immissione di un nuovo articolo");
        btn2 = new JButton("Estrazione dal magazzino di una merce");
        btn3 = new JButton("Stampa della situazione della merce sotto scorta");
        btn4 = new JButton("Stampa degli alimenti con data di scadenza inferiore a 5 giorni");
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        add(panel);
        setVisible(true);

        btn1.addActionListener(e -> {
            immissione();
        });

        btn2.addActionListener(e -> {
            estrazione();
        });

        btn3.addActionListener(e -> {
            stampa();
        });

        btn4.addActionListener(e -> {
            stampaMenoDiCinqueGiorni();
        });
    }

    public void immissione() {
        String tipoArticolo = JOptionPane.showInputDialog("Inserisci il tipo di articolo (alimentare, casalingo, abbigliamento)");
        while(!tipoArticolo.equals("alimentare") && !tipoArticolo.equals("casalingo") && !tipoArticolo.equals("abbigliamento")) {
            JOptionPane.showMessageDialog(null, "Tipo di articolo non valido");
            tipoArticolo = JOptionPane.showInputDialog("Inserisci il tipo di articolo (alimentare, casalingo, abbigliamento)");
        }
        String descrizione = JOptionPane.showInputDialog("Inserisci la descrizione");
        String codiceFornitore = JOptionPane.showInputDialog("Inserisci il codice fornitore");
        int scortaMinima = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la scorta minima"));
        while(scortaMinima < 0) {
            JOptionPane.showMessageDialog(null, "La scorta minima non può essere minore di 0");
            scortaMinima = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la scorta minima"));
        }
        int quantita = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la quantità"));
        while(quantita < 0) {
            JOptionPane.showMessageDialog(null, "La quantità non può essere minore di 0");
            quantita = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la quantità"));
        }
        double prezzoUnitario = Double.parseDouble(JOptionPane.showInputDialog("Inserisci il prezzo unitario"));
        
        if (tipoArticolo.equals("alimentare")) {
            Date dataScadenza = null;
            while(dataScadenza == null) {
                try {
                    dataScadenza = new Date(JOptionPane.showInputDialog("Inserisci la data di scadenza (dd/MM/yyyy)"));
                } catch (Exception e) {
                    dataScadenza = null;
                }
            }

            Boolean contieneLattosio = null;
            while(contieneLattosio == null) {
                try {
                    contieneLattosio = Boolean.parseBoolean(JOptionPane.showInputDialog("Contiene lattosio? (true/false)"));
                } catch (Exception e) {
                    contieneLattosio = null;
                }
            }

            Boolean contieneGlutine = null;
            while(contieneGlutine == null) {
                try {
                    contieneGlutine = Boolean.parseBoolean(JOptionPane.showInputDialog("Contiene glutine? (true/false)"));
                } catch (Exception e) {
                    contieneGlutine = null;
                }
            }

            magazzino.add(new Alimentari(magazzino.size(), descrizione, codiceFornitore, quantita, prezzoUnitario, scortaMinima, dataScadenza, contieneLattosio, contieneGlutine));
        } else if (tipoArticolo.equals("casalingo")) {
            String tipo = JOptionPane.showInputDialog("Inserisci il tipo (liquido, polvere, solido)");
            while (!tipo.equals("liquido") && !tipo.equals("polvere") && !tipo.equals("solido")) {
                tipo = JOptionPane.showInputDialog("Inserisci il tipo (liquido, polvere, solido)");
            }

            magazzino.add(new Casalinghi(magazzino.size(), descrizione, codiceFornitore, quantita, prezzoUnitario, scortaMinima, tipo));
        } else if (tipoArticolo.equals("abbigliamento")) {
            String taglia = JOptionPane.showInputDialog("Inserisci la taglia");
            String colore = JOptionPane.showInputDialog("Inserisci il colore");
            String tipo = JOptionPane.showInputDialog("Inserisci il tipo");

            magazzino.add(new Abbigliamento(magazzino.size(), descrizione, codiceFornitore, quantita, prezzoUnitario, scortaMinima, taglia, colore, tipo));
        }
    }
    
    public void estrazione() {
        int codiceProdotto = Integer.parseInt(JOptionPane.showInputDialog("Inserisci il codice prodotto"));
        Boolean found = false;
        for (Merce m : magazzino) {
            if (m.getNumeroprogressivo() == codiceProdotto) {
                found = true;
                int quantitaDaEstrarre = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la quantità da estrarre"));
                if (quantitaDaEstrarre > m.getQuantita()) {
                    JOptionPane.showMessageDialog(null, "Quantità non disponibile");
                    while(quantitaDaEstrarre > m.getQuantita()) {
                        quantitaDaEstrarre = Integer.parseInt(JOptionPane.showInputDialog("Inserisci la quantità da estrarre"));
                    }
                } else if(quantitaDaEstrarre == m.getQuantita()) {
                    magazzino.remove(m);
                    JOptionPane.showMessageDialog(null, "Estrazione completata");
                } else {
                    m.setQuantita(m.getQuantita() - quantitaDaEstrarre);
                    JOptionPane.showMessageDialog(null, "Estrazione completata");
                }
                break;
            }
        }
        if(found == false) {
            JOptionPane.showMessageDialog(null, "Prodotto non trovato");
        }
    }

    public void stampa() {
        if(magazzino.size() == 0) {
            JOptionPane.showMessageDialog(null, "Non ci sono prodotti nel magazzino");
        } else {
            StampaMerce sm = new StampaMerce(magazzino);
        }
    }

    public void stampaMenoDiCinqueGiorni() {
        ArrayList<Merce> prodottiDaStampare = new ArrayList<Merce>();

        for(Merce m : magazzino) {
            if (m instanceof Alimentari) {
                Alimentari a = (Alimentari) m;
                if ((a.getDataScadenza().getTime() - new Date().getTime()) < 432000000) {
                    prodottiDaStampare.add(m);
                }
            }
        }

        if(prodottiDaStampare.size() == 0) {
            JOptionPane.showMessageDialog(null, "Non ci sono prodotti da stampare");
        } else {
            StampaMerce sm = new StampaMerce(prodottiDaStampare);
        }
    }

    public static void main(String[] args) {
        new Magazzino();
    }
}