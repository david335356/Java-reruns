
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//always use import java.sql.***************

public class WorkerOptions {
    
    private Connection connection=null;
    private Statement statement=null;
    private PreparedStatement preparedstatement=null;
    
    //create database connection
    
    
    public WorkerOptions(){ //try and catch logger block
        try {
            connection= DriverManager.getConnection(Database.DATABASE_URL, Database.USERNAME, Database.PASSWORD);
            System.out.println("Connection is successful");
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    //Login method
    public boolean login (String username, String password){
        try {
            String query="select * from ADMIN where USERNAME=? AND "
                    + "PASSWORD=? ";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, username);
            preparedstatement.setString(2, password);
            
            //select query returns a result set
            ResultSet rs= preparedstatement.executeQuery();
            return rs.next();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    //doisplay all workers records
    public ArrayList <Worker> viewWorkers(){ 
        try {
        //important Returning arraylist including "Worker object"
        
        
        ArrayList <Worker> worker = new ArrayList <Worker>();
        String query= "select * from WORKER";
        statement= connection.createStatement();
        ResultSet rs=statement.executeQuery(query);
        
        while(rs.next()){
            int id = rs.getInt("WORKERID");
            String firstname=rs.getString("FIRSTNAME");
            String lastname=rs.getString("LASTNAME");
            String department=rs.getString("DEPARTMENT");
            double salary= rs.getDouble("SALARY");
            worker.add(new Worker(id, firstname, lastname, department, salary));
            
        }
        return worker;
        
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
    }
    public void addWorker(String firstname, String lastname, String department, double salary){
        try {
            String query="insert into WORKER (FIRSTNAME, LASTNAME, DEPARTMENT, SALARY) values (?, ?, ?, ?)";
            preparedstatement= connection.prepareStatement(query);
            preparedstatement.setString(1, firstname);
            preparedstatement.setString(2, lastname);
            preparedstatement.setString(3, department);
            preparedstatement.setDouble(4, salary);
            preparedstatement.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteWorker(int id){
        try {
            String query= "delete from WORKER where WORKERID=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setInt(1, id);
            preparedstatement.executeUpdate();
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void updateWorker(int id, String firstName, String lastName, String department, double salary){
        try {
            String query= "update WORKER set FIRSTNAME=? , LASTNAME=?, DEPARTMENT=?, SALARY=? where WORKERID=?";
            preparedstatement = connection.prepareStatement(query);
            preparedstatement.setString(1, firstName);
            preparedstatement.setString(2, lastName);
            preparedstatement.setString(3, department);
            preparedstatement.setDouble(4, salary);
            preparedstatement.setInt(5, id);
            preparedstatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(WorkerOptions.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
