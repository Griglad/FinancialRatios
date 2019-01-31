package liquidity;
import company.Company;
import ratio.Ratio;

import java.util.Scanner;


public class Quick extends Ratio {


    @Override
    public Ratio calcInputs(Company company, Ratio ratio, Scanner scanner) {




            company.addRatio(ratio);


            System.out.println("Please insert the Current Assets");

            double currentAssets = scanner.nextDouble();

            System.out.println("Please insert inventory");

            double inventory = scanner.nextDouble();

            System.out.println("Please insert the Current Liabilities");
            Double currentLiabilities = scanner.nextDouble();

            System.out.println("Please insert Prepaid expenses");
            double prepaidExpenses = scanner.nextDouble();

            double liquidAssets = currentAssets - inventory - prepaidExpenses;

            ratio.ratioCalculation(liquidAssets, currentLiabilities);

            return ratio;

        }



    @Override
    public void printInfo() {


            System.out.println("The quick ratio or acid test ratio is a liquidity ratio that measures the ability of a company to pay its current liabilities\nwhen they come due with only quick assets.Quick assets are current assets that can be converted to cash within 90 days or in the short-term\n");



    }

    public void printEvaluationInfo(String companyName)
    {
        double ratioToevaluate = getResult();
         if(ratioToevaluate>1)
        {
            System.out.println(companyName + " is fully equipped with sufficient assets that can be instantly liquidated to pay off its current liabilities");
        }

         else
        {
            System.out.println(companyName + " may not be able to fully pay off its current liabilities in short-term");
        }

    }

    @Override
    public Ratio createSame() {
        return new Quick();
    }





}
