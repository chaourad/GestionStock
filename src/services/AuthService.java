/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import connexion.Connexion;
import entities.Client;
import entities.Produit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chaou
 */
public class AuthService {
 
/*
       
     public boolean findByAdmin(String username,String password) {
       	 try{
             	String sql = "select username , password from client where username=?, password=? , isadmin=1 '" ;
            PreparedStatement ps = Connexion.getConnection().prepareStatement(sql);
            ps.setString(2,username );
             ps.setString(3,password );
           
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next()) {
              
            System.out.println(rs.getString("password"));
            return true;
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         return false;
     }*/
     
     public boolean findAdmin(String name,String password){
          try{
              //String req = "select username , password from client where username=? and password=? and isadmin=1  ";
            String sql = "select username from client where username ='" + name+"' and  password = '"+password+"'";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                System.out.println(rs.getString("username")+rs.getString("password"));
                return true;
            }
          }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
          return false;
     }
     public Client findByclient(String name,String password) {
        		try {
			String sql = "select username , password from client where username = ? and password = ?";
			PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
                        st.setString(1, name);
                        st.setString(2, password);
                        
			ResultSet rs  = st.executeQuery(sql);
                        
                        
                            if(rs == null){
                                return null;
                            }else{
                                return new Client (rs.getString("username"),rs.getString("password"));
                            }
			
		} catch (SQLException e) {
                    
			e.printStackTrace();
		}
		return null;
    }

     
    }

