
package entities;


public class Produit {
    	private int id;
	private String desigation;
	private Double prix_achat;
	

	public Produit(String desigation, Double prix_achat) {
                    
		this.desigation = desigation;
		this.prix_achat = prix_achat;
	}
        public Produit(int id,String desigation, Double prix_achat) {
		this.id = id;
		this.desigation = desigation;
		this.prix_achat = prix_achat;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesigation() {
		return desigation;
	}

	public void setDesigation(String desigation) {
		this.desigation = desigation;
	}

	public Double getPrix_achat() {
		return prix_achat;
	}

	public void setPrix_achat(Double prix_achat) {
		this.prix_achat = prix_achat;
	}
        
}
