package Profitability;


import ratio.Ratio;

import java.util.Scanner;


public class ReturnOnEquity extends Ratio {

    @Override
    public Ratio calcInputs(Scanner scanner) {


        System.out.println("Please insert net Income or net Profit");
        double netIncome = scanner.nextDouble();
        System.out.println("Please insert total equity");
        double totalEquity = scanner.nextDouble();
        this.percentageRatioCalculation(netIncome, totalEquity);
        return this;
    }


    @Override
    public void printInfo() {
        System.out.println("The return on equity ratio or ROE is a profitability ratio that measures the ability of a firm to generate profits from its shareholders investments in the company.\nIn other words, the return on equity ratio shows how much profit each dollar of common stockholders’ equity generates.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

        double ratioToEvaluate = getResult();

        double ratioToFormat = ratioToEvaluate / 100;

        System.out.printf("Every dollar/euro of common shareholders equity earned about %.2f" + " this year\n", ratioToFormat);


    }

    @Override
    public Ratio createSame() {
        return new ReturnOnEquity();
    }


}
