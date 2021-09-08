import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

//creatomg a PizzaSelection class 

public class PizzaSelectionFrame extends JFrame implements ItemListener, ActionListener {

   JLabel iconLabel = null; //defining all the Labels, Radiobuttons, checkboxes
   JRadioButton smallSize = null;
   JRadioButton mediumSize = null;
   JRadioButton largeSize = null;
   JCheckBox mushroomCheckBox = null;
   JCheckBox baconCheckBox = null;
   JComboBox pizzaList = null;
   ImageIcon chickenPic, pepperoniPic, veggiePic; 
  
   //creating selection frame, size, title, close operation, color background
   public PizzaSelectionFrame() {
       setSize(325, 300);
       setTitle("Order Pizza");
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new FlowLayout());
       setBackground(Color.LIGHT_GRAY);
      
       addComponents();
      
   }
  
   
   private void addComponents() { //defining the components 
       
       
       //Define combobox
       pizzaList = new JComboBox(new String[]{"chicken pizza","pepperoni pizza","veggie pizza"});
       add(pizzaList);
       
       //Show default icon as as the chicken pizza
       chickenPic = new ImageIcon("chicken.PNG");
       Image imageChicken = chickenPic.getImage();
       Image newImageChick = imageChicken.getScaledInstance(100, 100,
               java.awt.Image.SCALE_SMOOTH);
       chickenPic = new ImageIcon(newImageChick);
       
       //image icon for pepperoni 
       pepperoniPic = new ImageIcon("pepperoni.PNG");
        Image imagePepperoni = pepperoniPic.getImage();
        Image newImagePepper = imagePepperoni.getScaledInstance(100, 100, 
                java.awt.Image.SCALE_SMOOTH);
        pepperoniPic = new ImageIcon(newImagePepper);
       
       //image icon for veggie
       veggiePic = new ImageIcon(getClass().getResource("veggie.PNG"));
        Image imageVeggie = veggiePic.getImage();
        Image newImageVeggie = imageVeggie.getScaledInstance(100, 100, 
                java.awt.Image.SCALE_SMOOTH);
        veggiePic = new ImageIcon(newImageVeggie);    
       
       //Setting Item listener
       pizzaList.addItemListener(this);
       
       iconLabel = new JLabel(chickenPic);
       add(iconLabel);
       
       //Set Item listener
       pizzaList.addItemListener(this);

       
       //defining the Pizza Size
       add(new JLabel("Select Size:"));
       ButtonGroup sizeBtn = new ButtonGroup();
       smallSize = new JRadioButton("Small");
       smallSize.setSelected(true);
       sizeBtn.add(smallSize);
       add(smallSize);
       mediumSize = new JRadioButton("Medium");
       sizeBtn.add(mediumSize);
       add(mediumSize);
       largeSize= new JRadioButton("Large");
       sizeBtn.add(largeSize);
       add(largeSize);
       
       
       
       //Define Toppings for pizza
       add(new JLabel("Select Topping(s):"));
       mushroomCheckBox = new JCheckBox("Mushroom");
       add(mushroomCheckBox);
       baconCheckBox = new JCheckBox("Bacon");
       add(baconCheckBox);
       
       
       
       //creating a submit button
       JButton submitButton = new JButton("Submit Order");
       submitButton.addActionListener(this);
       add(submitButton);
   }

   
   @Override
    public void itemStateChanged(ItemEvent ie) {
       // check whether the first item is selected
       // changing the icon to in selection
        if (pizzaList.getSelectedIndex() == 0) {

        iconLabel.setIcon(chickenPic);
        iconLabel.repaint();
        }

        // checking for pepperoni 
        else if(pizzaList.getSelectedIndex() == 1) {

        iconLabel.setIcon(pepperoniPic);
        iconLabel.repaint();
        }

        //checking for veggie 
        else if(pizzaList.getSelectedIndex() == 2) {

        iconLabel.setIcon(veggiePic);
        iconLabel.repaint();
        }
   }

   
   //creating actionperformed 
   @Override
   public void actionPerformed(ActionEvent arg0) {
       String message = "Order Summary:"; //creating order summary  size with if-else 
       if(smallSize.isSelected()){
           message+="Small ";
       }else if(mediumSize.isSelected()){
           message+="Medium ";
       }else if(largeSize.isSelected()){
           message+="Pizza ";
       }
       
       
       message+=pizzaList.getSelectedItem();
       
       if(mushroomCheckBox.isSelected() && baconCheckBox.isSelected()){  //creating order summary topping with if-else 
           message += " with Mushroom and Bacon toppings";
       }else if(mushroomCheckBox.isSelected()){
           message += " with Mushroom topping";
       }else if(baconCheckBox.isSelected()){
           message += " with Bacon topping";
       }else{
           message += " without any topping";
       }
       
       int returnMsg = JOptionPane.showOptionDialog(PizzaSelectionFrame.this, message, 
               "Order Summary", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
       
       if(returnMsg == 0){
           PaymentFrame paymentFrame = new PaymentFrame();
           paymentFrame.setVisible(true);
       }
   }
  
   

}