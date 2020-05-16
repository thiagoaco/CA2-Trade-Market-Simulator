/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ArrayList;
import java.util.Random;
import models.Company;

/**
 *
 * @author thiag
 */
public class CompanyControl {
    Company comp;
    public CompanyControl(){
        comp = new Company();
    }
    public Company getCompany(){
    return  comp;
    }
     public ArrayList<Company> createCompany(int length){
        ArrayList<Company> companies;
        companies = new ArrayList();
        Company company;
        int id;
        int shares;
        Double valOfShares;
        
        Random random;
        random = new Random();
        
        for (int i = 0; i < length; i++) {
            id = i+1;
            shares = random.nextInt(501)+500; // 500 to 1000
            valOfShares = random.nextDouble()*90.0f+10.0f;//10 ate 100
            company = new Company(id,shares,valOfShares);
            companies.add(company);
        }
        
        return companies;
    }
    
//    public void printCompany(ArrayList<Company> companies){
//        System.out.println("# id \t Shares \t Share Price");
//        for (Company company : companies) {
//            System.out.print(company.getId() +" \t "+ company.getShares() +" \t \t"+ company.getValOfSharesFormated());
//            System.out.println("");      
//        }
//    }
    public void printCompany(ArrayList<Company> companies){
        System.out.println("Print All Companies");
        System.out.println("# id \t Shares\t Share value \t Profit");
        for (Company company : companies) {
            System.out.print(company.getId() +" \t "+ company.getShares() +" \t \t"+ company.getValOfSharesFormatted()+" \t"+company.getProfitsFormatted());
            System.out.println("");      
        }
    }
    public void printCompany(ArrayList<Company> companies, int op){
        //if op = 1, then higher Total Share
        //if op = 2, then lower Total Share
        
        //get higer Total Share
        double higher = Integer.MIN_VALUE;
        for (Company company : companies) {
            if(company.getProfits()>higher){
                higher=company.getProfits();
            }
        }
        
        //get lower Total Share
        double lower = Integer.MAX_VALUE;
        for (Company company : companies) {
            if(company.getProfits()<lower){
                lower=company.getProfits();
            }
        }
        
        if(op==1){
            for (Company company : companies) {
                if(company.getProfits()==higher){
                    System.out.println("Print Company with higher Total Share");
                    System.out.println("# id \t Shares \t Share Price \t Profit");
                    System.out.print(company.getId() +" \t "+ company.getShares()+" \t \t"+company.getValOfSharesFormatted()+" \t \t"+company.getProfitsFormatted());
                    System.out.println("");      
                }
            }
        }
        
        if(op==2){
            for (Company company : companies) {
                if(company.getProfits()==lower){
                    System.out.println("Print Company with lower Total Share");
                    System.out.println("# id \t Shares \t Share Price \t Profit");
                    System.out.print(company.getId() +" \t "+ company.getShares()+"\t \t"+company.getValOfSharesFormatted()+"\t \t"+company.getProfitsFormatted());
                    System.out.println("");     
                }
            }
        }
    }
    public boolean verifyShare(ArrayList<Company> companies){
       boolean hasShares=false;
       for (Company company : companies) {
           if(company.getShares()>0)
               return true;
       }
       return hasShares;
   }
    public ArrayList decreaseShareValue(ArrayList<Integer> ids,ArrayList<Company> companies){
        ArrayList<Company> compUpdate;
       
  //If any 10 shares are sold (from any company), and a company hasn’t sold any, the
//price must reduce in 2%.

        for (Company company: companies){
            int id=company.getId()-1;     
            if(!ids.contains(id)){
                //System.out.println("entrou");                    
                Double val = companies.get(id).getValOfShares();
                val =val*0.02;   
                //System.out.println(" porcentagem "+val); 
               // System.out.println("nao auterado"+companies.get(id).getValOfSharesFormated());  
                if((companies.get(id).getValOfShares())>val){
                    company.setValOfShares(company.getValOfShares()-val);
                }
                
                //System.out.println("tem que auterar"+companies.get(id).getValOfSharesFormated());
                //companies.get(id).setValOfShares(company.getValOfShares()-val);

            }
            
        }
        return companies;
    
    }
    
    
}
