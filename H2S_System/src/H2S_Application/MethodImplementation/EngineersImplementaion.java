package H2S_Application.MethodImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import H2S_Application.Dao_Uility.connection__;
import H2S_Application.MethodInterface.EngineersInterface;
import H2S_Application.ModelClasses.AttendedProblems;
import H2S_Application.ModelClasses.Problem;

public class EngineersImplementaion implements EngineersInterface{

	@Override
	public String LoginAsEngineer(String Email, String Password) {
		String meString = "Invalid Email or Password.....";
		
		try (Connection connect = connection__.provideConnection()){
			
			PreparedStatement pt = connect.prepareStatement("select * from engineers where emailId = ? AND password = ?");
			
			pt.setString(1, Email);
			pt.setString(2, Password);
			
			ResultSet rSet = pt.executeQuery();
			
			if(rSet.next()) {
				meString = "Wecome "+ rSet.getString("Name");
				System.out.println(meString);
			}else {
				System.out.println(meString);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return meString;
	}

	@Override
	public List<Problem> GetAssignedProblems(String engineerID) {
		List<Problem> p1 = new ArrayList<>() ;
		try(Connection connect = connection__.provideConnection()) {
			
			PreparedStatement pt = connect.prepareStatement("select * from problems p INNER JOIN  engineers e ON e.EngineerId = p.EngineerId AND p.engineerId = '"+engineerID+"'");
			
			ResultSet rSet = pt.executeQuery();
			while(rSet.next()) {
				int complainId = rSet.getInt("complainId");
				String problem = rSet.getString("problem");
				String category = rSet.getString("category");
				String status = rSet.getString("status");
				String engineerId = rSet.getString("engineerId");
				String employeeID = rSet.getString("engineerId");
				
				Problem prb = new Problem(complainId,problem,category,status,engineerId,employeeID);
				p1.add(prb);
				
				
			}
			if(rSet.next()==false)
			{
				System.out.println("Problems are not assinged....");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return p1;
	}

	@Override
	public String UpdateStatus(String status, int complainId , String engineerId) {
		String meString = "";
		
        
		
		try (Connection connect = connection__.provideConnection()){
			
			PreparedStatement pt = connect.prepareStatement("update problems set status = ? where complainId = ? AND engineerId = ?");
			
			pt.setString(1, status);
			pt.setInt(2, complainId);
			pt.setString(3, engineerId);
			int x = pt.executeUpdate();
			
			if(x>0) {
				
				PreparedStatement pk = connect.prepareStatement("select * from problems where complainId = '"+complainId+"' ");
				ResultSet resultSet  = pk.executeQuery();
				while(resultSet.next()) {
					int AtcomplainId = resultSet.getInt("complainId");
					String Atproblem = resultSet.getString("problem");
					String Atcategory = resultSet.getString("category");
					String Atstatus = resultSet.getString("status");
					String AtengineerId = resultSet.getString("engineerId");
					
					PreparedStatement Attend = connect.prepareStatement("insert into attendedProblem values(?,?,?,?,?)");
					
					Attend.setInt(1, AtcomplainId);
					Attend.setString(2, Atproblem);
					Attend.setString(3, Atcategory);
					Attend.setString(4, Atstatus);
					Attend.setString(5, AtengineerId);
					Attend.executeUpdate();
					
				}
				
				
				
				
				meString = "Status upadated for "+ complainId+ "Problem";
				System.out.println(meString);
			}else {
				System.out.println("Problem doesn't exits with "+complainId);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return meString;
	}

	@Override
	public List<AttendedProblems> getAttendedProblems(String engineerID) {
		List<AttendedProblems> At1 = new ArrayList<>() ;
		try(Connection connect = connection__.provideConnection()) {
			
			PreparedStatement pt = connect.prepareStatement("select * from attendedproblem where engineerId = '"+engineerID+"' " );
			
			ResultSet rSet = pt.executeQuery();
			
			while(rSet.next()) {
				int complainId = rSet.getInt("complainId");
				String problem = rSet.getString("problem");
				String category = rSet.getString("category");
				String status = rSet.getString("status");
				String engineerId = rSet.getString("engineerId");
				
				
				AttendedProblems prb = new AttendedProblems(complainId,problem,category,status,engineerId);
				At1.add(prb);
				
				
			}
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return At1;
	}

	@Override
	public String ChangePassword(String Email, String oldPassword ,String newPassword) {
		String messaString = "";
		
		try(Connection connn = connection__.provideConnection()) {
			
			PreparedStatement pt = connn.prepareStatement("update engineers set password = ? where emailId = ? AND password = ?");
			pt.setString(1, newPassword);
			pt.setString(2, Email);
			pt.setString(3, oldPassword);
			
			int x = pt.executeUpdate();
			if(x>0) {
				messaString = "Successfully Password changed";
				System.out.println(messaString);
			}else {
				messaString = "You have entered somethink wrong details";
				System.out.println(messaString);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return messaString;
	}


}
