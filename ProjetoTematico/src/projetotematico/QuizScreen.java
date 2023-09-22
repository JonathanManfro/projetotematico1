package projetotematico;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizScreen extends JFrame {
    private int currentQuestion = 0;
    private String[] questions = {
        "Quem encorajou o mundo a 'Get Down on It' em 1981?",
        "Qual é o seu nome?", // Pergunta com entrada de texto
        "Pergunta 3",
        "Qual é a capital do Brasil?", // Pergunta com entrada de texto
        "Pergunta 5"
    };

    private boolean[] isTextInput = {
        false, // A primeira pergunta tem botões de rádio
        true,  // A segunda pergunta tem entrada de texto
        false, // A terceira pergunta tem botões de rádio
        true,  // A quarta pergunta tem entrada de texto
        false  // A quinta pergunta tem botões de rádio
    };

    private JButton nextButton;
    private JButton backButton;
    private JButton concludeButton;
    private JPanel optionsPanel;

    public QuizScreen() {
        setTitle("Tela de Perguntas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JLabel questionLabel = new JLabel(questions[currentQuestion]);
        questionLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(questionLabel, BorderLayout.NORTH);

        optionsPanel = new JPanel(new GridLayout(4, 1));
        setupQuestionUI();

        panel.add(optionsPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        backButton = new JButton("Voltar");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion > 0) {
                    currentQuestion--;
                    questionLabel.setText(questions[currentQuestion]);
                    setupQuestionUI();
                    updateButtons();
                }
            }
        });

        nextButton = new JButton("Próximo");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentQuestion < questions.length - 1) {
                    currentQuestion++;
                    questionLabel.setText(questions[currentQuestion]);
                    setupQuestionUI();
                    updateButtons();
                }
            }
        });

        concludeButton = new JButton("Concluído");
        concludeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	ResultScreen resultscreen = new ResultScreen();
            	dispose();
            }
        });
        concludeButton.setVisible(false);

        buttonPanel.add(backButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(concludeButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        updateButtons();

        add(panel);

        setVisible(true);
    }

    private void setupQuestionUI() {
        optionsPanel.removeAll();
        if (isTextInput[currentQuestion]) {
            JTextField textField = new JTextField();
            optionsPanel.add(textField);
        } else {
            ButtonGroup group = new ButtonGroup();
            JRadioButton[] optionButtons = new JRadioButton[4];
            for (int i = 0; i < 4; i++) {
                optionButtons[i] = new JRadioButton("Opção " + (i + 1));
                group.add(optionButtons[i]);
                optionsPanel.add(optionButtons[i]);
            }
        }
        optionsPanel.revalidate();
        optionsPanel.repaint();
    }

    private void updateButtons() {
        backButton.setEnabled(currentQuestion > 0);
        nextButton.setEnabled(currentQuestion < questions.length - 1);
        concludeButton.setVisible(currentQuestion == questions.length - 1);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new QuizScreen();
            }
        });
    }
}
