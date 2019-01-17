package ratio;


import java.text.DecimalFormat;


public abstract class Ratio {

    protected double result;
    protected String formated;
    protected DecimalFormat df = new DecimalFormat("#.###;-#.###");


    public String ratioCalculation(double amount1, double amount2) {

        result = (amount1 / amount2);
        formated = df.format(result);
        return formated;
    }


    public String percentageRatioCalculation(double amount1, double amount2) {


        result = (amount1 * 100 / amount2);
        formated = df.format(result);
        return formated;

    }


    public String getFormated() {

        return formated;
    }

    public double getResult() {
        return result;
    }

    public abstract void printInfo();

    public abstract void printEvaluationInfo(String companyName);

    @Override
    public String toString() {
        return "Ratio{" +
                "result=" + result +
                '}';
    }


}