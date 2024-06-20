import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class HangmanGame extends JFrame{
    
    private int guessesLeft;
    private JButton guessButton;
    private JLabel wordLabel;
    private JLabel attemptsLabel; 
    private JLabel incorrectGuessesLabel;
    private JPanel hangmanPanel;
    private StringBuilder displayedWord;
    private int attemptsLeft;

    public HangmanGame() {
        this.guessesLeft = 7;
        this.guessButton = new JButton("Guess");
        this.wordLabel = new JLabel();
        this.attemptsLabel = new JLabel();
        this.incorrectGuessesLabel = new JLabel();
        this.hangmanPanel = new JPanel();

        
        



        this.setTitle("Hangman");
        setLayout(new BorderLayout());
        this.setSize(1000,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}