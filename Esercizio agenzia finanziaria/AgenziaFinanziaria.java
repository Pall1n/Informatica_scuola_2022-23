import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AgenziaFinanziaria extends JFrame {
    private double distribuzioni[][] = new double[3][3];
    private double rendimento[][] = new double[3][3];
    private double rendimentoAnnuo[] = {1.5, 2.8, 1.7};
    private double rateRisk[] = {3, 7, 2};

    public AgenziaFinanziaria(int somma) {
        distribuisci(somma);

        String[] columnNames = {"PiA", "BTC", "Fiv"};
        String[][] data = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                data[i][j] = String.valueOf(distribuzioni[i][j]);
            }
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setSize(400, 150);
        setResizable(false);
        setVisible(true);
    }

    public void distribuisci(int somma) {
        Random random = new Random();

        for(int i = 0; i < 3; i++) {
            double somma_temp = somma;
            somma_temp -= 6000;

            for(int j = 0; j < 3; j++) {
                if(somma_temp == 0)
                    break;
                distribuzioni[i][j] = Math.round((random.nextDouble() * somma_temp) * 100.0) / 100.0;
                rendimento[i][j] = Math.round((distribuzioni[i][j] + distribuzioni[i][j] /100 * rendimentoAnnuo[j]) * 100) / 100;
                somma_temp -= Math.round(distribuzioni[i][j] * 100.0) / 100.0;
                distribuzioni[i][j] += 2000;
            }

            double indiceRischio = 0;

            for(int j = 0; j < 3; j++) {
                indiceRischio += rendimento[i][j] * rateRisk[j] / rendimentoAnnuo[j];
            }

            if(indiceRischio < 200 && indiceRischio > 600) {
                i -= 1;
            }
        }
    }
}