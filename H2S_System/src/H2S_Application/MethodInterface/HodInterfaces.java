package H2S_Application.MethodInterface;

import java.util.List;

import H2S_Application.ModelClasses.Engineer;
import H2S_Application.ModelClasses.Problem;

public interface HodInterfaces {
	
	public String HOD_Login(String username,String password);

	
	public String registerIntoEngineerString(String EngineerId, String Name, String Email,String Password,String Category);
	
	
	public List<Engineer> getEngineerData();
	
	public String deleteengineerS(String EngineerId);
	
	
	public List<Problem> getProblembsDetails();
	
	
	public String AssignToEngineer(int complainId, String EngineerID);
		
	
	
	
	
	
}
