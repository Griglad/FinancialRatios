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

import java.util.*;

public class Application {


    public static void main(String[] args) {

        try {
            startingMenu(yearInput());
        } catch (InputMismatchException e) {
            System.err.print("Please enter a numeric value");
            scanner.close();
        }


    }

    public static int yearInput() {
        System.out.println("Please Enter year to make calculations");

        int year = scanner.nextInt();
        scanner.nextLine();
        return year;


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


    private static void startingMenu(int year) {

        String regex1 = "[0-6]";
        String regex2 = "[a-zA-Z]+\\.?";
        System.out.println("Enter please the company's name");


        String name = scanner.nextLine();
        if (name.matches(regex2)) {


            Company company = new Company(name);

            String ratioSelection = printRatiosInfo(company);
            if (ratioSelection.matches(regex1)) {

                processChoice(company, ratioSelection, year);
            } else {
                System.err.print("Only numbers are allowed from 0-6");
                scanner.close();
            }


        } else {
            System.err.print("Only letters are allowed for a company");
            scanner.close();
        }


    }


    public static void repeatMenu(Company company, int year) {

        String ratioSelection = printRatiosInfo(company);
        processChoice(company, ratioSelection, year);


    }

    private static void processChoice(Company company, String ratioSelection, int year) {


        if (ratioSelection.equals("1")) {

            firstChoiceSelected(company, year);

        } else if (ratioSelection.equals("2")) {

            secondChoiceSelected(company, year);
        } else if (ratioSelection.equals("3")) {
            thirdChoiceSelected(company, year);
        } else if (ratioSelection.equals("4")) {
            fourthChoiceSelected(company, year);
        } else if (ratioSelection.equals("5")) {
            fifthChoiceSelected(company, year);
        } else if (ratioSelection.equals("6")) {
            sixChoiceSelected();
        }

    }


    private static void firstChoiceSelected(Company company, int year) {

        System.out.println("*C)Current Ratio");
        System.out.println(" ----------------");
        System.out.println("*Q)Quick Ratio");



        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("C")) {

            Ratio currentRatio = new Current();


            currentRatio.printInfo();

            company.addRatio(currentRatio);

            System.out.println("Please insert the Current Assets");

            double currentAssets = scanner.nextDouble();

            System.out.println("Please insert the Current Liabilities");

            double currentLiabilities = scanner.nextDouble();


            currentRatio.ratioCalculation(currentAssets, currentLiabilities);


        } else if (choice.equalsIgnoreCase("Q")) {

            Quick quickRatio = new Quick();

            quickRatio.printInfo();

            company.addRatio(quickRatio);

            System.out.println("Please insert the Current Assets");

            double currentAssets = scanner.nextDouble();

            System.out.println("Please insert inventory");

            double inventory = scanner.nextDouble();

            System.out.println("Please insert the Current Liabilities");
            Double currentLiabilities = scanner.nextDouble();

            System.out.println("Please insert Prepaid expenses");
            double prepaidExpenses = scanner.nextDouble();

            double liquidAssets = currentAssets - inventory - prepaidExpenses;

            quickRatio.ratioCalculation(liquidAssets, currentLiabilities);



        } else {
            System.err.println("Wrong input choice");
            System.out.println("Enter the right one Please");
            firstChoiceSelected(company, year);
        }


        nextStep(company, year);


    }


    public static void nextStep(Company company, int year) {
        scanner.nextLine();


        System.out.println("-----------------------------------------------------");
        System.out.println("*cont)Do you want to continue with this company?");
        System.out.println("*comp)Do you want to compare with other companies?");
        System.out.println("*res)Do you want to see results?");

        if (!companyList.contains(company)) {
            companyList.add(company);
        }

        String dec = scanner.nextLine();

        if (dec.equalsIgnoreCase("comp")) {
            System.out.println("Note: You should compare Ratios with the same type between companies.Furthermore compare companies which belong to the same industry");
            startingMenu(year);
        } else if (dec.equalsIgnoreCase("cont")) {

            repeatMenu(company, year);

        } else if (dec.equalsIgnoreCase("res")) {

            Collections.sort(companyList, Collections.reverseOrder(new CompanyComparator()));
            System.out.println("      Year of Calculations:" + year);
            if (companyList.size() > 1) {


                for (Ratio r : company.getRatiosList()) {
                    if (r instanceof ReturnOnAssets || r instanceof ReturnOnCapitalEmployed || r instanceof ReturnOnEquity || r instanceof NetProfitMargin) {
                        System.out.println("Average " + r.getClass().getSimpleName() + " Ratio by industry is " + Math.round(calcAverage()) + "%");
                    } else {
                        System.out.printf("Average " + r.getClass().getSimpleName() + " Ratio by industry is %.2f\n", calcAverage());


                    }
                    System.out.println("--------------Companies-------------------------");
                }


            }



            for (Company c : companyList) {


                c.printInfo();


            }


        }
    }


    public static double calcAverage() {

        double sum = 0;
        for (Company c : companyList) {
            for (Ratio r : c.getRatiosList())
                sum += c.getRatioByResult();
        }
        return sum / companyList.size();


    }


    public static void secondChoiceSelected(Company company, int year) {

        System.out.println("*ROA)Return on Assets");
        System.out.println(" --------------------");
        System.out.println("*ROE)Return on Equity");
        System.out.println(" --------------------");
        System.out.println("*ROCE)Return on Capital Employed");
        System.out.println(" --------------------");
        System.out.println("*NET)Net Profit Margin");
        String choice = scanner.nextLine();


        if (choice.equalsIgnoreCase("ROA")) {

            ReturnOnAssets returnOnAssetsRatio = new ReturnOnAssets();
            company.addRatio(returnOnAssetsRatio);
            returnOnAssetsRatio.printInfo();
            System.out.println("Please insert net Income or net Profit");
            double netIncome = scanner.nextDouble();
            System.out.println("Please insert total Assets of current year");
            double currentYearAssets = scanner.nextDouble();
            System.out.println("Please insert total Assets of previous year");
            double previousYearAssets = scanner.nextDouble();
            double averageTotalAssets = (currentYearAssets + previousYearAssets) / 2;

            returnOnAssetsRatio.percentageRatioCalculation(netIncome, averageTotalAssets);

        } else if (choice.equalsIgnoreCase("ROE")) {
            Ratio returnOnEquityRatio = new ReturnOnEquity();
            returnOnEquityRatio.printInfo();
            company.addRatio(returnOnEquityRatio);
            System.out.println("Please insert net Income or net Profit");
            double netIncome = scanner.nextDouble();
            System.out.println("Please insert total equity");
            double totalEquity = scanner.nextDouble();
            returnOnEquityRatio.percentageRatioCalculation(netIncome, totalEquity);

        } else if (choice.equalsIgnoreCase("ROCE")) {
            Ratio returnOnCapitalEmployedRatio = new ReturnOnCapitalEmployed();
            returnOnCapitalEmployedRatio.printInfo();
            company.addRatio(returnOnCapitalEmployedRatio);
            System.out.println("Please insert profit before interest and taxes or Ebit");
            double ebit = scanner.nextDouble();
            System.out.println("Please insert Total Assets");
            double totalAssets = scanner.nextDouble();
            System.out.println("Please insert Current Liabilities");
            double currentLiabilites = scanner.nextDouble();
            double employedCapital = totalAssets - currentLiabilites;
            returnOnCapitalEmployedRatio.percentageRatioCalculation(ebit, employedCapital);
        } else if (choice.equalsIgnoreCase("NET")) {
            Ratio netProfitMargin = new NetProfitMargin();
            netProfitMargin.printInfo();
            company.addRatio(netProfitMargin);
            System.out.println("Please insert net income or net Profit");
            double netIncome = scanner.nextDouble();
            System.out.println("Please insert Gross Revenue");
            double grossRevenue = scanner.nextDouble();
            System.out.println("Please insert Cost of sales or Cost of Goods Sold");
            double cogs = scanner.nextDouble();
            double revenue = grossRevenue + cogs;
            netProfitMargin.percentageRatioCalculation(netIncome, revenue);

        }


        nextStep(company, year);


    }


    public static void thirdChoiceSelected(Company company, int year) {

        System.out.println("*I)Inventory TurnOver");
        System.out.println(" ----------------");
        System.out.println("*A)Asset TurnOver");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("I")) {
            Ratio inventoryTurnOver = new InventoryTurnOver();
            inventoryTurnOver.printInfo();
            company.addRatio(inventoryTurnOver);
            System.out.println("Please insert Cost of Goods Sold or Cost of sales");
            double cogs = scanner.nextDouble();
            System.out.println("Please insert inventory of currentYear");
            double inventoryCurrent = scanner.nextDouble();
            System.out.println("Please insert inventory of previous year");
            double inventoryPrevious = scanner.nextDouble();
            double averageInventory = (inventoryCurrent + inventoryPrevious) / 2;
            inventoryTurnOver.ratioCalculation(cogs, averageInventory);

        } else if (choice.equalsIgnoreCase("A")) {
            Ratio assetTurnOver = new AssetTurnOver();
            assetTurnOver.printInfo();
            company.addRatio(assetTurnOver);
            System.out.println("Please insert Gross revenue");
            double grossRevenue = scanner.nextDouble();
            System.out.println("Please insert Cost of Sales or Cost Of Goods Sold");
            double cogs = scanner.nextDouble();
            double revenue = grossRevenue + cogs;
            System.out.println("Please insert assets of current year");
            double assetsOfCurrentYear = scanner.nextDouble();
            System.out.println("Please insert assets of previous year");
            double assetsOfPreviousYear = scanner.nextDouble();
            double averageTotalAssets = (assetsOfCurrentYear + assetsOfPreviousYear) / 2;
            assetTurnOver.ratioCalculation(revenue, averageTotalAssets);
        }

        nextStep(company, year);


    }


    public static void fourthChoiceSelected(Company company, int year) {

        System.out.println("*D)Debt Ratio");
        System.out.println("*D/E)Debt to Equity");
        System.out.println("*I)Interest Coverage");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("D")) {
            Ratio debtRatio = new Debt();
            debtRatio.printInfo();
            company.addRatio(debtRatio);

            System.out.println("Please insert total Liabilities");

            double totalLiabilites = scanner.nextDouble();


            System.out.println("Please insert total Assets");

            double totalAssets = scanner.nextDouble();

            debtRatio.ratioCalculation(totalLiabilites, totalAssets);


        } else if (choice.equalsIgnoreCase("D/E")) {
            Ratio debtToEquity = new DetbtToEquity();
            debtToEquity.printInfo();
            company.addRatio(debtToEquity);

            System.out.println("Please insert total Debt or total Liabilities");

            double totalDebt = scanner.nextDouble();

            System.out.println("Please insert total Stakeholders Equity");

            double totalEquity = scanner.nextDouble();

            debtToEquity.ratioCalculation(totalDebt, totalEquity);

        } else if (choice.equalsIgnoreCase(("I"))) {
            Ratio interestCoverage = new InterestCoverage();
            interestCoverage.printInfo();
            company.addRatio(interestCoverage);

            System.out.println("Please insert Earnings or profit before interest and taxes");

            double ebit = scanner.nextDouble();

            System.out.println("Please insert interest Expense");

            double interestExpense = scanner.nextDouble();

            interestCoverage.ratioCalculation(ebit, interestExpense);
        }
        nextStep(company, year);


    }

    public static void fifthChoiceSelected(Company company, int year) {
        System.out.println("*P/E)Price To Earnings");
        System.out.println("*P/B)Price to Book Value");
        System.out.println("*P/S) Price to Sales");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("P/E")) {
            Ratio priceToEarnings = new PriceToEarnings();
            priceToEarnings.printInfo();
            company.addRatio(priceToEarnings);

            System.out.println("Please insert Price Per Share or stocks price");

            double stockPrice = scanner.nextDouble();

            System.out.println("Please insert Earnings Per Share");

            double eps = scanner.nextDouble();

            priceToEarnings.ratioCalculation(stockPrice, eps);
        } else if (choice.equalsIgnoreCase("P/B")) {

            Ratio priceToBookValue = new PriceToBookValue();
            priceToBookValue.printInfo();
            company.addRatio(priceToBookValue);

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


            priceToBookValue.ratioCalculation(stocksPrice, bookValuePerShare);


        } else if (choice.equalsIgnoreCase("P/S")) {

            Ratio priceToSales = new PriceToSales();

            priceToSales.printInfo();

            company.addRatio(priceToSales);

            System.out.println("Please insert Net Sales");

            double netSales = scanner.nextDouble();

            System.out.println("Please insert Market Capitalization");

            double marketCap = scanner.nextDouble();

            priceToSales.ratioCalculation(netSales, marketCap);


        }
        nextStep(company, year);
    }

    public static void sixChoiceSelected() {
        scanner.close();
    }


    public static List<Company> companyList = new ArrayList<>();


    static Scanner scanner = new Scanner(System.in);


}
