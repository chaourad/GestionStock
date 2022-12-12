/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import services.AuthService;

/**
 *
 * @author chaou
 */
public class AuthentificationRepository {
    AuthService authService;
   public AuthentificationRepository(){
        authService=new AuthService();
    }
   
   
   
   // hna fuction ta3 login
   public boolean seAuthentifier(String name,String paswr){
       if(name.isEmpty() || paswr.isEmpty()){
           return false;
       }
       authService.auth(name, paswr);
       return true;
   }
}
