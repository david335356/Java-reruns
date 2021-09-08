
import java.util.logging.Level;
import java.util.logging.Logger;

//This program performs by calculating monthly interest rates 
public class AccountSavings {

    private double annualIntRate = 5.3; //base annual interest
    private double currentSavingBalance = 10; //current saving balance
    double formula = 0; //intializing formula 
    public void calculateMonthlyIntRate(){
        formula += currentSavingBalance * Math.pow((1 + annualIntRate/12), (12*1)); //calculating monthly interest
        
    }
    public double getFormula (){ //returns formula to use values
        return formula;
    }
    
    public static class threads extends Thread{ //first thread
        AccountSavings accountsavings;
        public threads (){
             accountsavings = new AccountSavings(); 
        }
         public double savings(){
            return accountsavings.getFormula();
        }
       
      
        public void run(){
            try {
                for (int i = 0; i<4800 ; i++){ //calculation running 4800 times
                    accountsavings.calculateMonthlyIntRate();
                }
                Thread.sleep(5000); //current thread sleeps for 5 seconds
            } catch (InterruptedException ex) {
                Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       
    public static class threads2 extends Thread{ //second thread
        AccountSavings accountsavings2;
        public threads2 (){
             accountsavings2 = new AccountSavings(); 
        }
         public double savings(){
            return accountsavings2.getFormula(); 
        }
        @Override
        public void run(){
            for (int i = 0; i<1200 ; i++){ //calculation running 1200 times 
                accountsavings2.calculateMonthlyIntRate(); //t2 should be a lower number due to lesser number 
            }
        }
    }
    public static void main(String[] args) {
        threads t1= new threads(); //creating thread objects
        threads2 t2= new threads2();
        t1.start(); //starting thread
        t2.start();
        try {
            //Thread.sleep(7000);
            t1.join(); //joining the threads
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(AccountSavings.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Saving Balance: "+t1.savings()); //prints savings
        System.out.println("Saving Balance: "+t2.savings()); 
    }
}
