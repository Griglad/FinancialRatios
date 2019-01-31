package ratio;

public class StatsNode
{
    public double value = 0.0;
    public int counter = 0;
    public boolean percent = false;

    public double getAverage()
    {
        return (counter != 0) ? (value / counter) : 0;
    }
}
