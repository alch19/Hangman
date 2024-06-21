import javax.swing.*;
import java.awt.*;

public class HangmanPanel extends JPanel {
    private int incorrectGuesses;

    public HangmanPanel() {
        this.incorrectGuesses=0;
    }

    public void setIncorrectGuesses(int incorrectGuesses) {
        this.incorrectGuesses=incorrectGuesses;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        int centerX = width / 2;
        int baseY = height-100;
        
        int poleTopY = baseY - 150;
        int headCenterY = poleTopY + 25;
        int bodyStartY = headCenterY + 30;
        int armY = bodyStartY + 15;
        int legStartY = bodyStartY + 45;

        g2D.setStroke(new BasicStroke(5));

        if (incorrectGuesses > 0) {
            g2D.drawLine(centerX - 75, baseY, centerX + 75, baseY); // base
            g2D.drawLine(centerX, baseY, centerX, poleTopY); // pole
            g2D.drawLine(centerX, poleTopY, centerX + 50, poleTopY); // top
            g2D.drawLine(centerX + 50, poleTopY, centerX + 50, poleTopY + 25); // rope
        }
        if (incorrectGuesses > 1) {
            g2D.drawOval(centerX + 35, poleTopY + 25, 30, 30); // head
        }
        if (incorrectGuesses > 2) {
            g2D.drawLine(centerX + 50, headCenterY + 30, centerX + 50, legStartY); // body
        }
        if (incorrectGuesses > 3) {
            g2D.drawLine(centerX + 50, armY, centerX + 20, armY - 20); // left arm
        }
        if (incorrectGuesses > 4) {
            g2D.drawLine(centerX + 50, armY, centerX + 80, armY - 20); // right arm
        }
        if (incorrectGuesses > 5) {
            g2D.drawLine(centerX + 50, legStartY, centerX + 20, legStartY + 30); // left leg
        }
        if (incorrectGuesses > 6) {
            g2D.drawLine(centerX + 50, legStartY, centerX + 80, legStartY + 30); // right leg
        }
    }
}
