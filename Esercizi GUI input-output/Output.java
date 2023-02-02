import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Output extends JFrame {
    public Output(String nome) {
        setTitle("Output semplice");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        add(panel);
        JLabel label = new JLabel("Ciao " + nome + "!");
        panel.add(label);
        setVisible(true);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Inserisci il tuo nome: ");
        String nome = input.nextLine();
        new Output(nome);
        input.close();
    }
}