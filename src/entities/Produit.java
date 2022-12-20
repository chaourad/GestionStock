
package entities;


public class Produit {
    	private int id;
	private String desigation;
	private Double prix_achat;
        private byte[] image;
       
        private Categories category ;
   
       private int quantite;
        
	

	public Produit(String desigation, Double prix_achat,byte[] image,Categories category,int quantite) {
                
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
            
                this.category=category;
       
                 this.quantite=quantite;
	}
        public Produit(int id,String desigation, Double prix_achat,byte[] image,Categories category,int quantite) {
		this.id = id;
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
          
                this.category=category;
        
                 this.quantite=quantite;
	}

         public Produit(int id,String desigation, Double prix_achat,byte[] image,Categories category) {
		this.id = id;
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
           
                this.category=category;
             
                 this.quantite=quantite;
	}
         
         public Produit(String desigationCategories ) {
			this.desigation = desigation;
	
	}
         public Produit(int id,String desigation, Double prix_achat,Categories category) {
		this.id = id;
		this.desigation = desigation;
		this.prix_achat = prix_achat;
                this.image=image;
           
                this.category=category;
             
                 this.quantite=quantite;
	}
            public  int getQte(){
            return quantite;
    }
        public  void setQte(int quantite){
        this.quantite = quantite;    
    }

        public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
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
        
        
     
        public void updateProduit(Produit produit){
            this.category = produit.category;
            this.desigation = produit.desigation;
            this.image = produit.image;
            this.quantite = produit.quantite;
  
            this.prix_achat = produit.prix_achat;
            
        }

    @Override
    public String toString() {
        return desigation; //To change body of generated methods, choose Tools | Templates.
    }
        
     
}
