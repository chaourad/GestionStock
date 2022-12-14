/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Client;
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
public class ClientServices implements IDao<Client>{

    @Override
    public boolean create(Client o) {
      try {
         
	String sql = "INSERT INTO client values (null, '" + o.getUsername() + "', '" + o.getPassword()+ "', '" + o.getTelephone()+"', '" +o.getEmail() + "')";
	Statement st = Connexion.getConnection().createStatement();
	if (st.executeUpdate(sql) == 1)
            return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
    }

    @Override
    public boolean delete(Client o) {
     try {
            String sql = "delete from client where id = " + o.getId();
            Statement st = Connexion.getConnection().createStatement();
            if (st.executeUpdate(sql) == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Client o) {
        
       try {
            String req = "update client set username = ? , password = ?, telephone = ?, email = ?where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getUsername());
            ps.setString(2, o.getPassword());
           ps.setString(3, o.getTelephone());
            ps.setString(4, o.getEmail());
            ps.setInt(5, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Client findById(int id) {
        		try {
			String sql = "select * from client where id = " + id;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			if(rs.next())
				return new Client (rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("telephone"), rs.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public List<Client> findAll() {
       	List<Client> cl = new ArrayList<Client>();
		try {
			String sql = "select * from client";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
                          
				cl.add(new Client ( rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("telephone"), rs.getString("email")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
    }
    
}
