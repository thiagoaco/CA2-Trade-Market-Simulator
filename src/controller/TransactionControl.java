/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import models.Transactions;

/**
 *
 * @author thiag
 */
public class TransactionControl {
    
  
   
    Transactions transactions;
    
    //create Investor
    public TransactionControl(){
        transactions = new Transactions();
    }
    
    public Transactions getTransactions(){
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
    public void setTransaction(Transactions t){
        this.transactions=t;
    }
    
   
   
    
    
    public ArrayList last10Company (ArrayList<Transactions> transactions){
        ArrayList last10;
        last10 = new ArrayList();
         
        for( int i =0; i <10;i++ ){
        last10.add(transactions.get(transactions.size()-(i+1)).getConpanyID()); 
        }
        
        return last10;
    }
}
