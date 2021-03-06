package investment;

import ratio.Ratio;

import java.util.Scanner;

public class PriceToSales extends Ratio {
    @Override
    public double calcInputs(Scanner scanner) {


        System.out.println("Please insert Net Sales");

        double netSales = scanner.nextDouble();

        System.out.println("Please insert Market Capitalization");

        double marketCap = scanner.nextDouble();

        return ratioCalculation(netSales, marketCap);



    }


    @Override
    public void printInfo() {
        System.out.println("The price-to-sales ratio is a valuation ratio that compares a company’s stock price to its revenues.\nThe price-to-sales ratio is an indicator of the value placed on each dollar of a company’s sales or revenues.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();

        System.out.printf("In " + companyName + " investors are willing to pay %.2f dollar/euro for every dollar/euro of sales a share made.\n", ratioToEvaluate);
    }

    @Override
    public Ratio createSame() {
        return new PriceToSales();

    }
}
