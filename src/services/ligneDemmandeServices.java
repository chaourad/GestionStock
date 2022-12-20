/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Categories;
import entities.Client;
import entities.LigneCommande;
import entities.LigneDemmande;
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
public class ligneDemmandeServices implements IDao<LigneDemmande>{
    
     private  DemmandeServices dmn;
     private ProduitService prd;
     
  
  public ligneDemmandeServices() {
       dmn = new DemmandeServices();
       prd = new ProduitService();
    }
  
  
    @Override
    public boolean create(LigneDemmande o) {
    	  
        try {
          String req = "insert into lignedemmande values (?,? , ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
           ps.setInt(1, o.getDemande().getCode());
            ps.setInt(2, o.getProduit().getId());
            ps.setInt(3, o.getQuantite());
            ps.setDouble(4, o.getPrixVente());
          
       
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
    public boolean delete(LigneDemmande o) {
         try {
            String sql = "delete from lignedemmande where demande = " + o.getDemande().getCode();
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
    public boolean update(LigneDemmande o) {
       try {
            String req = "update lignedemmande set   produit = ?, quantite = ?, prix =  ? where demande = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getProduit().getId());
            ps.setInt(2, o.getQuantite());
           ps.setDouble(3, o.getPrixVente());
           
            ps.setInt(4, o.getDemande().getCode());
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
    public LigneDemmande findById(int id) {
	try {
            String sql = "select * from lignedemmande where demande = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs  = st.executeQuery(sql);
            if(rs.next())
		return new LigneDemmande(dmn.findById(rs.getInt("demande")), prd.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prix"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
    @Override
    public List<LigneDemmande> findAll() {
       	List<LigneDemmande> cl = new ArrayList<LigneDemmande>();
		try {
			String sql = "select * from lignedemmande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
			cl.add(new LigneDemmande(dmn.findById(rs.getInt("demande")), prd.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prix")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
    }
    
    
  
}
