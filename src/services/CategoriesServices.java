/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.Categories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author chaou
 */
public class CategoriesServices  implements IDao<Categories> {

    @Override
    public boolean create(Categories o) {
  try {
         
	String sql = "INSERT INTO categories values (null, '" + o.getNom()  + "')";
	Statement st = Connexion.getConnection().createStatement();
	if (st.executeUpdate(sql) == 1)
            return true;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;   
    }

    @Override
    public boolean delete(Categories o) {
 try {
            String sql = "delete from categories where id = " + o.getId();
            Statement st = Connexion.getConnection().createStatement();
	if (st.executeUpdate(sql) == 1)
            return true;
	} catch (SQLException e) {
            e.printStackTrace();
	}
	return false;    }

    @Override
    public boolean update(Categories o) {
  try {
            String sql = "update categories set nom = '" + o.getNom() +  "' where id = "
                    + o.getId();
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
    public Categories findById(int id) {
       		 Categories ctg = null;
        try {
            String sql = "select * from categories where id = " + id;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Categories(rs.getInt("id"), rs.getString("nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Categories> findAll() {
   	  List<Categories> catego = new ArrayList<Categories>();
        try {
            String sql = "select * from categories";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                catego.add(new Categories(rs.getInt("id"), rs.getString("nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catego;
    }
    
      public List<Categories> findAllName() {
   	  List<Categories> catego = new ArrayList<Categories>();
        try {
            String sql = "select nom from categories";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                catego.add(new Categories( rs.getString("nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return catego;
    }
      
      
      
         public int getCategoryIdByName(String categoryName,List<Categories> categories){
        
        for(Categories cate : categories){
            if(categoryName.toLowerCase().equals(cate.getNom().toLowerCase())){
               return cate.getId();
            }
        }
        return -1;
    }
      public int getCategoryIdBy(String categoryName){
        
        for(Categories cate : this.findAll()){
            if(categoryName.toLowerCase().equals(cate.getNom().toLowerCase())){
               return cate.getId();
            }
        }
        return -1;
    }
}
