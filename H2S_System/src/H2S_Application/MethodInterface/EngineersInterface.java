package H2S_Application.MethodInterface;

import java.util.List;

import H2S_Application.ModelClasses.AttendedProblems;
import H2S_Application.ModelClasses.Problem;

public interface EngineersInterface {
	
	public String LoginAsEngineer(String Email,String password);

	
	public List<Problem> GetAssignedProblems(String engineerID);
	
	
	public String UpdateStatus(String statuString, int complainId,String engineerId);
	
	
	public List<AttendedProblems> getAttendedProblems(String engineerID);
	
	
	public String ChangePassword(String Email,String oldPassword,String newPassword);
	
}
