package H2S_Application.MethodInterface;

import java.util.List;

import H2S_Application.ModelClasses.Problem;

public interface EmployeeInterface {
	
	
	public String RegisterAsEmployee(String EmployeeID,String Name, String Email,String password);
	
	
	public String LiginAsEmployee(String email, String password);

	
	public String raiseProblem(String problemName,String Category,String status, String EmployeeID);
	
	
	public String checkStatus(int complainId,String employeeID);
		
	
	
}
