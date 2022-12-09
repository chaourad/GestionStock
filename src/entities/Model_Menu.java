/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author chaou
 */
public class Model_Menu {
    
     public String getIcone(){
        return icon;
    }
    public void setIcone(String icon){
        this.icon = icon;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setType(MenuType type){
        this.type = type;
    }
     
    public MenuType getType(){
       return type;
    }
    public Model_Menu(String icon,String name, MenuType type){
        this.icon=icon;
        this.name=name;
        this.type=type;
    }
     public Model_Menu(){
       
    }
  String icon;
    String name;
    MenuType type;  
    public Icon toIcon(){
        return new ImageIcon(getClass().getResource("/icons/"+icon+".png"));
    }
    
    public  static enum MenuType {

      TITLE , MENU, EMPTY
    }
}
