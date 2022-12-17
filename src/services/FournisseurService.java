/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Client;
import entities.Fournisseur;
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
public class FournisseurService implements IDao<Fournisseur> {

    @Override
    public boolean create(Fournisseur o) {
    try {
       String sql = "INSERT INTO fournisseur values (null, '" + o.getNom() + "', '" + o.getTelephone()+"', '" +o.getEmail() + "')";
    Statement st = Connexion.getConnection().createStatement();
    if(st.executeUpdate(sql)==1){
        return true;
    }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    }

    @Override
    public boolean delete(Fournisseur o) {
          try {
    String sql = "delete from fournisseur where id = "+ o.getId();
    Statement st = Connexion.getConnection().createStatement();
    if(st.executeUpdate(sql)==1){
        return true;
    }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    }

    @Override
    public boolean update(Fournisseur o) {
    try {
        String req = "update fournisseur set nom = ? ,  telephone = ?, email = ?where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getNom());
           ps.setString(2, o.getTelephone());
            ps.setString(3, o.getEmail());
            ps.setInt(4, o.getId());
    if (ps.executeUpdate() == 1) {
                return true;
            }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;
    }

    @Override
    public Fournisseur findById(int id) {
  		try {
			String sql = "select * from fournisseur where id = " + id;
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			if(rs.next())
				return new Fournisseur(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"), rs.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;    }

    @Override
    public List<Fournisseur> findAll() {
       	List<Fournisseur> cl = new ArrayList<Fournisseur>();
		try {
			String sql = "select * from fournisseur";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
                          
				cl.add(new  Fournisseur(rs.getInt("id"), rs.getString("nom"), rs.getString("telephone"), rs.getString("email")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;    
    }
    
    public List<Fournisseur> findAllByName(){
        List<Fournisseur> f1 = new ArrayList<Fournisseur>();
        try{
            String sql = "select nom from fournisseur";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
                f1.add(new  Fournisseur( rs.getString("nom")));
        }catch(SQLException ex){
            ex.printStackTrace();
        }
                
        return f1;
    }
    
    
     public int getfounissIdByName(String fournName,List<Fournisseur> fournisseurs){
        
        for(Fournisseur four : fournisseurs){
            if(fournName.toLowerCase().equals(four.getNom().toLowerCase())){
               return four.getId();
            }
        }
        return -1;
    }

    public Fournisseur getfounissIdByName(String toString) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
