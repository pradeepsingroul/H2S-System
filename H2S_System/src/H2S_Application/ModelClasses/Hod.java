package H2S_Application.ModelClasses;

public class Hod {
	
	private int hId;
	private String name;
	private String username;
	private String password;
	
	
	
	@Override
	public String toString() {
		return "Hod [hId=" + hId + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	public Hod(int hId, String name, String username, String password) {
		super();
		this.hId = hId;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	public int gethId() {
		return hId;
	}
	public void sethId(int hId) {
		this.hId = hId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Hod() {
		super();
	}
	
	
	
	
	

}
