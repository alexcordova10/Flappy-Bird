import javax.swing.*;
import java.awt.*;

/**
 * PauseScreen represents the paused state of the game.
 */
public class PauseScreen extends JPanel
{
    public PauseScreen(JPanel mainPanel, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());

        JLabel pausedLabel = new JLabel("Game Paused", JLabel.CENTER);
        pausedLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(pausedLabel, BorderLayout.CENTER);

        JButton resumeButton = new JButton("Resume");
        resumeButton.addActionListener(e -> cardLayout.show(mainPanel, "GamePanel"));
        add(resumeButton, BorderLayout.SOUTH);
    }
}