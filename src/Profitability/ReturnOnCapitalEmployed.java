package Profitability;


import ratio.Ratio;

import java.util.Scanner;

public class ReturnOnCapitalEmployed extends Ratio {


    @Override
    public double calcInputs(Scanner scanner) {


        System.out.println("Please insert profit before interest and taxes or Ebit");
        double ebit = scanner.nextDouble();
        System.out.println("Please insert Total Assets");
        double totalAssets = scanner.nextDouble();
        System.out.println("Please insert Current Liabilities");
        double currentLiabilites = scanner.nextDouble();
        double employedCapital = totalAssets - currentLiabilites;

        return percentageRatioCalculation(ebit, employedCapital);



    }

    @Override
    public void printInfo() {
        System.out.println("Return on capital employed or ROCE is a profitability ratio that measures how efficiently a company can generate profits from its capital employed by comparing\nnet operating profit to capital employed.In other words, return on capital employed shows investors how many dollars in profits each dollar of capital employed generates.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

        double ratioToEvaluate = getResult();

        double ratioToformat = ratioToEvaluate / 100;


        System.out.printf("Every dollar/euro invested in employed capital " + companyName + " earns %.2f" + " dollars/euros\n", ratioToformat);
    }

    @Override
    public Ratio createSame() {
        return new ReturnOnCapitalEmployed();
    }


}
