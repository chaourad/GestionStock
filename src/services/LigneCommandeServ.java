/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Commande;
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
public class LigneCommandeServ implements IDao<LigneCommande>{
    //List<Produit> produits = new ArrayList<Produit>();
    
    private  CommandeService cmn;
     private ProduitService prd;
     
  
  public LigneCommandeServ() {
       cmn = new CommandeService();
       prd = new ProduitService();
    }

  
   public boolean create(LigneCommande o) {
    	  
        try {
          String req = "insert into lignecommande values (?,? , ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
           ps.setInt(1, o.getCommande().getCode());
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
   
     public boolean delete(LigneCommande o) {
         try {
            String sql = "delete from lignecommande where commande  = " + o.getCommande().getCode();
            Statement st = Connexion.getConnection().createStatement();
            if (st.executeUpdate(sql) == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
/*
    @Override
    public boolean create(Produit o) {
       produits.add(o);
       return true;
    }

    @Override
    public boolean delete(Produit o) {
     produits.remove(o);
     return true;
    }

    @Override
    public boolean update(Produit o) {
  
       produits.forEach((Produit produit) -> {
       if(produit.getId() == o.getId()){
           
           o.updateProduit(produit);
          
         
       }
    
       });
       return true;
    }
    
    
    public String produitsToString(){
      String productsIds = "";
      int i = 0;
    
      for(Produit produit : produits){
          
         if(i< produits.size()-1){
              productsIds+=Integer.toString(produit.getId())+":";
         }else{
               productsIds+=Integer.toString(produit.getId());
         }
          i++;
      }
      
      return productsIds;
    }
*/

    @Override
    public boolean update(LigneCommande o) {
          try {
            String req = "update lignecommande set   produit = ?, quantite = ?, prixVente =  ? where commande  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getProduit().getId());
            ps.setInt(2, o.getQuantite());
           ps.setDouble(3, o.getPrixVente());
           
            ps.setInt(4,o.getCommande().getCode());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
   public LigneCommande findById(int id) {
	try {
            String sql = "select * from lignecommande where commande = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs  = st.executeQuery(sql);
            if(rs.next())
		return new LigneCommande(cmn.findById(rs.getInt("commande")), prd.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prixVente"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
    }
    public List<LigneCommande> findAll() {
       	List<LigneCommande> cl = new ArrayList<LigneCommande>();
		try {
			String sql = "select * from lignecommande";
			Statement st = Connexion.getConnection().createStatement();
			ResultSet rs  = st.executeQuery(sql);
			while(rs.next())
			cl.add(new LigneCommande(cmn.findById(rs.getInt("commande")), prd.findById(rs.getInt("produit")), rs.getInt("quantite"), rs.getDouble("prixVente")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cl;
    }
    
    
}
