/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import connexion.Connexion;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author chaou
 */
public class AuthService {
 
    public void auth(String username, String pswrd){
       try {
            String req = "select * from client where username = " + username;
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
        
          ResultSet rs = ps.executeQuery(req);
          
           if (rs.next()) {
              
System.out.println(rs.getBoolean("isadmin"));
            }
           

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
