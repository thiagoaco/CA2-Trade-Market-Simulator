/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author thiag
 */
public class Investor {
    
      private int id;
    private Double budget;
    private int shares;
    
   

   
    
      public Investor(int idinit ,Double budgetinit, int shares   ) {
        this.id=idinit;
       this.budget=budgetinit;
       //this.shares=shares;
     
        
    }
       public Investor( ) {
    
     
        
    }
     public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBudget() {
        
        return budget;
    }
    public String getBudgetFormater(){
        DecimalFormat df= new DecimalFormat("#0.00");
        return df.format(budget);
        
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
    
    public int getTotalShare() {
        return shares;
    }

    public void setTotalShare(int totalShare) {
        this.shares = totalShare;
    }
  
  
    
}
