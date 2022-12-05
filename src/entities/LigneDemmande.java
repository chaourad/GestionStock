
package entities;

public class LigneDemmande {
    	private int quantite;
	private double prixVente;
	private Demmande demande;
	private Produit produit;

	public LigneDemmande(int quantite, double prixVente, Demmande demande, Produit produit) {
		super();
		this.quantite = quantite;
		this.prixVente = prixVente;
		this.demande = demande;
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
		return "LigneDemmande [quantite=" + quantite + ", prixVente=" + prixVente + ", demande=" + demande
				+ ", produit=" + produit + "]";
	}
}
