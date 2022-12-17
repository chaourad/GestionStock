
package entities;

import java.util.Date;
import java.util.List;


public class Demmande {
        private int code;
	private Date date;
	private Fournisseur fournisseur;
     
        private String txtDm;


	public Demmande(int code, Date date, Fournisseur fournisseur) {
		super();
		this.code = code;
		this.date = date;
		this.fournisseur = fournisseur;
          
	}
        	public Demmande(Date date, Fournisseur fournisseur) {
		super();
		this.date = date;
		this.fournisseur = fournisseur;
                
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
        public String gettxtDm() {
		return txtDm;
	}

	public void settxtDm(String txtDm) {
		this.txtDm = txtDm;
	}
 
 
	public Date getDateAchat() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Demmande [code=" + code + ", date=" + date + "]";
	}

}
