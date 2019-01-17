package investment;


import ratio.Ratio;

public class PriceToEarnings extends Ratio {


    @Override
    public void printInfo() {
        System.out.println("The price earnings ratio, often called the P/E ratio or price to earnings ratio, is a market prospect ratio that calculates the market value of a stock relative to its earnings\nby comparing the market price per share by the earnings per share. In other words, the price earnings ratio shows what the market is willing to pay for a stock based on its current earnings\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();

        System.out.printf("The market is willing to pay %.2f dollar/euro for every 1 dollar/euro of earnings\n",ratioToEvaluate);

    }
}
