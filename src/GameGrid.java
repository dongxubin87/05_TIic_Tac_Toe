import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGrid extends JPanel implements ActionListener {
    private GameBoard gameBoard;
    private JButton[][] cells = new JButton[3][3];
    private StatusPanel statusPanel;
    private ScorePanel scorePanel;

    public GameGrid(GameBoard gameBoard, StatusPanel statusPanel, ScorePanel scorePanel) {
        this.gameBoard = gameBoard;
        this.statusPanel = statusPanel;
        this.scorePanel = scorePanel;

        setLayout(new GridLayout(3, 3));
        setBackground(Color.cyan);
        initializeBoard();
    }

    // initialize the game grid
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new JButton("");
                cells[i][j].setFont(new Font("Arial", Font.PLAIN, 60));
                cells[i][j].addActionListener(this);
                add(cells[i][j]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (e.getSource() == cells[i][j] && cells[i][j].getText().isEmpty()) {
                    cells[i][j].setText(gameBoard.getCurrentPlayer().getName());
                    if (gameBoard.checkWin()) {
                        statusPanel.updateStatus(gameBoard.getCurrentPlayer().getName() + " wins!");
                        scorePanel.incrementScore(gameBoard.getCurrentPlayer());
                        disableGrid();
                    } else if (gameBoard.checkDraw()) {
                        statusPanel.updateStatus("It's a draw!");
                        disableGrid();
                    } else {
                        gameBoard.switchPlayer();
                        statusPanel.updateStatus("It's " + gameBoard.getCurrentPlayer().getName() + "'s turn!");
                    }
                }
            }
        }
    }

    public boolean isWin(Player currentPlayer) {
        String currentName = currentPlayer.getName();

        for (int i = 0; i < 3; i++) {
            // check rows
            if (cells[i][0].getText().equals(currentName) &&
                    cells[i][1].getText().equals(currentName) &&
                    cells[i][2].getText().equals(currentName)) {
                return true;
            }
            // check cols
            if (cells[0][i].getText().equals(currentName) &&
                    cells[1][i].getText().equals(currentName) &&
                    cells[2][i].getText().equals(currentName)) {
                return true;
            }
        } // end for

        //check diagonals
        if (cells[0][0].getText().equals(currentName) &&
                cells[1][1].getText().equals(currentName) &&
                cells[2][2].getText().equals(currentName)) {
            return true;
        }
        if (cells[0][2].getText().equals(currentName) &&
                cells[1][1].getText().equals(currentName) &&
                cells[2][0].getText().equals(currentName)) {
            return true;
        }
        return false;
    }//end checkWin

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }// end isFull

    public void disableGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j].setEnabled(false);
            }
        }
    }// end disableGrid

    // reset the game grid
    public void resetGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j].setText("");
                cells[i][j].setEnabled(true);
            }
        }
    }
}
