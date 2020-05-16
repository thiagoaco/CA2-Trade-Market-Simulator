/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;
import command.CompanyControl;
import command.InvestorControl;
import java.util.ArrayList;
import models.Company;
import models.Investor;
/**
 *
 * @author thiag
 */
public class ElementsFactory {
    Company com;
    Investor inv;
    
    public ArrayList<Company> getCompanies(int len){ 
        CompanyControl companyControl;
        companyControl = new CompanyControl();
        return companyControl.createCompany(len);
    }
    
    public ArrayList<Investor> getInvestors(int len){ 
        InvestorControl investorControl;
        investorControl = new InvestorControl();
        return investorControl.createInvestor(len);
    }
    
    public CompanyControl getCompany(){
        this.com = new Company();
        return new CompanyControl();
    }
    
    public InvestorControl getInvestor(){
        this.inv = new Investor();
        return new InvestorControl();    
    }
 
    
}
