import java.awt.*;

/**
 * Manages character selection for the game.
 */
public class CharacterManager
{
    private Bird defaultBird;

    public CharacterManager()
    {
        defaultBird = new Bird(100, 300, 40, 40);
    }

    public Bird getCurrentBird()
    {
        return defaultBird;
    }
}