/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import connexion.Connexion;
import entities.Produit;
import dao.IDao;
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
public class ProduitService implements IDao<Produit> {
    @Override
	public boolean create(Produit o) {
		try {
			String sql = "INSERT INTO produit values (null, '" + o.getDesigation() + "', '" + o.getPrix_achat()+ "')";
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
	public boolean delete(Produit o) {
	try {
            String sql = "delete from produit where id = " + o.getId();
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
	public boolean update(Produit o) {	
	try {
            String sql = "update produit set designation = '" + o.getDesigation() + "', prixAchat = '" + o.getPrix_achat() + "' where id = "+ o.getId();
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
	public Produit findById(int id) {
		Produit produit = null;
		 try {
            String sql = "select * from produit where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Produit(rs.getInt("id"), rs.getString("designation"), rs.getDouble("prixAchat"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

	}

	@Override
	public List<Produit> findAll()  {
		List<Produit> produits = new ArrayList<>();
		try {
			String req = "select * from produit ";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs = st.executeQuery(req);
			while (rs.next())
                            	produits.add(new Produit(rs.getInt("id"),rs.getString("designation"), rs.getDouble("prixAchat")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return produits;
	}


  
}
