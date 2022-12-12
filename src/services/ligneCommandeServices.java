/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Categories;
import entities.LigneCommande;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author chaou
 */
public class ligneCommandeServices implements IDao<LigneCommande>{
  private ProduitService ss;
  

    public ligneCommandeServices() {
        ss = new ProduitService();
    }

    @Override
    public boolean create(LigneCommande o) {
try {
            String req = "insert into produit values (null, ?, ? , ? , ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getQuantite());
            ps.setDouble(2, o.getPrixVente());
             //ps.setString(3, o.getImage());
             //ps.setInt(4, o.getTauxTva());
            
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;	    }

    @Override
    public boolean delete(LigneCommande o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(LigneCommande o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LigneCommande findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LigneCommande> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
