package Profitability;
import ratio.Ratio;


public class ReturnOnEquity extends Ratio {

    @Override
    public void printInfo() {
        System.out.println("The return on equity ratio or ROE is a profitability ratio that measures the ability of a firm to generate profits from its shareholders investments in the company.\nIn other words, the return on equity ratio shows how much profit each dollar of common stockholders’ equity generates.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

        double ratioToEvaluate =  getResult();

        double ratioToFormat = ratioToEvaluate/100;

        System.out.printf("Every dollar/euro of common shareholders equity earned about %.2f" + " this year\n",ratioToFormat);


    }


}
