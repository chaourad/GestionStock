/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Fournisseur;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author chaou
 */
public class FournisseurService implements IDao<Fournisseur> {

    @Override
    public boolean create(Fournisseur o) {
    try {
    String sql = "INSERT INTO fournisseur VALUES( null, '"+o.getNom() +"','"+o.getTelephone()+"',"+o.getEmail()+"')";
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
    String sql = "update  fournisseur set nom = '" +o.getNom() +"',telephone'"+ o.getTelephone()+"', email'"+o.getEmail()+"'where id ='"+o.getId();
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
    public Fournisseur findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Fournisseur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
