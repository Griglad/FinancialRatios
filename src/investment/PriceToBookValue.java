package investment;
import ratio.Ratio;

public class PriceToBookValue extends Ratio {
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
}
