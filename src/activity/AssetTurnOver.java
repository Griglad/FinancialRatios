package activity;
import ratio.Ratio;

public class AssetTurnOver extends Ratio {


    @Override
    public void printInfo() {
        System.out.println("The asset turnover ratio is an efficiency ratio that measures a company’s ability to generate sales from its assets by comparing net sales with average total assets.\nIn other words, this ratio shows how efficiently a company can use its assets to generate sales.\n");

    }

    @Override
    public void printEvaluationInfo(String companyName) {
      double ratioToEvaluate = getResult();


        System.out.printf("For every dollar/euro in assets " + companyName +  " generates %.2f dollar/euro in sales\n",ratioToEvaluate );

    }
}
