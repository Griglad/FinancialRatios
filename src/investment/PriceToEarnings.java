package investment;


import company.Company;
import ratio.Ratio;

import java.util.Scanner;

public class PriceToEarnings extends Ratio {


    @Override
    public Ratio calcInputs(Company company, Ratio ratio, Scanner scanner) {

            company.addRatio(ratio);

            System.out.println("Please insert Price Per Share or stocks price");

            double stockPrice = scanner.nextDouble();

            System.out.println("Please insert Earnings Per Share");

            double eps = scanner.nextDouble();

            ratio.ratioCalculation(stockPrice, eps);


            return ratio;
        }


    @Override
    public void printInfo() {
        System.out.println("The price earnings ratio, often called the P/E ratio or price to earnings ratio, is a market prospect ratio that calculates the market value of a stock relative to its earnings\nby comparing the market price per share by the earnings per share. In other words, the price earnings ratio shows what the market is willing to pay for a stock based on its current earnings\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();

        System.out.printf("The market is willing to pay %.2f dollar/euro for every 1 dollar/euro of earnings\n",ratioToEvaluate);

    }

    @Override
    public Ratio createSame() {
        return new PriceToEarnings();
    }
}
