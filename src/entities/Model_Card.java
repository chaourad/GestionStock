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
public class Model_Card {
    private Icon icon;
    private String title;
    private String Values;
    

    
    public Model_Card(Icon icon, String title,String Values){
        
        this.icon=icon;
        this.title=title;
        this.Values=Values;
      
    }
     public Model_Card(){
         
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
        return Values;
    }

    /**
     * @param Values the Values to set
     */
    public void setValues(String Values) {
        this.Values = Values;
    }

  
    
}
