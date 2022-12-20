/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chaou
 */
public class LigneCommande {
        private Commande commande;
	private Produit produit;    
        private int quantite;
	private double prixVente;
	
        //List<Produit> produits;
       

	public LigneCommande( Commande commande, Produit produit,int quantite, double prixVente) {
		super();
                this.commande = commande;
		this.produit = produit;
		this.quantite = quantite;
		this.prixVente = prixVente;
		
             //   produits = new ArrayList<Produit>();
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(double prixVente) {
		this.prixVente = prixVente;
	}
 public Double getMontant(){
            Double montant = prixVente*quantite;
            return montant; 
        }
	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return  " " + commande;
				
	}
}
