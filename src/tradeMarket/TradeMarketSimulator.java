/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tradeMarket;
import controller.CompanyControl;
import controller.InvestorControl;
import controller.TransactionControl;
import factory.ElementsFactory;
import static java.time.Clock.system;
import models.Company;
import models.CompanyInterface;
import models.Investor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import models.Transactions;
import models.BudgetCompare;
/**
 *
 * @author thiag
 */
public class TradeMarketSimulator {
    public static void main(String[] args) {
        // TODO code application logic here
        boolean hasShare = true;
        boolean hasBudget = true;
        boolean trading = true;
        boolean hasBudgetEnough = true;
        
        //create 100 company
        
        ElementsFactory ef;
        ef = new ElementsFactory();
		
		CompanyControl company;
        ArrayList<Company> companies;
		company =  ef.getCompany();
        companies = ef.getCompanies(100);
        
        InvestorControl investor;
        ArrayList<Investor> investors;
        investor = ef.getInvestor();
        investors = ef.getInvestors(100);
        BudgetCompare comp;
        comp=new BudgetCompare();
        //sort Investors
        Collections.sort(investors,comp);
        investor.printInvestor(investors);
        
        //array com elementos temporários
        ArrayList<Investor> investors_temp;
        ArrayList<Company> companies_temp;
 
        ArrayList<Transactions> ts;
        ts = new ArrayList();
        int counterTransaction=1;
        Random r = new Random();
        
        boolean todos=false;
        boolean todas=false;
        
        System.out.println("----------start--------------------------------------------");
        do{
            
         
            TransactionControl controlt;
            controlt = new TransactionControl();
            
            
//             can we draw one that has already gone?
//             eliminate those who have no more money
            int idInvestor=r.nextInt(100);
            
             // cannot draw if you have already sold everything
            int idCompany=r.nextInt(100);
            
            // Draw an Investor and Company
            Investor inv_ = investors.get(idInvestor);
            
            // Draw a Company
            Company comp_ = companies.get(idCompany);
            
            //System.out.print("Investor ");
            //investor.print(inv_);
            // eliminate who doesn't have enough money anymore
            int[] draw= new int[100];
            int[] drawCompany= new int[100];
            
            int contCompany=0;
            todos=false;
            while((inv_.getBudget()<companies.get(idCompany).getValOfShares())&&(!todos)){
                draw[idInvestor]=1;// let's put 1's in positions already drawn
                idInvestor=r.nextInt(100);//new draw 
                inv_ = investors.get(idInvestor);
                
                draw[idInvestor]=1; 
                int cont=0;
                for (int i=0;i<100;i++) {
                    if(draw[i]==1){
                        cont++;
                    }
                }
                if(cont==100){
                    todos=true;
                }
            }

            if(todos){
                //System.out.println("Nova company");
                //draw a new company
                drawCompany[idCompany]=1;//let's put 1's in positions already drawn
                idCompany=r.nextInt(100);
                comp_ = companies.get(idCompany);
                todas=false;
                while((comp_.getValOfShares()>inv_.getBudget()) && (comp_.getShares()>0) &&(!todas)){
                    drawCompany[idCompany]=1;//let's put 1's in positions already drawn
                    idCompany=r.nextInt(100);
                    comp_ = companies.get(idCompany);
                    // check if all were drawn
                    contCompany=0;
                    for (int i=0;i<100;i++) {
                        if(drawCompany[i]==1){
                            contCompany++;
                        }
                    }
                    if(contCompany==100){
                        todas=true;
                    }
                }               
            }
            
            if(comp_.getShares()>0){
                
               controlt.setTransaction(new Transactions(counterTransaction, inv_.getId(), comp_.getId(), comp_.getValOfShares()));

               

                //add sell in totalSell
                companies.get(idCompany).setTotalSells(companies.get(idCompany).getTotalSells()+1);

                //update profit
                companies.get(idCompany).setProfits(companies.get(idCompany).getProfits()+companies.get(idCompany).getValOfShares());

                //decrement shares
                companies.get(idCompany).setShares(companies.get(idCompany).getShares()-1);

                //add share in totalShare
                investors.get(idInvestor).setTotalShare(investors.get(idInvestor).getTotalShare()+1);

                //update budget
                investors.get(idInvestor).setBudget(investors.get(idInvestor).getBudget()-companies.get(idCompany).getValOfShares());

                //ts.add(controlt.getTransaction());
                ts.add(controlt.getTransactions());
                counterTransaction++;

                //if a company sells 10 shares, the share price should double up.
                //update share price all Company x2
                int contadorAtual = companies.get(idCompany).getTotalSells();
                if(contadorAtual % 10 == 0){
                    companies.get(idCompany).setValOfShares(companies.get(idCompany).getValOfShares()*2);
                }

                //If any 10 shares are sold (from any company), and a company hasn’t sold any, the price must reduce in 2%.
                //update share price all Company -2%
                //a cada 10 vendas vamos fazer o teste
                if((counterTransaction>10) && (counterTransaction % 10 == 0 )){
                    //verify last 10 transacion
                    //who doesnot in there, reduce 2%
                    //get the last 10 id, who is not on the list reduces 2 %
                    //last 10 transactions
                    ArrayList ids = controlt.last10Company(ts);

                    //System.out.println("KKKKKKKKKKKKKKKKKK"+companies.get(0).getPrice());
                    companies=company.decreaseShareValue(ids, companies);
                    //System.out.println("KKKKKKKKKKKKKKKKKK"+companies.get(0).getPrice()); 
                }

                //check share count all Company
                //if number of share all Company==0 stop
                hasShare = company.verifyShare(companies);

                //check budget all investor
                //if budget all Investor==0 stop
                hasBudget = investor.verifyBudget(investors,companies);

                //The simulator should stop when all shares have been sold, or all investors have spent all their money.
                //investor.printTotalBudget(investors);

                //System.out.println("Share");
                //company.printShare(companies);

                if(contCompany==100){
                    //System.out.println("Passou todas Company==============================================");
                    hasBudgetEnough=false;
                    //System.out.println("SAIU");
                    break;// sai do while 
                }

                if((hasBudget==false) || (hasShare==false) || (hasBudgetEnough==false) || ((todos)&&(todas)) ){
                    trading = false;
                }
            }

            
            
            
            
        }while(trading);
        
        System.out.println("--------------------------------------------------");
        System.out.println("Transactions ...."+counterTransaction);
        
        System.out.println("--------------------------------------------------");
        System.out.println("Investors");
        investor.printInvestor(investors);
        
        System.out.println("--------------------------------------------------");
        System.out.println("Companies");
        company.printCompany(companies);
        
        
        //menu
        Scanner scanner;
        scanner =new Scanner(System.in);
        int op;
        do{
            System.out.println("Choose an option");
            System.out.println("1 - Company(ies) with the highest capital");
            System.out.println("2 - Company(ies) with the lowest capital");
            System.out.println("3 - Investor(s) with the highest number of shares");
            System.out.println("4 - Investor(s) with the lowest number of shares");
            System.out.println("0 - Exit");

            op = scanner.nextInt();

            switch(op){
                case 0:			
                    System.out.println("Bye!");
                    break;
                case 1:
                    company.printCompany(companies,1);
                    break;

                case 2:
                    company.printCompany(companies,2);
                    break;
                case 3:

                    investor.printInvestor(investors,1);
                    break;
                case 4:
                    investor.printInvestor(investors,2);
                    break;

                default:
                    System.out.println("Opcao invalida !!!");

            }
	}while(op != 0);
	System.out.println("End of Simulation.");
    }
}
