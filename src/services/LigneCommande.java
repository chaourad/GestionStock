/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.IDao;
import entities.Produit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chaou
 */
public class LigneCommande implements IDao<Produit>{
    List<Produit> produits = new ArrayList<Produit>();;

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

  
    
}
