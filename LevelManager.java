/**
 * Adjusts game difficulty dynamically by modifying pipe spacing and speed.
 */
public class LevelManager
{
    private int pipeSpacing;
    private int pipeSpeed;

    public LevelManager()
    {
        pipeSpacing = 150;
        pipeSpeed = 5;
    }

    public void increaseDifficulty()
    {
        if (pipeSpacing > 100)
        {
            pipeSpacing -= 10;
        }
        pipeSpeed++;
    }

    public int getPipeSpacing()
    {
        return pipeSpacing;
    }

    public int getPipeSpeed()
    {
        return pipeSpeed;
    }
}