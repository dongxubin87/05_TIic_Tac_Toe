import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {
    private JLabel statusLabel;
    public StatusPanel(){
        statusLabel = new JLabel("It's X's turn!");
        statusLabel.setFont(new Font("Arial", Font.BOLD,24));
        add(statusLabel);
    }
    public void updateStatus(String message){
        statusLabel.setText(message);
    }
}
