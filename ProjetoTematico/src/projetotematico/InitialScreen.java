package projetotematico;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class InitialScreen extends JFrame {
    public InitialScreen() {
        setTitle("Tela Principal");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton botao = new JButton("Iniciar Jogo");

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a tela atual
                SecundaryScreen secundaryscreen = new SecundaryScreen(); // Abre a tela secundária
                secundaryscreen.setVisible(true);
                secundaryscreen.tocar();
            }
        });

        setLayout(new BorderLayout());
        add(botao, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InitialScreen().setVisible(true);
            }
        });
    }
}