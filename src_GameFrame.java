import javax.swing.*;
import java.awt.*;

/**
 * GameFrame is the main window setup for the Flappy Bird game.
 * Manages panel swapping using CardLayout.
 */
public class GameFrame extends JFrame
{
    public GameFrame()
    {
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        MainMenu mainMenu = new MainMenu(mainPanel, cardLayout);
        GamePanel gamePanel = new GamePanel(mainPanel, cardLayout);
        PauseScreen pauseScreen = new PauseScreen(mainPanel, cardLayout);

        mainPanel.add(mainMenu, "MainMenu");
        mainPanel.add(gamePanel, "GamePanel");
        mainPanel.add(pauseScreen, "PauseScreen");

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new GameFrame();
    }
}