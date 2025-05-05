import java.awt.*;

/**
 * Abstract class for all game objects.
 * Avoids code repetition for common properties and methods.
 */
public abstract class GameObject
{
    protected int x, y, width, height;

    public GameObject(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }
}