/*
    Implementare un programma che dato un numero, collocato in un 
    JTextField e dotato di due pulsanti Incrementa e Decrementa, 
    permetta l'incremento o il decremento di 1 di quel numero.
*/

import java.awt.*;
import javax.swing.*;

public class Es_2 extends JFrame {
    public Es_2() {
        super("Incrementa e decrementa");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2, 5, 5));
        JButton incrementa = new JButton("Incrementa");
        JButton decrementa = new JButton("Decrementa");
        JTextField numero = new JTextField();
        panel.add(new JLabel("Numero: ", SwingConstants.CENTER), 0, 0);
        panel.add(numero, 0, 1);
        panel.add(decrementa, 0, 2);
        panel.add(incrementa, 0, 3);
        incrementa.addActionListener(e -> {
            int n = Integer.parseInt(numero.getText());
            numero.setText("" + (n + 1));
        });
        decrementa.addActionListener(e -> {
            int n = Integer.parseInt(numero.getText());
            numero.setText("" + (n - 1));
        });
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Es_2();
    }
}
