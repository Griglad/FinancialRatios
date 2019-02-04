package Profitability;

import company.Company;
import ratio.Ratio;

import java.util.Scanner;

public class ReturnOnCapitalEmployed extends Ratio {


    @Override
    public Ratio calcInputs(Company company, Ratio ratio, Scanner scanner) {

        company.addRatio(ratio);

        System.out.println("Please insert profit before interest and taxes or Ebit");
        double ebit = scanner.nextDouble();
        System.out.println("Please insert Total Assets");
        double totalAssets = scanner.nextDouble();
        System.out.println("Please insert Current Liabilities");
        double currentLiabilites = scanner.nextDouble();
        double employedCapital = totalAssets - currentLiabilites;
        ratio.percentageRatioCalculation(ebit, employedCapital);
        return ratio;


    }

    @Override
    public void printInfo() {
        System.out.println("Return on capital employed or ROCE is a profitability ratio that measures how efficiently a company can generate profits from its capital employed by comparing net operating profit to capital employed.\nIn other words, return on capital employed shows investors how many dollars in profits each dollar of capital employed generates.\n");
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
