package Profitability;

import ratio.Ratio;

public class ReturnOnCapitalEmployed extends Ratio {


    @Override
    public void printInfo() {
        System.out.println("Return on capital employed or ROCE is a profitability ratio that measures how efficiently a company can generate profits from its capital employed by comparing net operating profit to capital employed.\nIn other words, return on capital employed shows investors how many dollars in profits each dollar of capital employed generates.\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {

      double ratioToEvaluate =   getResult();

      double ratioToformat = ratioToEvaluate/100;


        System.out.printf("Every dollar/euro invested in employed capital "  +companyName +   " earns %.2f"  +" dollars/euros\n",ratioToformat);
    }




}
