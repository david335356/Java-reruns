
import javax.swing.JFrame;

public class ConvertTest {
    public static void main(String[] args) {
        ConvertFrame myframe= new ConvertFrame(); 
       myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //the application will be terminated, when close button is clicked 
      
       myframe.setSize(350, 180); //creating the size of the frame 
       myframe.setVisible(true); 
    }
}
