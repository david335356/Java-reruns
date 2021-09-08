
public class Car extends Vehicle { //creating car class that extends from vehicle
    public double gallon;
    public Car(double gallon){
        this.gallon=gallon;
        
    }
    @Override
    public double GetCarbonFootPrint(){ //calculating the car carboon footprint 
        return gallon*20;
    }
}
    
