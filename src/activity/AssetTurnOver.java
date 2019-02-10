package activity;
import ratio.Ratio;

import java.util.Scanner;

public class AssetTurnOver extends Ratio {


    @Override
    public Ratio calcInputs( Scanner scanner) {



            System.out.println("Please insert Gross revenue");
            double grossRevenue = scanner.nextDouble();
            System.out.println("Please insert Cost of Sales or Cost Of Goods Sold");
            double cogs = scanner.nextDouble();
            double revenue = grossRevenue + cogs;
            System.out.println("Please insert assets of current year");
            double assetsOfCurrentYear = scanner.nextDouble();
            System.out.println("Please insert assets of previous year");
            double assetsOfPreviousYear = scanner.nextDouble();
            double averageTotalAssets = (assetsOfCurrentYear + assetsOfPreviousYear) / 2;
            this.ratioCalculation(revenue, averageTotalAssets);
            return this;




    }

    @Override
    public void printInfo() {
        System.out.println("The asset turnover ratio is an efficiency ratio that measures a company’s ability to generate sales from its assets by comparing net sales with average total assets.\nIn other words, this ratio shows how efficiently a company can use its assets to generate sales.\n");

    }

    @Override
    public void printEvaluationInfo(String companyName) {
      double ratioToEvaluate = getResult();


        System.out.printf("For every dollar/euro in assets " + companyName +  " generates %.2f dollar/euro in sales\n",ratioToEvaluate );

    }

    @Override
    public Ratio createSame() {
        return new AssetTurnOver();
    }
}
