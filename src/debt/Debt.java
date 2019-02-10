package debt;

import ratio.Ratio;

import java.util.Scanner;

public class Debt extends Ratio {


    @Override
    public Ratio calcInputs(Scanner scanner) {



            System.out.println("Please insert total Liabilities");

            double totalLiabilites = scanner.nextDouble();


            System.out.println("Please insert total Assets");

            double totalAssets = scanner.nextDouble();

            this.ratioCalculation(totalLiabilites, totalAssets);
            return this;

    }

    @Override
    public void printInfo() {
        System.out.println("Debt ratio is a solvency ratio that measures a firm’s total liabilities as a percentage of its total assets. In a sense, the debt ratio shows a company’s ability to pay off its liabilities\nwith its assets. In other words, this shows how many assets the company must sell in order to pay off all of its liabilities.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();


        System.out.printf(companyName + " for every dollar/euro has in assets it has %.2f dollar/euro worth of liabilities\n",ratioToEvaluate);


    }

    @Override
    public Ratio createSame() {
        return new Debt();
    }
}
