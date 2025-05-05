import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainMenu represents the initial screen of the game with options to start or exit.
 */
public class MainMenu extends JPanel
{
    public MainMenu(JPanel mainPanel, CardLayout cardLayout)
    {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Flappy Bird", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        add(title, BorderLayout.NORTH);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 1, 10, 10));

        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cardLayout.show(mainPanel, "GamePanel");
                ((GamePanel) mainPanel.getComponent(1)).startGame();
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> System.exit(0));

        buttonsPanel.add(startButton);
        buttonsPanel.add(exitButton);

        add(buttonsPanel, BorderLayout.CENTER);
    }
}