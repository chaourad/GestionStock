
package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Commande {
        private int code;
	private Date date;
	private Client client;
    
         private String tblPrd;
 private ArrayList<LigneCommande> ligneCommandes;
	public Commande(int code, Date date, Client client,String tblPrd) {
		super();
		this.code = code;
		this.date = date;
		this.client = client;
                this.tblPrd = tblPrd;
          

	}
        public Commande(int code, Date date, Client client) {
		super();
		this.code = code;
		this.date = date;
		this.client = client;
         

	}
        public Commande(int code) {
		super();
		this.code = code;
		
         

	}
           public Commande( Date date, Client client) {
	
		this.date = date;
		this.client = client;
         

	}
        public Commande( Date date, Client client,String tblPrd) {
		
		this.date = date;
		this.client = client;
                this.tblPrd = tblPrd;
          

	}
        public String gettblPrd() {
		return tblPrd;
	}

	public void settblPrd(String tblPrd) {
		this.tblPrd = tblPrd;
	}
        
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
		return "Commande : " + code + " / " + sdf.format(date);
	}    
}
