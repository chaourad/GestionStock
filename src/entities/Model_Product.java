/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.swing.Icon;

/**
 *
 * @author chaou
 */
public class Model_Product {
     private Icon icon;
    private String title;
    private String quantite;
    

    
    public Model_Product(Icon icon, String title,String quantite){
        
        this.icon=icon;
        this.title=title;
        this.quantite=quantite;
      
    }
     public Model_Product(){
         
     }
    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the Values
     */
    public String getValues() {
        return quantite;
    }

    /**
     * @param Values the Values to set
     */
    public void setValues(String quantite) {
        this.quantite = quantite;
    }

  
    
}
