/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Produit;
import java.util.ArrayList;
import java.util.List;
import services.ProduitService;

/**
 *
 * @author chaou
 */
public class ProductsRepository {
    ProduitService produitService;
   public ProductsRepository(){
        produitService = new ProduitService();
    }
    
    
    
    public List<Produit> getAllProducts() {
        return   produitService.findAll();
      
    }
    
    
    
    
}
