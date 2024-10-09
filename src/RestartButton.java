import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartButton extends JButton implements ActionListener {
    private GameBoard gameBoard;
    private StatusPanel statusPanel;
    public RestartButton(GameBoard gameBoard,StatusPanel statusPanel){
        this.gameBoard = gameBoard;
        this.statusPanel = statusPanel;
        setText("Restart");
        setFont(new Font("Arial", Font.BOLD,16));
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gameBoard.restartGame();
        statusPanel.updateStatus("It's X's turn!");
    }


}
