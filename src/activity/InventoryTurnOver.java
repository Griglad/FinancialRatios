package activity;


import ratio.Ratio;

public class InventoryTurnOver extends Ratio {

    @Override
    public void printInfo() {
        System.out.println("The inventory turnover ratio is an efficiency ratio that shows how effectively inventory is managed by comparing cost of goods sold with average inventory for a period.\nThis measures how many times average inventory is “turned” or sold during a period. In other words, it measures how many times a company sold its total average inventory dollar amount during the year.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

        double ratioToEvaluate = getResult();

       if(ratioToEvaluate < 1)
       {



           System.out.println( companyName + " only sold " + Math.round(ratioToEvaluate*100) + "% of its inventory this year");

       }

       else{
           System.out.println(companyName + " sold its inventory " + Math.round(ratioToEvaluate) +" times during the year.And also keeps its inventory for approximately " + Math.round(365/ratioToEvaluate) + " days");

       }


    }
}
