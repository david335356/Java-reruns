
public class VehicleTest {
      public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(20), new Bicycle()};

        for(int i = 1; i < vehicles.length; i++) { //creating for loop to print message 
            vehicles[i].GetCarbonFootPrint(); 
             System.out.printf("Bicycle: %.2f%n", vehicles[1].GetCarbonFootPrint()); //to format with 2 decimals used printf and %.2f
             System.out.printf("Car that has used 20 gallons of gas: %.2f%n", vehicles[0].GetCarbonFootPrint());
            
        }
       
          
    }  
}
