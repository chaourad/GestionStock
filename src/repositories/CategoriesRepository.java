/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;


import entities.Categories;
import services.CategoriesServices;

/**
 *
 * @author chaou
 */
public class CategoriesRepository {
    CategoriesServices categoriesServices;
    
    CategoriesRepository(){
        categoriesServices = new CategoriesServices();
    }
    
    
    public Categories getCategoryById(int id){
        return categoriesServices.findById(id);
    }
    
    
}
