
package entities;


public class Produit {
    	private int id;
	private String desigation;
	private Double prix_achat;
        private String image;
       private Double tauxTva;
       private Categories category ;
	

	public Produit(String desigation, Double prix_achat,String image,Double tauxTva,Categories category) {
                
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
                this.tauxTva=tauxTva;
                  this.category=category;
	}
        public Produit(int id,String desigation, Double prix_achat,String image,Double tauxTva,Categories category) {
		this.id = id;
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
                this.tauxTva=tauxTva;
                this.category=category;
	}
   public Double getTauxTva() {
		return tauxTva;
	}

	public void setTauxTva(Double tauxTva) {
		this.tauxTva = tauxTva;
	}  
        public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}
    public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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
