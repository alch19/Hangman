import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

public class HangmanGame extends JFrame{
    
    private WordList word;
    private int guessesLeft;
    private JButton guessButton;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private HangmanPanel hangmanPanel;
    private JTextField textField;

    public HangmanGame() {
        this.guessesLeft = 7;
        this.guessButton = new JButton("Guess");
        this.wordLabel = new JLabel();
        this.attemptsLabel = new JLabel();
        this.hangmanPanel = new HangmanPanel();
        this.textField = new JTextField(10);


        this.word = new WordList();
        this.word.generateRandomWord();
        this.wordLabel.setText(word.spacedShownWord());
        this.wordLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
        this.wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.wordLabel.setBorder(new EmptyBorder(0, 195, 0, 0));
        this.attemptsLabel.setText("Guesses Left: " + Integer.toString(guessesLeft));
        this.attemptsLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
        this.attemptsLabel.setBorder(new EmptyBorder(0, 0, 0, 20));

        

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(wordLabel, BorderLayout.CENTER);
        topPanel.add(attemptsLabel, BorderLayout.EAST);

        this.guessButton.setPreferredSize(new Dimension(80, 30));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(textField);
        bottomPanel.add(guessButton);

        this.setTitle("Hangman");
        setLayout(new BorderLayout());
        topPanel.setBackground(new Color(0x17DC4D));
        getContentPane().setBackground(new Color(0x38C43B));
        bottomPanel.setBackground(new Color(0x17DC4D));
        hangmanPanel.setBackground(new Color(0x38C43B));

        this.add(topPanel, BorderLayout.NORTH);
        this.add(hangmanPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
        

        // action when guess is submitted
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                System.out.println("User Guessed: " + userInput);
                String previousWord = word.getWord(); // only here to compare to previous word to know whether to take away a guess
                word.makeGuess(userInput);
                wordLabel.setText(word.spacedShownWord());
                textField.setText("");

                String[] options = {"YES", "NO"};
                int response;
                if(word.wordCompleted()) {
                    response = JOptionPane.showOptionDialog(null, "You won!", "Would you like to play again", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
                    if(response==1) {
                        System.exit(0);
                    }
                    else if(response==0) {
                        resetGame();
                    }

                    System.out.println(response);
                }
                else {
                    if(word.getWord().equals(previousWord)) {
                        guessesLeft--;
                        attemptsLabel.setText("Guesses Left: " + Integer.toString(guessesLeft));
                        hangmanPanel.setIncorrectGuesses(7-guessesLeft);
                    }
                }
                if(guessesLeft<=0) {
                    response = JOptionPane.showOptionDialog(null, "The word was: \"" + word.getChosenWord() + "\"\nWould you like to play again?", "You Lost!", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, 0);
                    if(response==1) {
                        System.exit(0);
                    }
                    else if(response==0) {
                        resetGame();
                    }
                    System.out.println(response);
                }
            }
        });


        // default window settings
        this.setSize(1000,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void resetGame() {
        wordLabel.setText("");
        this.guessesLeft=7;
        this.attemptsLabel.setText("Guesses Left: " + Integer.toString(guessesLeft));
        word.generateRandomWord();
        wordLabel.setText(word.spacedShownWord());
        hangmanPanel.setIncorrectGuesses(0);
    }
}