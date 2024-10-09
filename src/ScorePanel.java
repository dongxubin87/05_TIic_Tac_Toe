import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    private JLabel playerXScoreLabel;
    private JLabel playerOScoreLabel;

    public ScorePanel() {
        setLayout(new GridLayout(1, 2));

        playerXScoreLabel = new JLabel("X ---- 0");
        playerXScoreLabel.setHorizontalAlignment(JTextField.CENTER);
        playerXScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        playerXScoreLabel.setForeground(Color.RED);

        playerOScoreLabel = new JLabel("O ---- 0");
        playerOScoreLabel.setHorizontalAlignment(JTextField.CENTER);
        playerOScoreLabel.setFont(new Font("Arial", Font.BOLD, 20));
        playerOScoreLabel.setForeground(Color.RED);

        add(playerXScoreLabel);
        add(playerOScoreLabel);
    }

    public void incrementScore(Player currentPlayer) {
        if (currentPlayer.getName().equals("X")) {
           currentPlayer.incrementScore();
            playerXScoreLabel.setText("X ---- " + currentPlayer.getScore());
        } else {
            currentPlayer.incrementScore();
            playerOScoreLabel.setText("O ---- " + currentPlayer.getScore());
        }
    }
}
