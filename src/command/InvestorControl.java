/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import java.util.ArrayList;
import java.util.Random;
import models.Company;
import models.Investor;

/**
 *
 * @author thiag
 */
public class InvestorControl {
    
    Investor investor;
    
    public InvestorControl(){
    investor = new Investor();
        
        
    }
    
      public ArrayList<Investor> createInvestor (int length){
        ArrayList<Investor> investors;
        investors = new ArrayList();
        Investor investor;
        int id;
        Double budget;
        int shares;
        Random random;
        random = new Random();
        
        for (int i = 0; i < length; i++) {
            id = i+1;
            budget = random.nextDouble()*9000.0f+1000.0f;//1000 ate 10 000
            shares=0;
            investor = new Investor(id,budget, shares);
            investors.add(investor);
        }
        
        return investors;
    }
    
    public void printInvestor(ArrayList<Investor> invertors){
        System.out.println("# investors");

        System.out.println("# id \t Budget \t Total Sahre");
        for (Investor investor : invertors) {
            System.out.print(investor.getId() +" \t "+ investor.getBudgetFormater()+" \t"+investor.getTotalShare());
            System.out.println("");      
        }
    }
    
    public void print(Investor i){
        String r="";
        System.out.print("id "+i.getId());
        System.out.print("Budget "+i.getBudgetFormater());
        System.out.print("Total Share "+i.getShares());
        System.out.println("");
        
    }
    
    public boolean verifyBudget(ArrayList<Investor> invertors,ArrayList<Company> companies){
       boolean hasBudget=false;
       for (Company company : companies) {
            for (Investor investor : invertors) {
                //colocar 10 no teste do if
                if((investor.getBudget()>company.getValOfShares())&&(investor.getBudget()>0))
                     return true;
            }
       }
       return hasBudget;
   }
    
    public void printInvestor(ArrayList<Investor> invertors, int op){
        //if op = 1, then higher Total Share
        //if op = 2, then lower Total Share
        
        //get higer Total Share
        int higher = Integer.MIN_VALUE;
        for (Investor invertor : invertors) {
            if(invertor.getShares()>higher){
                higher=invertor.getShares();
            }
        }
        
        //get lower Total Share
        int lower = Integer.MAX_VALUE;
        for (Investor invertor : invertors) {
            if(invertor.getShares()<lower){
                lower=invertor.getShares();
            }
        }
        
        if(op==1){
            for (Investor invertor : invertors) {
                if(invertor.getShares()==higher){
                    System.out.println("Print higher Total Share");
                    System.out.println("# id \t Budget \t Total Sahre");
                    System.out.print(invertor.getId() +" \t "+ invertor.getBudgetFormater()+" \t"+invertor.getShares());
                    System.out.println("");      
                }
            }
        }
        
        if(op==2){
            for (Investor invertor : invertors) {
                if(invertor.getShares()==lower){
                    System.out.println("Print lower Total Share");
                    System.out.println("# id \t Budget \t Total Sahre");
                    System.out.print(invertor.getId() +" \t "+ invertor.getBudgetFormater() +" \t"+invertor.getShares());
                    System.out.println("");     
                }
            }
        }
    }
    
}
