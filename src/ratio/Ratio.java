package ratio;

import java.util.Scanner;

public abstract class Ratio {

    protected double result;
    protected String year;


    public double ratioCalculation(double amount1, double amount2) {

        result = (amount2 != 0) ? (amount1 / amount2) : 0;
        return result;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public double percentageRatioCalculation(double amount1, double amount2) {

        result = (amount2 != 0) ? (amount1 * 100 / amount2) : 0;
        return result;
    }


    public abstract Ratio calcInputs(Scanner scanner);

    public double getResult() {
        return result;
    }

    public abstract void printInfo();

    public abstract void printEvaluationInfo(String companyName);

    public abstract Ratio createSame();

    @Override
    public String toString() {
        return "Ratio{" +
                "result=" + result +
                '}';
    }


}