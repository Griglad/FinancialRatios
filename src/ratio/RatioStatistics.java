package ratio;

import Profitability.NetProfitMargin;
import Profitability.ReturnOnAssets;
import Profitability.ReturnOnCapitalEmployed;
import Profitability.ReturnOnEquity;

import java.util.HashMap;

public class RatioStatistics {

    public RatioStatistics()
    {
        nodes = new HashMap<String, StatsNode>();
    }

    public void add(Ratio r)
    {
        String name = r.getClass().getSimpleName();
        if (nodes.containsKey(name))
        {
            StatsNode n = nodes.get(name);
            n.value += r.getResult();
            n.counter += 1;
            nodes.put(name, n);
        }
        else
        {
            StatsNode n = new StatsNode();
            n.value = r.getResult();
            n.counter = 1;
            n.percent = (r instanceof ReturnOnAssets || r instanceof NetProfitMargin || r instanceof ReturnOnEquity || r instanceof ReturnOnCapitalEmployed);
            nodes.put(name, n);
        }
    }

    public HashMap<String, StatsNode> getNodes()
    {
        return nodes;
    }


    private HashMap<String, StatsNode> nodes;
}
