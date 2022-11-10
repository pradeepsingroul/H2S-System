package H2S_Application.ModelClasses;

public class Employee {
	
	private String employeeId;
	private String name;
	private String username;
	private String password;
	
	
	
	public Employee(String employeeId, String name, String username, String password) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.username = username;
		this.password = password;
	}



	public String getEmployeeId() {
		return employeeId;
	}



	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", username=" + username + ", password="
				+ password + "]";
	}



	public Employee() {
		super();
	}
	
	
	
	

}
