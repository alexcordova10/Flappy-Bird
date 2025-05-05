import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Manages the pipes in the game.
 */
public class PipeManager
{
    private ArrayList<Pipe> pipes;
    private Random random;

    public PipeManager()
    {
        pipes = new ArrayList<>();
        random = new Random();
        addPipe(800);
    }

    public void update()
    {
        for (Pipe pipe : pipes)
        {
            pipe.update();
        }
    }

    public void render(Graphics g)
    {
        for (Pipe pipe : pipes)
        {
            pipe.render(g);
        }
    }

    public boolean checkCollision(Bird bird)
    {
        for (Pipe pipe : pipes)
        {
            if (pipe.getBounds().intersects(bird.getBounds()))
            {
                return true;
            }
        }
        return false;
    }

    private void addPipe(int x)
    {
        int gap = 150;
        int topHeight = random.nextInt(300) + 50;
        pipes.add(new Pipe(x, 0, 80, topHeight));
        pipes.add(new Pipe(x, topHeight + gap, 80, 600 - topHeight - gap));
    }
}