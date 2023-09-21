package projetotematico;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.GridLayout;

public class ThirdScreen extends JFrame {
    public ThirdScreen() {
        setTitle("Tela perguntas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        ButtonGroup group = new ButtonGroup(); // Crie um grupo para os botões de rádio

        JRadioButton radioButton1 = new JRadioButton("Pergunta 1");
        JRadioButton radioButton2 = new JRadioButton("Pergunta 2");
        JRadioButton radioButton3 = new JRadioButton("Pergunta 3");
        JRadioButton radioButton4 = new JRadioButton("Pergunta 4");
        JRadioButton radioButton5 = new JRadioButton("Pergunta 5");

        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);
        group.add(radioButton5);

        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(radioButton3);
        panel.add(radioButton4);
        panel.add(radioButton5);

        add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        ThirdScreen thirdScreen = new ThirdScreen();
    }
}
