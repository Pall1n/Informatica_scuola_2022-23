import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame{
    private JPanel panel;
    private double baseValue, altezzaValue, areaTriangolo, perimetroRett, areaRett;

    public GUI() {
        super("Base-Altezza");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 140);
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        JLabel baseText = new JLabel("Base: ");
        JTextField baseInput = new JTextField();
        JLabel altezzaText = new JLabel("Altezza: ");
        JTextField altezzaInput = new JTextField();
        JButton btn1 = new JButton("CALCOLA");
        panel.add(baseText);
        panel.add(baseInput);
        panel.add(altezzaText);
        panel.add(altezzaInput);
        panel.add(btn1);
        add(panel);
        setVisible(true);
        setResizable(false);

        btn1.addActionListener(e -> {
            try {
                baseValue = Integer.parseInt(baseInput.getText());
                altezzaValue = Integer.parseInt(altezzaInput.getText());
                areaTriangolo = (baseValue * altezzaValue) / 2;
                perimetroRett = (baseValue + altezzaValue) * 2;
                areaRett = baseValue * altezzaValue;
                JOptionPane.showMessageDialog(null, "Area triangolo: " + areaTriangolo + "; perimetro rettangolo: " + perimetroRett + "; area rettangolo: " + areaRett + ".", "Risultati", JOptionPane.INFORMATION_MESSAGE);
            } catch(NumberFormatException err) {
                JOptionPane.showMessageDialog(null, "Inserisci numeri!", "Errore", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
