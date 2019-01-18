package ratio;

public abstract class Ratio {

    protected double result;


    public double ratioCalculation(double amount1, double amount2) {

        result = (amount1 / amount2);

        return result;
    }


    public double percentageRatioCalculation(double amount1, double amount2) {


        result = (amount1 * 100 / amount2);

       return result;

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