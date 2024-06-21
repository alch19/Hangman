import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class HangmanGame extends JFrame{
    
    private WordList word;
    private int guessesLeft;
    private JButton guessButton;
    private JLabel wordLabel;
    private JLabel attemptsLabel; 
    private JLabel incorrectGuessesLabel;
    private JPanel hangmanPanel;
    private StringBuilder displayedWord;
    private int attemptsLeft;
    private JTextField textField;

    public HangmanGame() {
        this.guessesLeft = 7;
        this.guessButton = new JButton("Guess");
        this.wordLabel = new JLabel();
        this.attemptsLabel = new JLabel();
        this.incorrectGuessesLabel = new JLabel();
        this.hangmanPanel = new JPanel();
        this.textField = new JTextField(10);


        word = new WordList();
        word.generateRandomWord();
        this.wordLabel.setText(word.getWord());
        this.wordLabel.setFont(new Font("MV Boli", Font.BOLD, 24));

        

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(wordLabel);
        
        this.guessButton.setPreferredSize(new Dimension(80, 30));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.add(textField);
        bottomPanel.add(guessButton);

        this.setTitle("Hangman");
        setLayout(new BorderLayout());
        topPanel.setBackground(new Color(0x17DC4D));
        getContentPane().setBackground(new Color(0x38C43B));
        bottomPanel.setBackground(new Color(0x17DC4D));

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);
        

        // action when guess is submitted
        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = textField.getText();
                System.out.println("User Guessed: " + userInput);
                word.makeGuess(userInput);
                wordLabel.setText(word.getWord());
                textField.setText("");
                if(word.wordCompleted()) {
                    JOptionPane.showOptionDialog(null, "You won!", "Would you like to play again", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0);
                    resetGame();
                }
                else {
                    guessesLeft--;
                }
                if(guessesLeft<=0) {
                    JOptionPane.showOptionDialog(null, "You lost!", "Would you like to play again", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0);
                    resetGame();
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
        this.word.generateRandomWord();
        this.wordLabel.setText(word.getWord());
    }
}