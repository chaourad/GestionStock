
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Demmande;
import entities.Fournisseur;
import java.sql.Date;
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
public class DemmandeServices implements IDao<Demmande> {

    private FournisseurService frn ;
  
  public DemmandeServices() {
       frn = new FournisseurService();
    }

    // ps.setInt(5, cg.getCategoryIdByName(cmbCategory.getSelectedItem().toString(), cg.findAll()));
    @Override
    public boolean create(Demmande o) {
      try {
            String req = "insert into demmande values ( ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
           
            ps.setInt(1, o.getCode());
          ps.setDate(2, new Date(o.getDate().getTime()));
          ps.setInt(3, o.getFournisseur().getId());
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
    public boolean delete(Demmande o) {
          try {
    String req = "delete from demmande where code  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getCode());
            if (ps.executeUpdate() == 1) {
                return true;
            }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;    }

    @Override
    public boolean update(Demmande o) {
 try {
        String req = "update demmande set  date  = ?, fournisseur = ? where code = ?";
            PreparedStatement st = Connexion.getConnection().prepareStatement(req);     
            
            st.setDate(1, new Date(o.getDate().getTime())); 
            st.setInt(2, o.getFournisseur().getId());
            st.setInt(3, o.getCode());
           if (st.executeUpdate() == 1) {
                return true;
            }

    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;    }

    @Override
    public Demmande findById(int id) {
	try {
            String sql = "select * from demmande where code = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs  = st.executeQuery(sql);
                if(rs.next())
			return new Demmande(rs.getInt("code"),  rs.getDate("date"), frn.findById(rs.getInt("fournisseur")));
        } catch (SQLException e) {
            e.printStackTrace();
		
        }
		
        return null;  
    }

    @Override
    public List<Demmande> findAll() {
   List<Demmande> frnss = new ArrayList<Demmande>();
        try {
            String sql = "select * from demmande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                frnss.add(new Demmande(rs.getInt("code"), rs.getDate("date"), frn.findById(rs.getInt("fournisseur"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return frnss;       }
    

      public List<Demmande> findAllByCode() {
   List<Demmande> frnss = new ArrayList<Demmande>();
        try {
            String sql = "select code from demmande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                frnss.add(new Demmande(rs.getInt("code")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return frnss;       }
      
      
         
    
}
