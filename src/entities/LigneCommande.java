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
public class LigneCommande {
    private int quantite;
	private double prixVente;
	private Commande commande;
	private Produit produit;

	public LigneCommande(int quantite, double prixVente, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.prixVente = prixVente;
		this.commande = commande;
		this.produit = produit;
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
		return "LigneCommande [quantite=" + quantite + ", prixVente=" + prixVente + ", commande=" + commande
				+ ", produit=" + produit + "]";
	}
}
