import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InserimentoSomma extends JFrame {
    private JTextField inputField;

    public InserimentoSomma() {
        setTitle("Investimento");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        JLabel label = new JLabel("Inserisci somma da investire");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);
        inputField = new JTextField(8);
        panel.add(inputField);
        JButton submitButton = new JButton("Inserisci");
        
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int somma = Integer.parseInt(inputField.getText());
                    if(somma <= 6000 || somma > 50000) {
                        JOptionPane.showMessageDialog(null, "Inserisci un valore maggiore di 6000€ e minore di 50000€");
                        return;
                    }
                    new AgenziaFinanziaria(somma);
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Inserisci un numero");
                }
            }
        });        
        panel.add(submitButton);
        setResizable(false);
        setVisible(true);
    }
}