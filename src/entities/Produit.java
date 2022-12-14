
package entities;


public class Produit {
    	private int id;
	private String desigation;
	private Double prix_achat;
        private byte[] image;
        private Double tauxTva;
        private Categories category ;
        private Rangement rayon;
	

	public Produit(String desigation, Double prix_achat,byte[] image,Double tauxTva,Categories category,Rangement rayon) {
                
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
                this.tauxTva=tauxTva;
                this.category=category;
                this.rayon=rayon; 
	}
        public Produit(int id,String desigation, Double prix_achat,byte[] image,Double tauxTva,Categories category,Rangement rayon) {
		this.id = id;
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
                this.tauxTva=tauxTva;
                this.category=category;
                this.rayon=rayon; 
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
        public Rangement getRangement() {
		return rayon;
	}

	public void setRangement(Rangement rayon) {
		this.rayon = rayon;
	}
        public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
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
