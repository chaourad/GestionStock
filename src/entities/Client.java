
package entities;

public class Client {
    private int id;
	private String username;
        private String password;
	private String telephone;
	private String email;
   
       
	

	public Client(String username, String password, String telephone, String email) {
		
		this.username = username;
                this.password = password;
		this.telephone = telephone;
		this.email = email;
           
             
	}
        public Client(String username){
            this.username = username;
          
        }
        
        public Client(int id, String username, String password,  String telephone, String email) {
		this.id = id;
		this.username = username;
                  this.password = password;
		this.telephone = telephone;
		this.email = email;
                   
                
	}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

	public int getId() {
		return id;
	}
   
	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password =password ;
	}

	@Override
	public String toString() {
		return username;
	}
}
