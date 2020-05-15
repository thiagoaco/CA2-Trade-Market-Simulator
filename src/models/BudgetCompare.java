/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Comparator;

/**
 *
 * @author thiag
 */
public class BudgetCompare implements Comparator <Investor>{
    
    @Override
   public int compare( Investor v1, Investor v2) {  
         if(v1 == null || v2 == null)  
             System.out.println("compare budget");  
           
         Double  budget1 = v1.getBudget();
         Double  budget2 = v2.getBudget(); 

         return  budget1.compareTo( budget2); 

}
    
    
    
    
    
   
    
}
