import java.awt.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Manages the scoring system and leaderboard.
 */
public class ScoreManager
{
    private int score;
    private ArrayList<Integer> leaderboard;

    public ScoreManager()
    {
        score = 0;
        leaderboard = new ArrayList<>();
        loadScores();
    }

    public void incrementScore()
    {
        score++;
    }

    public void saveScores()
    {
        try (PrintWriter out = new PrintWriter(new File("scores.txt")))
        {
            leaderboard.add(score);
            for (int s : leaderboard)
            {
                out.println(s);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void loadScores()
    {
        try (BufferedReader in = new BufferedReader(new FileReader("scores.txt")))
        {
            String line;
            while ((line = in.readLine()) != null)
            {
                leaderboard.add(Integer.parseInt(line));
            }
        }
        catch (IOException e)
        {
            System.out.println("No scores found. Starting fresh.");
        }
    }

    public void draw(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Score: " + score, 10, 30);
    }

    public void reset()
    {
        score = 0;
    }
}