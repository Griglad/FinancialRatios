import Profitability.NetProfitMargin;
import Profitability.ReturnOnAssets;
import Profitability.ReturnOnCapitalEmployed;
import Profitability.ReturnOnEquity;
import activity.InventoryTurnOver;
import activity.AssetTurnOver;
import company.Company;
import comparator.CompanyComparator;
import debt.Debt;
import debt.DetbtToEquity;
import debt.InterestCoverage;
import investment.PriceToBookValue;
import investment.PriceToEarnings;
import investment.PriceToSales;
import liquidity.Current;
import liquidity.Quick;
import ratio.Ratio;
import ratio.RatioStatistics;
import ratio.StatsNode;

import java.util.*;

public class Application {


    public static void main(String[] args) {


        startingMenu(yearInput());


    }

    public static String yearInput() {
        String yearRegex = "^[0-9]{4}$";
        System.out.println("Please Enter year to make calculations");
        String inputYear = scanner.nextLine();
        if(inputYear.matches(yearRegex)){
            return inputYear;
        }else{
            System.err.println("Wrong Input Year. Please enter a valid year");


            return yearInput();

        }

    }


    private static String printRatiosInfo(Company company) {

        String choice;
        System.out.println("Select which Financial Ratio category do you want to calculate. (*)Indicates the symbol");

        System.out.println("*1)Liquidity Ratios");

        System.out.println("*2)Profitability Ratios");

        System.out.println("*3)Activity Ratios");

        System.out.println("*4)Debt Ratios");

        System.out.println("*5)Investment Ratios");

        System.out.println("*6)Exit");

        choice = scanner.nextLine();

        return choice;
    }


    private static Company companyInput() {
        String regex2 = "[a-zA-Z]+\\.?";
        System.out.println("Enter please the company's name");


        String name = scanner.nextLine();
        if (name.matches(regex2)) {


            return new Company(name);


        } else {

            return null;


        }

    }

    private static void startingMenu(String year) {

        String regex1 = "[0-6]";
        Ratio ratio = null;
        Company company = companyInput();
        String ratioSelection = printRatiosInfo(company);
        if (ratioSelection.matches(regex1) && company != null) {

            processChoice(company, ratioSelection, year, ratio);
        } else {
            System.err.print("Wrong input choice or not qualified name for a company");
            scanner.close();
        }


    }


    public static void repeatMenu(Company company, String year, Ratio ratio) {
        ratio = null;
        String ratioSelection = printRatiosInfo(company);
        processChoice(company, ratioSelection, year, ratio);


    }


    private static void processChoice(Company company, String ratioSelection, String year, Ratio ratio) {


        if (ratioSelection.equals("1")) {

            firstChoiceSelected(company, year, ratio);

        } else if (ratioSelection.equals("2")) {

            secondChoiceSelected(company, year, ratio);
        } else if (ratioSelection.equals("3")) {
            thirdChoiceSelected(company, year, ratio);
        } else if (ratioSelection.equals("4")) {
            fourthChoiceSelected(company, year, ratio);
        } else if (ratioSelection.equals("5")) {
            fifthChoiceSelected(company, year, ratio);
        } else if (ratioSelection.equals("6")) {
            sixChoiceSelected();
        }

    }


    private static void firstChoiceSelected(Company company, String year, Ratio ratio) {

        System.out.println("*C)Current Ratio");
        System.out.println(" ----------------");
        System.out.println("*Q)Quick Ratio");


        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("C")) {
            ratio = new Current();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);

        } else if (choice.equalsIgnoreCase("Q")) {

            ratio = new Quick();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        } else {
            checkInput();

            firstChoiceSelected(company, year, ratio);
        }


        nextStep(company, year, ratio);


    }



    public static void secondChoiceSelected(Company company, String year, Ratio ratio) {

        System.out.println("*ROA)Return on Assets");
        System.out.println(" --------------------");
        System.out.println("*ROE)Return on Equity");
        System.out.println(" --------------------");
        System.out.println("*ROCE)Return on Capital Employed");
        System.out.println(" --------------------");
        System.out.println("*NET)Net Profit Margin");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("ROA")) {
            ratio = new ReturnOnAssets();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        } else if (choice.equalsIgnoreCase("ROE")) {

            ratio = new ReturnOnEquity();
            ratio.printInfo();
            ratio.calcInputs(company, ratio,scanner);


        } else if (choice.equalsIgnoreCase("ROCE")) {

            ratio = new ReturnOnCapitalEmployed();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);

        } else if (choice.equalsIgnoreCase("NET")) {

            ratio = new NetProfitMargin();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        }else{
            checkInput();
            secondChoiceSelected(company,year,ratio);
        }


        nextStep(company, year, ratio);


    }

    public static void thirdChoiceSelected(Company company, String year, Ratio ratio) {

        System.out.println("*I)Inventory TurnOver");
        System.out.println(" ----------------");
        System.out.println("*A)Asset TurnOver");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("I")) {

            ratio = new InventoryTurnOver();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        } else if (choice.equalsIgnoreCase("A")) {
            ratio = new AssetTurnOver();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        }else{
            checkInput();
            thirdChoiceSelected(company,year,ratio);
        }

        nextStep(company, year, ratio);


    }


    public static void fourthChoiceSelected(Company company, String year, Ratio ratio) {

        System.out.println("*D)Debt Ratio");
        System.out.println("*D/E)Debt to Equity");
        System.out.println("*I)Interest Coverage");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("D")) {
            ratio = new Debt();
            ratio.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        } else if (choice.equalsIgnoreCase("D/E")) {
            Ratio debtToEquity = new DetbtToEquity();
            debtToEquity.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        } else if (choice.equalsIgnoreCase(("I"))) {

            Ratio interestCoverage = new InterestCoverage();
            interestCoverage.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        }
        else{
            checkInput();
            fourthChoiceSelected(company,year,ratio);
        }
        nextStep(company, year, ratio);


    }

    public static void fifthChoiceSelected(Company company, String year, Ratio ratio) {
        System.out.println("*P/E)Price To Earnings");
        System.out.println("*P/B)Price to Book Value");
        System.out.println("*P/S) Price to Sales");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("P/E")) {
            Ratio priceToEarnings = new PriceToEarnings();
            priceToEarnings.printInfo();
            ratio.calcInputs(company,ratio,scanner);


        } else if (choice.equalsIgnoreCase("P/B")) {

            Ratio priceToBookValue = new PriceToBookValue();
            priceToBookValue.printInfo();
           ratio.calcInputs(company,ratio,scanner);


        } else if (choice.equalsIgnoreCase("P/S")) {


            Ratio priceToSales = new PriceToSales();

            priceToSales.printInfo();

            ratio.calcInputs(company,ratio,scanner);


        }else{
            checkInput();
            fifthChoiceSelected(company,year,ratio);
        }


        nextStep(company, year, ratio);
    }


    public static void nextStep(Company company, String year, Ratio ratio) {

        scanner.nextLine();

        System.out.println("-----------------------------------------------------");
        System.out.println("*cont)Do you want to continue with this company?");
        System.out.println("*comp)Do you want to compare with other companies?");
        System.out.println("*res)Do you want to see results?");


        String dec = scanner.nextLine();


        if (!companyList.contains(company)) {
            companyList.add(company);
        }



        if (dec.equalsIgnoreCase("comp")) {
            Company newCompany = companyInput();

        Ratio newRatio = ratio.createSame();
       newRatio.calcInputs(newCompany,newRatio,scanner);


            nextStep(newCompany, year, ratio);


        } else if (dec.equalsIgnoreCase("cont")) {

            repeatMenu(company, year, ratio);


        } else if (dec.equalsIgnoreCase("res")) {

            Collections.sort(companyList, Collections.reverseOrder(new CompanyComparator()));
            System.out.println("      Year of Calculations: " + year);
            if (companyList.size() > 1) {

                HashMap<String, StatsNode> result = calcAverage(companyList);
                for (HashMap.Entry<String,StatsNode> entry : result.entrySet()) {
                    String key = entry.getKey();
                    StatsNode value = entry.getValue();

                        if(value.percent){
                            System.out.println("Average " + key + ": " +  Math.round(value.getAverage()) + "%");


                        }else{
                            System.out.printf("Average " + key + " Ratio is %.2f\n",  value.getAverage()) ;
                        }



                }
                System.out.println("--------------Companies-------------------------");

            }

            for (Company c : companyList) {

                c.printInfo();


            }


        }




}




    public static void sixChoiceSelected() {
        scanner.close();
    }



    public static void checkInput(){
        System.err.println("Wrong input choice. Enter the right one please. (*) Indicates the symbol you should insert");

    }

    public static HashMap<String, StatsNode> calcAverage(List<Company> companies){

        RatioStatistics stats = new RatioStatistics();

        for (Company c : companyList) {
            for (Ratio r : c.getRatiosList()) {

                stats.add(r);


            }
        }

        return stats.getNodes();

        }


    static List<Company> companyList = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);

}