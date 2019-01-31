package Profitability;

import company.Company;
import ratio.Ratio;

import java.util.Scanner;


public class ReturnOnAssets extends Ratio {


    @Override
    public Ratio calcInputs(Company company, Ratio ratio, Scanner scanner) {

            company.addRatio(ratio);


            System.out.println("Please insert net Income or net Profit");
            double netIncome = scanner.nextDouble();
            System.out.println("Please insert total Assets of current year");
            double currentYearAssets = scanner.nextDouble();
            System.out.println("Please insert total Assets of previous year");
            double previousYearAssets = scanner.nextDouble();
            double averageTotalAssets = (currentYearAssets + previousYearAssets) / 2;

            ratio.percentageRatioCalculation(netIncome, averageTotalAssets);

            return ratio;
        }



    @Override
    public void printInfo() {
        System.out.println("The return on assets ratio, often called the return on total assets, is a profitability ratio that measures the net income produced by total assets during a period by comparing\nnet income to the average total assets. In other words, the return on assets ratio or ROA measures how efficiently a company can manage its assets to produce profits during a period.\n");
    }

    @Override
    public void printEvaluationInfo(String  companyName) {

        double ratioToEvaluate = getResult();

        double ratioToFormat = ratioToEvaluate/100;

        System.out.printf("For every dollar/euro that "  + companyName + " invested in assets during the year produced %.2f" + " dollars/euros\n", ratioToFormat);


    }

    @Override
    public Ratio createSame() {
        return new ReturnOnAssets();
    }




}
