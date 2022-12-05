
package entities;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Commande {
        private int code;
	private Date date;
	private Client client;

	public Commande(int code, Date date, Client client) {
		super();
		this.code = code;
		this.date = date;
		this.client = client;
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
