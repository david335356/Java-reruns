
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class ConvertFrame extends JFrame {
    
    private final JLabel fahrenhietMsg; //intiliazing my JLabel, JTextField, JButton, 
    private final JLabel inchToCmMsg;
    private final JTextField fahrenheitTextBox;
    private final JTextField inchTextBox;
    private final JButton temperatureConvertButton;
    private final JButton lengthConvertButton;
    
    private final JLabel temperatureConvertMessage;
    private final JLabel lengthConvertMessage;
    
    
    
    
public ConvertFrame (){
    super("Converter");
    
    setLayout(new FlowLayout()); //creating the layout gui 
    
    fahrenhietMsg = new JLabel ("Enter Fahrenheit Temperature:"); //fahrenhiet message 
    add(fahrenhietMsg); //adding the message 
    
    fahrenheitTextBox= new JTextField(5); //creating the textbox and making it the size of 5 
    add(fahrenheitTextBox); //adding the textbox
    
    temperatureConvertButton= new JButton ("Convert"); //creating the convert button for temperature 
    add(temperatureConvertButton); //adoing the convert button 
    
    temperatureConvertMessage = new JLabel ("");// temperature convert message 
    add(temperatureConvertMessage); //addoing the convert button 
    
    
    inchToCmMsg = new JLabel ("Enter Inch length:"); //inch to cm message 
    add(inchToCmMsg); //adding the message 
    
    inchTextBox= new JTextField(5);
    add(inchTextBox); //creating the inch text field and adding the text box
    
    lengthConvertButton= new JButton ("Convert"); //inch to cm convert button 
    add(lengthConvertButton); //addoing button 
    
    lengthConvertMessage = new JLabel ("");// length convert message 
    add(lengthConvertMessage); //adding the message 
        
    ButtonHandler myhandler= new ButtonHandler(); //creating the button handler for convert buttons 
    temperatureConvertButton.addActionListener(myhandler); //adding temperature and length action listeners 
    lengthConvertButton.addActionListener(myhandler);
    
    
    TextFieldHandler textHandler= new TextFieldHandler(); //creating textfield handler 
    fahrenheitTextBox.addActionListener(textHandler);//adding temperature and length text handler 
    inchTextBox.addActionListener(textHandler);
    
    
    
   
    }//end of constructor
private class TextFieldHandler implements ActionListener{  //creating the ActionListener for the TextField
    @Override //field handler allows to press "Enter" to input conversion variables 
    public void actionPerformed(ActionEvent event){ //creating an If else statement for the TextField Handler
        if(fahrenheitTextBox.getText().trim().equals("") ){
            temperatureConvertMessage.setText("This cannot be empty");
        }
        else{
            int convertedTemp = (int)((Double.parseDouble(fahrenheitTextBox.getText())-32)*(5d/9d));//handles calculation for temp
            temperatureConvertMessage.setText("Temperature in Celsius: "+convertedTemp); 
        } //end if-else
        if( inchTextBox.getText().trim().equals("")){
            lengthConvertMessage.setText("This cannot be empty");
            
        }
        else{
            double convertLength = (double)((Double.parseDouble(inchTextBox.getText()))*(2.54d)); //handles calculation for length
            lengthConvertMessage.setText("Length Inch to Cm: " + convertLength);
        }//end if-else
    }
    
}
    
private class ButtonHandler implements ActionListener{ //CReating ButtonHandler for the convert button
    @Override
    public void actionPerformed (ActionEvent event){ 
            //allows users to click the convert button for conversion
        
        if(fahrenheitTextBox.getText().trim().equals("") ){ //this handles temperature 
            temperatureConvertMessage.setText("This cannot be empty");
           
        }
        else{
            int convertedTemp = (int)((Double.parseDouble(fahrenheitTextBox.getText())-32)*(5d/9d)); //handles calculation for temp
            temperatureConvertMessage.setText("Temperature in Celsius: "+convertedTemp);
            
            
        }
        if( inchTextBox.getText().trim().equals("")){ //this handles length
            lengthConvertMessage.setText("This cannot be empty");
            
        }
        else{
            double convertLength = (double)((Double.parseDouble(inchTextBox.getText()))*(2.54d)); //handles calculation for length
            lengthConvertMessage.setText("Length Inch to Cm: " + convertLength);
        }
        

    }
}


}//end of main 
