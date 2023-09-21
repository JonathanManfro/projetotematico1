package projetotematico;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class SecundaryScreen extends JFrame {
    public SecundaryScreen() {
        setTitle("Tela Secundária");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        // Crie um JPanel para adicionar o JLabel
        JFrame frame = new JFrame("teste");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Margens
        gbc.anchor = GridBagConstraints.CENTER;

        JLabel label = new JLabel("APÓS 5 SEGUNDOS VOCÊ SERÁ DIRECIONADO A TELA DE PERGUNTAS.");
        panel.add(label, gbc);
        setContentPane(panel);

        setVisible(true);
        // Configure o JPanel como content pane
        setContentPane(panel);
        
        
    }
    public void tocar() {
        Teste teste = new Teste("C:\\Users\\NL\\eclipse-workspace\\ProjetoTematico\\Musica\\01 Almost with You.mp3");
        teste.tocar();
        new ThirdScreen().setVisible(true);
        setVisible(false);
    }

    public static void main(String[] args) {
        SecundaryScreen secundaryScreen = new SecundaryScreen();
        secundaryScreen.tocar();
    }
}
