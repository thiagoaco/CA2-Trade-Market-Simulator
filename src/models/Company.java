/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Interfaces.CompanyInterface;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author thiag
 */
public class  Company implements CompanyInterface{
       private int id;
    private int shares; 
    private Double valOfShares;
     private int totalSells; //total de vendas
     
     private Double profits; 
    

    public Company(int idinit ,int sharesinit,  Double valOfSharesinit   ) {
        this.id=idinit;
       this.shares=sharesinit;
        this.valOfShares= valOfSharesinit;
        this.profits=0.0;
        
        
    }
      
        public Company(){
            
        }

   

    public Double getValOfShares() {
        return valOfShares;
    }
    public void setValOfShares(Double valOfShares) {
        this.valOfShares = valOfShares;
    }
    public String getValOfSharesFormatted(){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(valOfShares);
    }
    public String getProfitsFormatted(){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(profits);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }   

    public int getTotalSells() {
        return totalSells;
    }

    public void setTotalSells(int totalSells) {
        this.totalSells = totalSells;
    }

    public Double getProfits() {
        return profits;
    }

    public void setProfits(Double profits) {
        this.profits = profits;
    }
    
    
    
    /**
     *
     * @return
     */
    @Override
    public String toString() {
        
		return "id: " +id+ ", Shares: " + shares+"  Value of shares :"+valOfShares +" profits :"+profits;
	}
    
   
    
}
