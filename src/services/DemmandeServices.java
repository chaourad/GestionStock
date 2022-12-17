
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

    
    @Override
    public boolean create(Demmande o) {
    try {
       String sql = "INSERT INTO demmande values (null, '" + o.getDateAchat() + "', '" + o.getFournisseur()+ "')";
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
    public boolean delete(Demmande o) {
          try {
    String sql = "delete from demmande where id = "+ o.getCode();
    Statement st = Connexion.getConnection().createStatement();
    if(st.executeUpdate(sql)==1){
        return true;
    }
    }catch(SQLException ex){
        ex.printStackTrace();
    }
        return false;    }

    @Override
    public boolean update(Demmande o) {
 try {
        String req = "update demmande set date = ? ,  fournisseur = ? where code = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setDate(1, new Date(o.getDateAchat().getTime()));
           ps.setInt(2, o.getFournisseur().getId());
            ps.setInt(3, o.getCode());
 
    if (ps.executeUpdate() == 1) {
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
				return new Demmande(rs.getInt("code"),  rs.getDate("dateAchat"), frn.findById(rs.getInt("fournisseur")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;   }

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
    
    

  
}
