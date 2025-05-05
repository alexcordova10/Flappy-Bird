import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * GamePanel handles the core game loop, rendering, and collisions.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener
{
    private Timer timer;
    private Bird bird;
    private PipeManager pipeManager;
    private ScoreManager scoreManager;
    private LevelManager levelManager;
    private CharacterManager characterManager;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private boolean isRunning;

    public GamePanel(JPanel mainPanel, CardLayout cardLayout)
    {
        this.mainPanel = mainPanel;
        this.cardLayout = cardLayout;

        setFocusable(true);
        addKeyListener(this);

        levelManager = new LevelManager();
        characterManager = new CharacterManager();
        bird = new Bird(100, 300, 40, 40); // Default bird
        pipeManager = new PipeManager(levelManager);
        scoreManager = new ScoreManager();

        timer = new Timer(20, this);
        isRunning = false;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        // Background
        GradientPaint sky = new GradientPaint(0, 0, Color.CYAN, 0, getHeight(), Color.WHITE);
        ((Graphics2D) g).setPaint(sky);
        g.fillRect(0, 0, getWidth(), getHeight());

        bird.render(g);
        pipeManager.draw(g);
        scoreManager.draw(g);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (isRunning)
        {
            bird.update();
            pipeManager.update();
            checkCollisions();
            repaint();
        }
    }

    private void checkCollisions()
    {
        if (pipeManager.checkCollision(bird))
        {
            isRunning = false;
            timer.stop();
            cardLayout.show(mainPanel, "PauseScreen");
        }
    }

    public void startGame()
    {
        isRunning = true;
        bird = characterManager.getCurrentBird(); // Selected bird
        pipeManager.reset();
        scoreManager.reset();
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_SPACE)
        {
            bird.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}