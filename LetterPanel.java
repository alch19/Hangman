import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class LetterPanel extends JPanel {
    private Set<Character> usedLetters;

    public LetterPanel() {
        this.usedLetters = new HashSet<>();
        this.setLayout(new GridLayout(2,13));
        this.setBackground(new Color(0x17DC4D));
        initializeLettersPanel();
    }
    
    public void initializeLettersPanel() {
        for (char i = 'A'; i <= 'Z'; i++) {
            JLabel letterLabel = new JLabel(String.valueOf(i));
            letterLabel.setFont(new Font("MV Boli", Font.BOLD, 20));
            letterLabel.setHorizontalAlignment(SwingConstants.CENTER);
            this.add(letterLabel);
        }
    }
    public void updateLettersPanel() {
        Component[] components = this.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel letterLabel = (JLabel) component;
                char letter = letterLabel.getText().charAt(0);
                if (usedLetters.contains(Character.toLowerCase(letter))) {
                    letterLabel.setForeground(Color.RED);
                } else {
                    letterLabel.setForeground(Color.BLACK);
                }
            }
        }
    }

    public void updateLettersPanel(char guessedLetter, boolean isCorrect) {
        Component[] components = this.getComponents();
        for (Component component : components) {
            if (component instanceof JLabel) {
                JLabel letterLabel = (JLabel) component;
                char letter = letterLabel.getText().charAt(0);
                if (Character.toLowerCase(letter) == Character.toLowerCase(guessedLetter)) {
                    if (isCorrect) {
                        letterLabel.setForeground(Color.BLUE);
                    } else {
                        letterLabel.setForeground(Color.RED);
                    }
                }
            }
        }
    }

    public void addUsedLetter(char letter, boolean isCorrect) {
        usedLetters.add(letter);
        updateLettersPanel(letter, isCorrect);
    }

    public void reset() {
        usedLetters.clear();
        updateLettersPanel();
    }

    public boolean isLetterUsed(char letter) {
        return usedLetters.contains(letter);
    }
}
