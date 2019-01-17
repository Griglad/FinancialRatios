package liquidity;
import ratio.Ratio;

public class Current extends Ratio {


    @Override
    public void printInfo() {
        System.out.println("The current ratio is a liquidity ratio that measures a company's ability to pay short-term and long-term obligations");
        System.out.println("A current ratio that is in line with the industry average or slightly higher is generally considered acceptable.\nA current ratio that is lower than the industry average may indicate a higher risk of distress or default. \nSimilarly, if a company has a very high current ratio compared to their peer group, it indicates that management may not be using their assets efficiently.\n");
    }

    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();
        if (ratioToEvaluate < 1) {
            System.out.println(companyName + " may not have the capital  to meet its short term obligations");

        } else if (ratioToEvaluate >= 1 && ratioToEvaluate <= 3) {
            System.out.println( companyName+ " can cover its short-term liabilities");
        } else if (ratioToEvaluate > 3) {
            System.out.println(companyName + " may not using its current assets efficiently");
        }


    }


}
