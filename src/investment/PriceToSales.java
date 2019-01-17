package investment;

import ratio.Ratio;

public class PriceToSales extends Ratio {
    @Override
    public void printInfo() {
        System.out.println("The price-to-sales ratio is a valuation ratio that compares a company’s stock price to its revenues.\nThe price-to-sales ratio is an indicator of the value placed on each dollar of a company’s sales or revenues.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();

        System.out.printf("In" + companyName + " investors are willing to pay %.2f dollar/euro for every dollar/euro of sales a share made.\n",ratioToEvaluate);
    }
}
