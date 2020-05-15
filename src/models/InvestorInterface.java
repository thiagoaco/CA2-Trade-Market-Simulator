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
public interface InvestorInterface {
    
 
    public int getId();
    public void setId(int id);
     public Double getBudget();
     public void setBudget(Double budget);
     public int getShares();
    public void setShares(int shares);
    
}
