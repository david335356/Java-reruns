
import java.util.logging.Level;
import java.util.logging.Logger;


public class Person implements Runnable{ //creating persons to implement runnable
    private String fName;
    private String lName; //intializing basic fName/lName
    
    public Person(String fName, String lName){
        this.fName = fName; //Constrcutors
        this.lName = lName;
        
    }
    @Override 
    public void run(){
        System.out.println(fName + " " + lName + " started to work"); //getting person first/last name displaying starting 
        try {
            Thread.sleep(5000); //making thread sleep 5 seconds
        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(fName + " " + lName + " finished"); //geting person first / last name displaying the finished message  
        
    }
}
