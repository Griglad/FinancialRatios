package Profitability;

import ratio.Ratio;

public class NetProfitMargin extends Ratio {


    @Override
    public void printInfo() {
        System.out.println("The net profit margin ratio, also called net margin, is a profitability metric that measures what percentage of each dollar earned by a business ends up as profit at the end of the year.\nIn other words, it shows how much net income a business makes from each dollar of sales.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

        double ratioToEvaluate = getResult();
        double ratioToFormat = ratioToEvaluate/100;

        System.out.printf(companyName + " for each 1 dollar/euro of revenue earns %.2f dollar/euros\n",ratioToFormat);

    }


}
