/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import connexion.Connexion;
import entities.Produit;
import dao.IDao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
     private CategoriesServices ctgr;
   

    public ProduitService() {
        ctgr = new CategoriesServices();
     
    }

 /*
	public boolean create(Produit o , String s) throws FileNotFoundException {
	
                   
        //String sql = "INSERT INTO produit values (null, '" + o.getDesigation() + "', '" + o.getPrix_achat()+"','"+o.getImage()+"','"+o.getTauxTva()+"','"+o.getCategory()+ "')";
	 try {
            String req = "insert into produit values (null, ?, ? , ? , ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
     
             InputStream is = new FileInputStream(new File(s));
            ps.setString(1, o.getDesigation());
            ps.setDouble(2, o.getPrix_achat());
             ps.setBlob(3,is);
       //    ps.setBytes(3, o.getImage());
             ps.setDouble(4, o.getTauxTva());
            ps.setInt(5, o.getCategory().getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;	
	}
        */
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
	 /*try {
            String req = "UPDATE produit SET desigatio = ? , prix_achat = ?,  tauxTva = ? , category = ? , rayon = ?  WHEREid = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
         ps.setString(1, o.getDesigation());
            ps.setDouble(2, o.getPrix_achat());
             ps.setDouble(3, o.getTauxTva());
    //     ps.setInt(5, cg.getCategoryIdByName(cmbCategory.getSelectedItem().toString(), cg.findAll()));
            ps.setInt(4, o.getCategory().getId());
              ps.setInt(5, o.getRangement().getId() );
          
            ps.setInt(6, o.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
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
              
             return new Produit(rs.getInt("id"), rs.getString("desigation"),  rs.getDouble("prix_achat"),rs.getBytes("image"),  ctgr.findById(rs.getInt("category")),rs.getInt("quantite"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

	}

	@Override
	public List<Produit> findAll()  {
		  List<Produit> prd = new ArrayList<Produit>();
        try {
            String sql = "select * from produit";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               prd.add(new Produit(rs.getInt("id"), rs.getString("desigation"),  rs.getDouble("prix_achat"),rs.getBytes("image"),ctgr.findById(rs.getInt("category")),rs.getInt("quantite")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prd;
	}

      
	public List<Produit> findAllByDesi()  {
		  List<Produit> prd = new ArrayList<Produit>();
        try {
            String sql = "select desigation from produit";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               prd.add(new Produit(rs.getString("desigation")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return prd;
	}
        
        
        
        public boolean updateProduitQte(int produitId,int nouveauQte){
          try {
        String req = "update produit set quantite = ? where id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
                ps.setInt(1, nouveauQte);
                ps.setInt(2, produitId);
    if (ps.executeUpdate() == 1) {
                return true;
            }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;   
        }
        
         public int getProduitNumber (){
           
           int c=0;
           
               	List<Produit> cl = findAll();
                
             for(Produit prd : cl){
                 c++;
             }
      
                return c;
             
       }

  
}
