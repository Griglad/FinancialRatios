package comparator;

import company.Company;

import java.util.Comparator;

public class CompanyComparator implements Comparator<Company> {
    @Override
    public int compare(Company company1, Company company2) {
        if(company1.getRatioByResult()<company2.getRatioByResult())
        {

            return -1;
        }
        else if(company1.getRatioByResult()>company2.getRatioByResult())
        {

            return 1;
        }
        else {
            return 0;
        }


    }
}
