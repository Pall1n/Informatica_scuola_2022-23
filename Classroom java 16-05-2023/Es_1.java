/*
    Implementare un programma che dato un numero in ingresso, fornisce 
    due numeri in uscita : il quadrato e la radice. I calcoli devono 
    essere comandati da un solo pulsante.
*/

import java.awt.*;
import javax.swing.*;

public class Es_1 extends JFrame {
    public Es_1() {
        super("Quadrato e radice");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 10, 10));
        JButton b = new JButton("Calcola");
        JTextField numero = new JTextField();
        JTextField quadrato = new JTextField();
        JTextField radice = new JTextField();
        panel.add(new JLabel("Numero: ", SwingConstants.CENTER), 0, 0);
        panel.add(numero, 0, 1);
        panel.add(new JLabel(), 0, 2);
        panel.add(new JLabel(), 0, 3);
        panel.add(new JLabel(), 0, 4);
        panel.add(b, 0, 5);
        panel.add(new JLabel(), 0, 6);
        panel.add(new JLabel("Quadrato: ", SwingConstants.CENTER), 0, 7);
        panel.add(quadrato, 0, 8);
        panel.add(new JLabel(), 0, 9);
        panel.add(new JLabel("Radice: ", SwingConstants.CENTER), 0, 10);
        panel.add(radice, 0, 11);
        b.addActionListener(e -> {
            int n = Integer.parseInt(numero.getText());
            quadrato.setText("" + n * n);
            radice.setText("" + Math.sqrt(n));
        });
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Es_1();
    }
}