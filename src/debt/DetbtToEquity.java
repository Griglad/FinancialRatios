package debt;


import ratio.Ratio;

public class DetbtToEquity extends Ratio {

    @Override
    public void printInfo() {
        System.out.println("The debt to equity ratio is a financial, liquidity ratio that compares a company’s total debt to total equity. The debt to equity ratio shows the percentage of company financing that comes from\ncreditors and investors. A higher debt to equity ratio indicates that more creditor financing (bank loans) is used than investor financing (shareholders).\n");
    }

    @Override
    public void printEvaluationInfo(String companyName) {
        double ratioToEvaluate = getResult();

        System.out.printf("For every dollar/euro owned by the stakeholders " +companyName+ " owes %.2f to creditors\n",ratioToEvaluate);
    }
}
