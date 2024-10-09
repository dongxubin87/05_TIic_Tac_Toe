import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {
    private ScorePanel scorePanel;
    private StatusPanel statusPanel;
    private GameGrid gameGrid;
    private RestartButton restartButton;
    private Player playerX, playerO, currentPlayer;

    public GameBoard(){
        // set up the window of the game
        setTitle("Tic-Tac-Toe");
        setSize(600,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // place ScorePanel and StatusPanel in a same panel
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2,1));
        scorePanel = new ScorePanel();
        statusPanel = new StatusPanel();
        jPanel.add(scorePanel);
        jPanel.add(statusPanel);

        //set up GameGrid
        gameGrid = new GameGrid(this, statusPanel, scorePanel);
        // restartButton
        restartButton = new RestartButton(this,statusPanel);

        add(jPanel,BorderLayout.NORTH);
        add(gameGrid,BorderLayout.CENTER);
        add(restartButton, BorderLayout.SOUTH);

        setVisible(true);

        playerX = new Player("X");
        playerO = new Player("O");
        currentPlayer = playerX;
    }

    public void switchPlayer(){
      currentPlayer = currentPlayer.getName().equals("X") ? playerO : playerX;
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public boolean checkWin(){
        if(gameGrid.isWin(currentPlayer)){
            return true;
        }
        return false;
    }
    public boolean checkDraw(){
        if(gameGrid.isFull()){
            return true;
        }
        return false;
    }
    public void restartGame() {
        gameGrid.resetGrid();
    }
}
