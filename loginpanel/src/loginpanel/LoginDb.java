/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginpanel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author charyth
 */
public class LoginDb {
    
    String url ="jdbc:mysql://localhost:3306/employee";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs =null;
   boolean addUsers(userDatails ud){
        try{
        con = (Connection)DriverManager.getConnection(url, username, password);
        String query="INSERT INTO users VALUES(?,?,?,?,?,?,?,?)";
        
        pst= (PreparedStatement)con.prepareStatement(query);
        
        pst.setInt(1,ud.getId());
        pst.setString(2,ud.getFirstName());
        pst.setString(3,ud.getLastName());
        pst.setInt(4,ud.getAge());
        pst.setString(5,ud.getEmail());
        pst.setString(6,ud.getCountry());
        pst.setString(7,ud.getUsername());
        pst.setString(8,ud.getPassword());
        pst.executeUpdate();//execute the sql query and insert into the database
        return true;
        }catch(Exception e){ 
            System.out.println(e);
            return false;
        }finally{
            try{
             if(pst != null){
             pst.close();
        }
        if(con!= null){
            con.close();
        }
            }catch(Exception e){
            }
       
        }
        
    
    }
   int checkUser(String name){
       try{
        con = (Connection)DriverManager.getConnection(url, username, password);
         String query="SELECT username FROM users";
         pst=(PreparedStatement)con.prepareStatement(query);
         rs = pst.executeQuery();
         while(rs.next()){
             if(name.equals(rs.getString(1))){
                 return 0;//username provided already exists
             }
            
         }
          
       }catch(Exception e){
           System.out.println(e);
           return 2;
       }finally{
           try{
                if(pst != null){
       pst.close();
       }
       if(con != null){
       con.close();
       }
           }catch(Exception e){
           
           }
      
       }
      return 1;//username doesnot exits;  
   }
   int loginUser(String name,String key)
   {
       try{
           con = (Connection)DriverManager.getConnection(url,username,password);
           String query = "SELECT username,password FROM users";
          pst=(PreparedStatement)con.prepareStatement(query);
          rs = pst.executeQuery();
          while(rs.next()){
          if(name.equals(rs.getString(1)))
                if(key.equals(rs.getString(2))){
                    //sJOptionPane.showMessageDialog(this,rs.getString(name));
                        return 1;
              }
          }
          
       
       }catch(Exception e){
        return 2;
       }finally{
           try{
                if(pst != null){
       pst.close();
       }
       if(con != null){
       con.close();
       }
           }catch(Exception e){
           
           }
      
       }
       return 0;
   }
    
}
