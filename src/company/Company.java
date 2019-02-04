package company;


import Profitability.NetProfitMargin;
import Profitability.ReturnOnAssets;
import Profitability.ReturnOnCapitalEmployed;
import Profitability.ReturnOnEquity;
import ratio.Ratio;

import java.util.ArrayList;


public class Company {
    private String name;

    private ArrayList<Ratio> ratiosList = new ArrayList<>();



    public String getName(){
        return name;
    }

    public Company(String name) {
        this.name = name;
    }




    public void addRatio(Ratio aRatio) {


        ratiosList.add(aRatio);


    }


    public void printInfo() {


        for (Ratio r : ratiosList) {
            if (r instanceof ReturnOnAssets || r instanceof ReturnOnEquity || r instanceof ReturnOnCapitalEmployed || r instanceof NetProfitMargin) {
                System.out.println(name + " " + r.getClass().getSimpleName() + " Ratio in " + r.getYear()+ " is approximately " + Math.round(r.getResult()) + "%");
                r.printEvaluationInfo(name);
                System.out.println("---------------------------------------------------------------");
            } else {

                System.out.printf(name + " " + r.getClass().getSimpleName() + " Ratio in " + r.getYear()+ " is %.2f.",r.getResult());
                r.printEvaluationInfo(name);
                System.out.println("---------------------------------------------------------------");
            }


        }


    }



    public double getRatioByResult() {
        double res = 0;
        for (Ratio r : ratiosList) {
            res = r.getResult();
        }
        return res;
    }

    public ArrayList<Ratio> getRatiosList() {
        return ratiosList;
    }


}
