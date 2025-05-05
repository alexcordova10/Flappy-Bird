import java.awt.*;

/**
 * Represents the bird character in the Flappy Bird game.
 */
public class Bird extends GameObject
{
    private float velocity;
    private final float gravity = 0.4f;
    private final float jumpStrength = -10f;

    public Bird(int x, int y, int width, int height)
    {
        super(x, y, width, height);
        this.velocity = 0;
    }

    @Override
    public void update()
    {
        velocity += gravity;
        y += velocity;
    }

    public void jump()
    {
        velocity = jumpStrength;
    }

    @Override
    public void render(Graphics g)
    {
        g.setColor(Color.YELLOW);
        g.fillOval(x, y, width, height);
    }
}