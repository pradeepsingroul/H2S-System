package H2S_Application.ModelClasses;

public class Engineer {
	
	private String engineerId;
	private String name;
	private String username;
	private String password;
	private String category;
	
	
	public Engineer(String engineerId, String name, String username, String password, String category) {
		super();
		this.engineerId = engineerId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
	}


	public Engineer() {
		super();
	}


	public String getEngineerId() {
		return engineerId;
	}


	public void setEngineerId(String engineerId) {
		this.engineerId = engineerId;
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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Engineer [engineerId=" + engineerId + ", name=" + name + ", username=" + username + ", password="
				+ password + ", category=" + category + "]";
	}
	
	
	

}
