/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author thiag
 */
public class Transactions {
    
    public int tradingID;
    public int conpanyID;
    public int investorID;
    public Double valOfShares;
   
    
      public Transactions(int tradingIDinit,int conpanyIDinit,int investorIDinit,Double valOfShares ){
        this.tradingID=tradingIDinit;
        this.conpanyID= conpanyIDinit;
        this.investorID= investorIDinit;
        this.valOfShares = valOfShares;
        
    }
    
    
    
     public Transactions(){
        
    }
    

    public int getTradingID() {
        return tradingID;
    }
   

    public void setTradingID(int tradingID) {
        this.tradingID = tradingID;
    }

    public int getConpanyID() {
        return conpanyID;
    }

    public void setConpanyID(int conpanyID) {
        this.conpanyID = conpanyID;
    }

    public int getInvestorID() {
        return investorID;
    }

    public void setInvestorID(int investorID) {
        this.investorID = investorID;
    }

    public Double getValOfShares() {
        return valOfShares;
    }

    public void setValOfShares(Double valOfShares) {
        this.valOfShares = valOfShares;
    }
   
    
    
    
    
    
}
