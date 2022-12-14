/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author chaou
 */
public class Rangement {
     private int id;
     private int numero;
     
     public Rangement(int numero){
        this.numero=numero;
    }   
     public Rangement(int id,int numero){
        this.id=id;
        this.numero=numero;
    } 

   
    public int getId() {
	return id;
	}
    public void setId(int id) {
	this.id = id;
    }
     public int getNumero() {
	return numero;
	}
    public void setNumero(int numero) {
	this.numero = numero;
    }
 
}
