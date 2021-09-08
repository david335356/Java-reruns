
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddressOptions {
    private Connection connection=null;
    private Statement statement=null;
    private PreparedStatement preparedstatement=null;
    //creating database connection as seen above
    public AddressOptions(){
        try{
            connection= DriverManager.getConnection(
                    Database.DATABASE_URL, Database.USERNAME, Database.PASSWORD);
                System.out.println("Connection is sucessful");
        }catch(SQLException ex){
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
    //login method?
    public boolean login(String username, String password){
        try{
            String query= "select * from ADMIN where USERNAME=? AND PASSWORD=?";
            preparedstatement= connection.prepareStatement(query); 
            preparedstatement.setString(1, username); 
            preparedstatement.setString(2, password); 
            
            //slecint gquery returns a result
            ResultSet rs= preparedstatement.executeQuery();
            return rs.next();
            //method returns true if record exisits
        }catch(SQLException ex){
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }
    //displaying all address records
    public ArrayList<Address> viewAddress(){
        try{
            ArrayList<Address> address= new ArrayList <Address>();
            String query="select * from ADDRESSES";
            statement= connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            
            while(rs.next()){
                int id= rs.getInt("ADDRESSID");
                String firstname=rs.getString("FIRSTNAME");
                String lastname=rs.getString("LASTNAME");
                String email=rs.getString("EMAIL");
                String phoneNum=rs.getString("PHONENUMBER");
                address.add(new Address(id, firstname, lastname, email, phoneNum));//remember to .add to implement these data into the table.
         
            }
            return address;
        }catch(SQLException ex){
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null,ex);
            return null;
        }
    }
    
    //creating add address
    public void addAddress(
            String firstname, String lastname, String email, String phoneNum){
        try {
            String query="insert into ADDRESSES (FIRSTNAME, LASTNAME,"
                    + " EMAIL, PHONENUMBER) values(?, ?, ?, ?)";
            preparedstatement=connection.prepareStatement(query);
            preparedstatement.setString(1, firstname);
            preparedstatement.setString(2, lastname);
            preparedstatement.setString(3, email);
            preparedstatement.setString(4, phoneNum);
            
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    //creating delete
    public void deleteAddress(int id){
        try {
            String query="delete from ADDRESSES where ADDRESSID=?";
            preparedstatement=connection.prepareStatement(query);
            preparedstatement.setInt(1,id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    public void deleteAllAddress(){ //revmove the "int id" because we are delelting everything
        try { 
            String query="delete from ADDRESSES"; //delete from ADDRESS deletes all of the data in the sql table
             preparedstatement=connection.prepareStatement(query);
            // preparedstatement.setInt(1,id); //we dont need this statement if we are deleting everything once again 
             preparedstatement.executeUpdate();
             
        } catch (SQLException ex) {
            Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
  
    
    //creating update address
    public void updateAddress(int id, String firstName, String lastName, String email, String phoneNum){
        try {
            String query="update ADDRESSES set FIRSTNAME=?, LASTNAME=?,"
                    + " EMAIL=?, PHONENUMBER=? where ADDRESSID=?";
            preparedstatement=connection.prepareStatement(query);
            preparedstatement.setString(1, firstName);
            preparedstatement.setString(2, lastName);
            preparedstatement.setString(3, email);
            preparedstatement.setString(4, phoneNum);
            preparedstatement.setInt(5, id);
            preparedstatement.executeUpdate();
        } catch (SQLException ex) {
             Logger.getLogger(AddressOptions.class.getName()).log(Level.SEVERE, null,ex);
            
        }
  
                
    }
}
