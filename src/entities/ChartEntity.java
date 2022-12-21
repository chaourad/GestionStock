/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author chaou
 */
public class ChartEntity {
    private Date date;
    private int vente;
    
   public ChartEntity(Date date,int vente){
        this.date = date;
        this.vente = vente;
    }
    
    
    
    
   public Date getDate(){
        return this.date;
    }
    
    
   public int getVente(){
        return this.vente;
    }
    
    
 public   void setDate(Date date){
        this.date = date;
    }
    
  public  void setVente(int vente){
        this.vente = vente;
    }
    
    
    
    
}
