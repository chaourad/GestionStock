/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Commande;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author chaou
 */
public class CommandeService implements IDao<Commande>{
private ClientServices cc;
  public CommandeService() {
        cc = new ClientServices();
    }

    @Override
    public boolean create(Commande o) {
	try {
            String sql = "INSERT INTO commande values (null, '" + o.getCode() + "', '" + o.getDate()+"','"+o.getClient()+ "')";
             Statement st = Connexion.getConnection().createStatement();
            if (st.executeUpdate(sql) == 1) {
                return true;
            }
		} catch (SQLException e) {
			  e.printStackTrace();

		}
		return false;    }

    @Override
    public boolean delete(Commande o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Commande o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Commande findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Commande> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
