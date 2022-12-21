/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import connexion.Connexion;
import dao.IDao;
import entities.ChartEntity;
import entities.Client;
import entities.Commande;
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
public class CommandeService implements IDao<Commande> {

    private List<Commande> commandes;
    private ClientServices ss;

    public CommandeService() {
        ss = new ClientServices();
    }

    @Override
    public boolean create(Commande o) {

        try {
            String req = "insert into commande values ( ?, ? , ? )";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);

            ps.setInt(1, o.getCode());
            ps.setDate(2, new Date(o.getDate().getTime()));

            ps.setInt(3, o.getClient().getId());

            if (ps.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        /*  String sql = "INSERT INTO commande values (null, '" + o.getDate() + "', '" + o.getClient().getId()+  "')";
         Statement st = Connexion.getConnection().createStatement();
         if (st.executeUpdate(sql) == 1)
         return true;
         } catch (SQLException e) {
         e.printStackTrace();
         }*/
        return false;

    }

    @Override
    public boolean delete(Commande o) {
        try {
            String req = "delete from commande where code  = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, o.getCode());
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
    public boolean update(Commande o) {
        try {
            /* String req = "update commande set  date  = ?, client = ? where code = ?";
             PreparedStatement st = Connexion.getConnection().prepareStatement(req);     
            
             st.setDate(1, new Date(o.getDate().getTime())); 
             st.setInt(2, o.getClient().getId());
             st.setInt(3, o.getCode());
             if (st.executeUpdate() == 1) {
             return true;
             }*/
            String req = "update commande set date = ? ,  client = ? where code = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);

            ps.setDate(1, new Date(o.getDate().getTime()));
            ps.setInt(2, o.getClient().getId());
            ps.setInt(3, o.getCode());
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
    public Commande findById(int code) {
        Commande commande = null;
        try {
            String sql = "select * from commande where code = " + code;
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                return new Commande(rs.getInt("code"), rs.getDate("date"), ss.findById(rs.getInt("client")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Commande> findAll() {

        List<Commande> Commandes = new ArrayList<Commande>();
        try {
            String sql = "select * from commande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"), ss.findById(rs.getInt("client"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Commandes;
    }

    public List<Commande> findAllByCode() {
        List<Commande> frnss = new ArrayList<Commande>();
        try {
            String sql = "select code from commande";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                frnss.add(new Commande(rs.getInt("code")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return frnss;
    }

    public int getCommandeNumber() {

        int c = 0;

        List<Commande> cl = findAll();

        for (Commande cmnd : cl) {
            c++;
        }

        return c;

    }
    
    

    public List<Commande> findBetweenDate(java.util.Date d1, java.util.Date d2) {
        List<Commande> commandes = new ArrayList<Commande>();
        try {
            String sql = "select * from commande where date between ? and ?";
            PreparedStatement st = Connexion.getConnection().prepareStatement(sql);
            st.setDate(1, new Date(d1.getTime()));
            st.setDate(2, new Date(d2.getTime()));
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"), ss.findById(rs.getInt("client"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

    public List<ChartEntity> getOrdersByDate() {
        List<ChartEntity> charts = new ArrayList<ChartEntity>();
        try {
            String sql = "SELECT date,COUNT(code) as commandes from commande group by date";
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                charts.add(new ChartEntity(rs.getDate("date"), rs.getInt("commandes")));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return charts;

    }
 public List<Commande> findCommandeByClient(Commande s) {
        List<Commande> machines = new ArrayList<Commande>();
        try {
            String sql = "select * from commande where client = " + s.getClient();
            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
               commandes.add(new Commande(rs.getInt("code"), rs.getDate("date"), ss.findById(rs.getInt("client"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return machines;
    }

   
}
