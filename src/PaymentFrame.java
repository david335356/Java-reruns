
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class PaymentFrame extends JFrame { //creating the textfields for information
   JTextField textName = new JTextField(20);
   JTextField textAdress = new JTextField(20);
   JTextField textCC = new JTextField(20);
   JTextField textCardExpire = new JTextField(20);
   JTextField textCardCvc = new JTextField(20);
   
   public PaymentFrame() { //creating the paymentframe title, frame size, color background
       setTitle("Payment");
       setSize(600,200);
       setBackground(Color.LIGHT_GRAY);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new GridLayout(6,2));
       addComponents();
   }

   private void addComponents() {
       
       //adding components label and names 
       add(new JLabel("Name and Surname:"));
       add(textName);
       add(new JLabel("Address:"));
       add(textAdress);
       add(new JLabel("Credit Card Number:"));
       add(textCC);
       add(new JLabel("Expiration Date:"));
       add(textCardExpire);
       add(new JLabel("CVC:"));
       add(textCardCvc);
       
       
       JButton payButton = new JButton("Pay"); //creating paybutton 
       payButton.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent arg0) {
               JOptionPane.showMessageDialog(PaymentFrame.this, "Your order will be delivered in 30 minutes");
               System.exit(0); //exiting the system
           }  
       });
       add(payButton);
   }
}
