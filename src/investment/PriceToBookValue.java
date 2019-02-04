package investment;
import company.Company;
import ratio.Ratio;

import java.util.Scanner;

public class PriceToBookValue extends Ratio {
    @Override
    public Ratio calcInputs(Company company, Ratio ratio, Scanner scanner) {

            company.addRatio(ratio);
            System.out.println("Please insert stocks Price");

            double stocksPrice = scanner.nextDouble();

            System.out.println("Please insert number of stocks");

            double stocksOutStanding = scanner.nextDouble();

            System.out.println("Please insert Current Assets");

            double totalAssets = scanner.nextDouble();

            System.out.println("Please insert Current Liabilities");

            double totalLiabilities = scanner.nextDouble();

            double bookValue = totalAssets - totalLiabilities;

            double bookValuePerShare = bookValue / stocksOutStanding;


            ratio.ratioCalculation(stocksPrice, bookValuePerShare);

            return ratio;
        }


    @Override
    public void printInfo() {
        System.out.println("The price to book ratio, also called the P/B or market to book ratio, is a financial valuation tool used to evaluate whether the stock a company is over or undervalued by comparing the price\nof all outstanding shares with the net assets of the company. In other words, it’s a calculation that measures the difference between the book value and the total share price of the company.\n");

    }

    @Override
    public void printEvaluationInfo(String companyName) {

       double ratioToEvaluate =  getResult();

       if(ratioToEvaluate > 1) {
           System.out.println(companyName+ " stock may be overvalued");

        }
       else {
           System.out.println(companyName + " stock may be undervalued");
       }

    }

    @Override
    public Ratio createSame() {
        return new PriceToBookValue();

    }
}
