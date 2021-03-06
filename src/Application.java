import Profitability.NetProfitMargin;
import Profitability.ReturnOnAssets;
import Profitability.ReturnOnCapitalEmployed;
import Profitability.ReturnOnEquity;
import activity.InventoryTurnOver;
import activity.AssetTurnOver;
import company.Company;
import debt.Debt;
import debt.DetbtToEquity;
import debt.InterestCoverage;
import investment.PriceToBookValue;
import investment.PriceToEarnings;
import investment.PriceToSales;
import liquidity.Cash;
import liquidity.Current;
import liquidity.Quick;
import ratio.Ratio;
import ratio.RatioStatistics;
import ratio.StatsNode;

import java.util.*;

public class Application {


    public static void main(String[] args) {

        Company company = companyInput();
        startingMenu(yearInput(), company);


    }

    private static String yearInput() {
        String yearRegex = "^[0-9]{4}$";
        System.out.println("Please Enter year to make calculations");
        String inputYear = scanner.nextLine();
        if (inputYear.matches(yearRegex)) {
            return inputYear;
        } else {
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
        String regex = ("^[a-zA-Z ]*$");
        System.out.println("Enter please the company's name");

        String name = scanner.nextLine();


        if (!name.matches(regex) || name.isEmpty()) {
            System.err.println("Not qualified name for a Company please insert a right one");

            return companyInput();
        } else {
            return new Company(name);

        }


    }


    private static void startingMenu(String year, Company company) {

        String regex1 = "[0-6]";

        Ratio ratio = null;


        String ratioSelection = printRatiosInfo(company);
        if (ratioSelection.matches(regex1)) {

            processChoice(company, ratioSelection, year, ratio);

        } else {
            System.err.println("Wrong input choice");
            startingMenu(year, company);
        }


    }


    private static void repeatMenu(Company company, String year, Ratio ratio) {
        ratio = null;
        String ratioSelection = printRatiosInfo(company);
        processChoice(company, ratioSelection, year, ratio);


    }


    private static void processChoice(Company company, String ratioSelection, String year, Ratio ratio) {


        if (ratioSelection.equals("1")) {

            liquidityRatiosSelected(company, year, ratio);

        } else if (ratioSelection.equals("2")) {

            profitabilityRatiosSelected(company, year, ratio);
        } else if (ratioSelection.equals("3")) {
            activityRatiosSelected(company, year, ratio);
        } else if (ratioSelection.equals("4")) {
            debtRatiosSelected(company, year, ratio);
        } else if (ratioSelection.equals("5")) {
            investmentRatiosSelected(company, year, ratio);
        } else if (ratioSelection.equals("6")) {
            sixChoiceSelected();
        }

    }


    private static void liquidityRatiosSelected(Company company, String year, Ratio ratio) {

        System.out.println("*C)Current Ratio");
        System.out.println(" ----------------");
        System.out.println("*Q)Quick Ratio");
        System.out.println(" ----------------");
        System.out.println("*CA)Cash Ratio");

        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("C")) {
            ratio = new Current();

        } else if (choice.equalsIgnoreCase("Q")) {

            ratio = new Quick();


        } else if (choice.equalsIgnoreCase("CA")) {
            ratio = new Cash();
        } else {
            checkInput();

            liquidityRatiosSelected(company, year, ratio);
        }

        proceedChoice(ratio, year, company);

    }


    private static void profitabilityRatiosSelected(Company company, String year, Ratio ratio) {

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


        } else if (choice.equalsIgnoreCase("ROE")) {

            ratio = new ReturnOnEquity();

        } else if (choice.equalsIgnoreCase("ROCE")) {

            ratio = new ReturnOnCapitalEmployed();

        } else if (choice.equalsIgnoreCase("NET")) {

            ratio = new NetProfitMargin();


        } else {
            checkInput();
            profitabilityRatiosSelected(company, year, ratio);
        }

        proceedChoice(ratio, year, company);


    }


    private static void activityRatiosSelected(Company company, String year, Ratio ratio) {

        System.out.println("*I)Inventory TurnOver");
        System.out.println(" ----------------");
        System.out.println("*A)Asset TurnOver");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("I")) {

            ratio = new InventoryTurnOver();


        } else if (choice.equalsIgnoreCase("A")) {
            ratio = new AssetTurnOver();

        } else {
            checkInput();
            activityRatiosSelected(company, year, ratio);
        }

        proceedChoice(ratio, year, company);


    }


    private static void debtRatiosSelected(Company company, String year, Ratio ratio) {

        System.out.println("*D)Debt Ratio");
        System.out.println("*D/E)Debt to Equity");
        System.out.println("*I)Interest Coverage");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("D")) {
            ratio = new Debt();


        } else if (choice.equalsIgnoreCase("D/E")) {
            ratio = new DetbtToEquity();


        } else if (choice.equalsIgnoreCase(("I"))) {

            ratio = new InterestCoverage();


        } else {
            checkInput();
            debtRatiosSelected(company, year, ratio);
        }
        proceedChoice(ratio, year, company);


    }

    private static void investmentRatiosSelected(Company company, String year, Ratio ratio) {
        System.out.println("*P/E)Price To Earnings");
        System.out.println("*P/B)Price to Book Value");
        System.out.println("*P/S) Price to Sales");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("P/E")) {
            ratio = new PriceToEarnings();


        } else if (choice.equalsIgnoreCase("P/B")) {

            ratio = new PriceToBookValue();


        } else if (choice.equalsIgnoreCase("P/S")) {


            ratio = new PriceToSales();


        } else {
            checkInput();
            investmentRatiosSelected(company, year, ratio);
        }


        proceedChoice(ratio, year, company);
    }


    private static void proceedChoice(Ratio ratio, String year, Company company) {

        ratio.setYear(year);

        ratio.printInfo();

        ratio.calcInputs(scanner);

        company.addRatio(ratio);

        decisionStep(company, year, ratio);

    }


    private static void decisionStep(Company company, String year, Ratio ratio) {

        scanner.nextLine();

        System.out.println("How do you want to Proceed?");
        System.out.println("-----------------------------------------------------");
        System.out.println("*continue)Do you want to continue with " + company.getName() + " in " + year);
        System.out.println("*another)Do you want to continue with " + company.getName() + " in another year?");
        System.out.println("*compare)Do you want to compare " + company.getName() + " " + ratio.getClass().getSimpleName() + " Ratio with other companies in " + year);
        System.out.println("*compare year)Do you want to compare " + company.getName() + " " + ratio.getClass().getSimpleName() + " Ratio with other companies in another year?");
        System.out.println("*results)Do you want to see the results?");


        String dec = scanner.nextLine();
        if (!numOfYears.contains(year)) {
            numOfYears.add(year);
        }

        if (!companyList.contains(company)) {
            companyList.add(company);
        }


        if (dec.equalsIgnoreCase("compare")) {
            Company newCompany = companyInput();

            Ratio newRatio = ratio.createSame();
            newRatio.setYear(year);
            newRatio.calcInputs(scanner);
            newCompany.addRatio(newRatio);

            decisionStep(newCompany, year, newRatio);


        } else if (dec.equalsIgnoreCase("compare year")) {
            Company newCompany = companyInput();
            Ratio newRatio = ratio.createSame();
            String newYear = yearInput();
            newRatio.setYear(newYear);
            newRatio.calcInputs(scanner);
            newCompany.addRatio(newRatio);
            decisionStep(newCompany, newYear, newRatio);

        } else if (dec.equalsIgnoreCase("continue")) {


            repeatMenu(company, year, ratio);


        } else if (dec.equalsIgnoreCase("another")) {

            startingMenu(yearInput(), company);

        } else if (dec.equalsIgnoreCase("results")) {

            Collections.sort(companyList, Collections.reverseOrder((company1,company2)->(Double.compare(company1.getRatioByResult(), company2.getRatioByResult()))));


            System.out.println("      Year of Calculations: " + numOfYears);

            if (companyList.size() > 1) {

                HashMap<String, StatsNode> result = calcAverage(companyList);


                    result.entrySet().stream().filter(e -> e.getValue().percent).forEach(e -> System.out.println("Average" + e.getKey() + ": " + Math.round(e.getValue().getAverage()) + "%"));
                    result.entrySet().stream().filter(e -> !e.getValue().percent).forEach(e -> System.out.printf("Average " + e.getKey() + " Ratio is %.2f\n", e.getValue().getAverage()));



                }
                System.out.println("--------------Companies-------------------------");

            }

        companyList.forEach(e -> e.printInfo());
            endingMessage();
        }





    private static void endingMessage() {

        System.out.println("How do you want to continue? (*)Indicates the Symbol");
        System.out.println("*c)Make more Calculations");
        System.out.println("*e)Exit");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("c")) {
            startingMenu(yearInput(), companyInput());

        } else if (choice.equalsIgnoreCase("e")) {
            scanner.close();
        } else {
            System.err.println("Wrong Input Choice");
            endingMessage();
        }

    }


    private static void sixChoiceSelected() {
        scanner.close();
    }


    private static void checkInput() {
        System.err.println("Wrong input choice. Enter the right one please. (*) Indicates the symbol you should insert");

    }

    private static HashMap<String, StatsNode> calcAverage(List<Company> companies) {

        RatioStatistics stats = new RatioStatistics();

        for (Company c : companyList) {
            for (Ratio r : c.getRatiosList()) {

                stats.add(r);


            }
        }

        return stats.getNodes();

    }


    private static List<Company> companyList = new ArrayList<>();

    private static List<String> numOfYears = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

}