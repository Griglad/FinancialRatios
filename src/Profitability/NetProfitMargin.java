package Profitability;

import ratio.Ratio;

import java.util.Scanner;

public class NetProfitMargin extends Ratio {


    @Override
    public Ratio calcInputs( Scanner scanner) {


        System.out.println("Please insert net income or net Profit");
        double netIncome = scanner.nextDouble();
        System.out.println("Please insert Gross Revenue");
        double grossRevenue = scanner.nextDouble();
        System.out.println("Please insert Cost of sales or Cost of Goods Sold");
        double cogs = scanner.nextDouble();
        double revenue = grossRevenue + cogs;
        this.percentageRatioCalculation(netIncome, revenue);
        return this;

    }


    @Override
    public void printInfo() {
        System.out.println("The net profit margin ratio, also called net margin, is a profitability metric that measures what percentage of each dollar earned by a business ends up as profit at the end of the year.\nIn other words, it shows how much net income a business makes from each dollar of sales.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

        double ratioToEvaluate = getResult();
        double ratioToFormat = ratioToEvaluate / 100;

        System.out.printf(companyName + " for each 1 dollar/euro of revenue earns %.2f dollar/euros\n", ratioToFormat);

    }

    @Override
    public Ratio createSame() {
        return new NetProfitMargin();
    }


}
