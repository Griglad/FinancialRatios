package debt;
import company.Company;
import ratio.Ratio;

import java.util.Scanner;

public class InterestCoverage extends Ratio {


    @Override
    public Ratio calcInputs(Company company, Ratio ratio, Scanner scanner) {


            company.addRatio(ratio);

            System.out.println("Please insert Earnings or profit before interest and taxes");

            double ebit = scanner.nextDouble();

            System.out.println("Please insert interest Expense");

            double interestExpense = scanner.nextDouble();

            ratio.ratioCalculation(ebit, interestExpense);
            return ratio;


    }

    @Override
    public void printInfo() {
        System.out.println("The Interest Coverage Ratio (ICR) is a financial ratio that is used to determine the ability of a company to pay the interest on its outstanding debt.\nThe ICR is commonly used by lenders, creditors, and investors to determine the riskiness of lending capital to a company. The interest coverage ratio is also called the “times interest earned” ratio.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();

        if(ratioToEvaluate < 1){
            System.out.println(companyName + " is not making enough money to pay its interest payments");

        }
        else if(ratioToEvaluate == 1){
            System.out.println(companyName + " makes just enough money to pay its interest payments");

        }

        else if(ratioToEvaluate > 1){
            System.out.println( companyName + " makes approximately " + Math.round(ratioToEvaluate) + " times more earnings than its current interest payments");
        }

    }

    @Override
    public Ratio createSame() {
        return new InterestCoverage();
    }
}
