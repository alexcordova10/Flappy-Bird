import java.awt.*;

/**
 * Represents a pipe obstacle in the game.
 */
public class Pipe extends GameObject
{
    public Pipe(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    @Override
    public void update()
    {
        x -= 5; // Move left
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);
    }
}