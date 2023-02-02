import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Input extends JFrame {
    private JTextField inputField;

    public Input() {
        setTitle("Input con GUI");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);
        JLabel label = new JLabel("Inserisci il tuo nome: ");
        panel.add(label);
        inputField = new JTextField(10);
        panel.add(inputField);
        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = inputField.getText();
                JOptionPane.showMessageDialog(null, "CIAO, " +
                        name + "!");
            }

        });
        panel.add(submitButton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Input();
    }
}