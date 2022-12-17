
package entities;

import java.util.ArrayList;
import java.util.List;

public class LigneDemmande {
    	private int quantite;
	private double prix;
	private Demmande demande;
	private Produit produit;
        List<Produit> produits;
        
        

	public LigneDemmande(int quantite, double prix, Demmande demande, Produit produit) {
		super();
		this.quantite = quantite;
		this.prix = prix;
		this.demande = demande;
		this.produit = produit;
                produits = new ArrayList<Produit>();
	}
        
        
        
        
        
        
        public void getAllProduct(){
            
        }
        
        
        
       

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public double getPrixVente() {
		return prix;
	}

	public void setPrixVente(double prix) {
		this.prix = prix;
	}

	public Demmande getDemande() {
		return demande;
	}

	public void setDemande(Demmande demande) {
		this.demande = demande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "LigneDemmande [quantite=" + quantite + ", prixVente=" + prix + ", demande=" + demande
				+ ", produit=" + produit + "]";
	}
}
