package liquidity;

import ratio.Ratio;

import java.util.Scanner;

public class Cash  extends Ratio {


    @Override
    public double calcInputs(Scanner scanner) {


        System.out.println("Please insert Cash and Cash Equivalents");

        double cashEquivalents  = scanner.nextDouble();

        System.out.println("Please insert the Current Liabilities");

        double currentLiabilities = scanner.nextDouble();

        return ratioCalculation(cashEquivalents, currentLiabilities);


    }

    @Override
    public void printInfo() {
        System.out.println("The cash ratio, sometimes referred to as the cash asset ratio, is a liquidity metric that indicates a company’s capacity to pay off short-term debt obligations with its cash and cash equivalents.\nCompared to other liquidity ratios such as the current ratio and quick ratio, the cash ratio is a stricter, more conservative measure because only cash and cash equivalents.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
            double ratioToEvaluate = getResult();

            if(ratioToEvaluate == 1){
                System.out.println(companyName + " has exactly the same amount of current liabilities as it does cash and cash equivalents to pay off those debts.");
            }else if(ratioToEvaluate > 1){
                System.out.println(companyName + " has more cash and cash equivalents than current liabilities.");
            }else {
                System.out.println(companyName + "  has more current liabilities than cash and cash equivalents. In this situation, there is insufficient cash on hand to pay off short-term debt.");
            }

    }

    @Override
    public Ratio createSame() {
        return new Cash();
    }


}
