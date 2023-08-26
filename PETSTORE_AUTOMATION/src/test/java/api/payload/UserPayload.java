package api.payload;

public class UserPayload {
	
	int id;
	String username;
	String firsetname;
	String lastname;
	String email;
	String passwoed;
	String phone;
	int userstatus=0;
	
	
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
	public String getFirsetname() {
		return firsetname;
	}
	public void setFirsetname(String firsetname) {
		this.firsetname = firsetname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswoed() {
		return passwoed;
	}
	public void setPasswoed(String passwoed) {
		this.passwoed = passwoed;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getUserstatus() {
		return userstatus;
	}
	public void setUserstatus(int userstatus) {
		this.userstatus = userstatus;
	}
	
	

}
