/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Categories;
import entities.Rangement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chaou
 */
public class RangementService  implements IDao<Rangement>{

    @Override
    public boolean create(Rangement o) {
 try {
         
	String sql = "INSERT INTO rayon values (null, '" + o.getNumero()  + "')";
	Statement st = Connexion.getConnection().createStatement();
	if (st.executeUpdate(sql) == 1)
            return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;      }

    @Override
    public boolean delete(Rangement o) {
        try {
            String sql = "delete from rayon where id = " + o.getId();
            Statement st = Connexion.getConnection().createStatement();
	if (st.executeUpdate(sql) == 1)
            return true;
	} catch (SQLException e) {
            e.printStackTrace();
	}
	return false;    }

    @Override
    public boolean update(Rangement o) {
  try {
            String sql = "update rayon set numero = '" + o.getNumero() +  "' where id = "
                    + o.getId();
            Statement st = Connexion.getConnection().createStatement();
            if (st.executeUpdate(sql) == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;    }

    @Override
    public Rangement findById(int id) {
   		 Rangement rng = null;
        try {
            String sql = "select * from rayon where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Rangement(rs.getInt("id"), rs.getInt("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;    }

    @Override
    public List<Rangement> findAll() {
  List<Rangement> rng = new ArrayList<Rangement>();
        try {
            String sql = "select * from rayon";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rng.add(new Rangement(rs.getInt("id"),rs.getInt("numero")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rng;    }
    
      public List<Rangement> findAllByName() {
  List<Rangement> rng = new ArrayList<Rangement>();
        try {
            String sql = "select numero from rayon";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                rng.add(new Rangement(rs.getInt("numero")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rng;    
      }
      
      
      
      
      
         public int getRangIdByNumero(int numeroRang,List<Rangement> rangemts){
        
        for(Rangement rng : rangemts){
            if(numeroRang == rng.getNumero()){
               return rng.getId();
            }
        }
        return -1;
    }
         
              
    
    
}
