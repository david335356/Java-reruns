
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonTest {
    /*
    public static void main(String[] args) {
        try{
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i = 0; i < 4; i++){
            executor.submit(new Person( String.valueOf(i+1) + " fName", "lName"));
            
        }
        executor.shutdown();
        System.out.println("All task are submitted");
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All task are done");
        }
        catch (InterruptedException ex) {
            Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3); //creating threadpool with size "3" 
        Thread t1= new Thread(new Person("David", "Mull"));     
        Thread t2= new Thread(new Person("James", "Norja")); //creating 4 different threads with 4 unique names 
        Thread t3= new Thread(new Person("Jennifer", "Lopez"));
        Thread t4= new Thread(new Person("Shakira", "Ripoll"));
        
        System.out.println("All tasked submitted"); //displaying all tasked submitted
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
                Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("");
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(PersonTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("All tasks are completed"); //printing out all task completed
        
    }
        
}
