package H2S_Application.MethodImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import H2S_Application.Dao_Uility.connection__;
import H2S_Application.MethodInterface.HodInterfaces;
import H2S_Application.ModelClasses.Engineer;
import H2S_Application.ModelClasses.Problem;

public class HodImpl implements HodInterfaces  {

	@Override
	public String HOD_Login(String Email, String Password) {
		
		String message = "Invailid username Or password";
		
		
		try (Connection connect = connection__.provideConnection()){
			
			PreparedStatement pt = connect.prepareStatement("select * from hod where username = ? AND password = ?");
			
			pt.setString(1, Email);
			pt.setString(2, Password);
			
			ResultSet rSet = pt.executeQuery();
			
			if(rSet.next()) {
				message = "Wecome "+ rSet.getString("Name");
				System.out.println(message);
			}else {
				System.out.println(message);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
		
		
	}


	@Override
	public String registerIntoEngineerString(String engineerId, String Name, String Email, String Password,
			String category) {
		
		 String message = "Can't Register in the Engineer";
			
			
			try (Connection connect = connection__.provideConnection()){
				
				PreparedStatement pt = connect.prepareStatement("Insert into engineers values(?,?,?,?,?)");
				
				
				pt.setString(1, engineerId);
				pt.setString(2, Name);
				pt.setString(5, category);
				pt.setString(3, Email);
				pt.setString(4, Password);
				
				int x = pt.executeUpdate();
				
				if(x>0) {
					message = Name+ " succesfully register inside the engineers database";
					System.out.println(message);
				}else {
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
			return message; 
			
		
	}


	@Override
	public List<Engineer> getEngineerData() {
		
		List<Engineer> e1 = new ArrayList<>() ;
		try(Connection connect = connection__.provideConnection()) {
			
			PreparedStatement pt = connect.prepareStatement("select * from engineers");
			
			ResultSet rSet = pt.executeQuery();
			while(rSet.next()) {
				String engineerId = rSet.getString("EngineerId");
				String Name = rSet.getString("Name");
				String Email = rSet.getString("EmailId");
				String Password = rSet.getString("Password");
				String Category = rSet.getString("Category");
				
				
				Engineer p = new Engineer(engineerId,Name,Email,Password,Category);
				e1.add(p);
				
				
			}
			if(!rSet.next())
			{
				System.out.println("Engineers Database is empty.....");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return e1;
	}


	@Override
	public String deleteengineerS(String eId) {
		// TODO Auto-generated method stub
		String meString = "Incorrect eid......";
		
		try (Connection conn = connection__.provideConnection()){
			
			PreparedStatement pt = conn.prepareStatement("delete from engineers where engineerId = ?");
			pt.setString(1, eId);
			int x = pt.executeUpdate();
			if(x>0) {
				meString = eId + " Is delete from the engineers database.....";
				System.out.println(meString);
			}else {
				System.out.println(meString);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return meString;
	}


	@Override
	public List<Problem> getProblembsDetails() {
		
		List<Problem> problems = new ArrayList<>() ;
		try(Connection connect = connection__.provideConnection()) {
			
			PreparedStatement pt = connect.prepareStatement("select * from problems");
			
			ResultSet rSet = pt.executeQuery();
			while(rSet.next()) {
				int complainid = rSet.getInt("complainid");
				String ProblemName = rSet.getString("Problem");
				String category = rSet.getString("category");
				String Status = rSet.getString("Status");
				String EngineerId = rSet.getString("EngineerId");
				
				
				Problem p = new Problem(complainid,ProblemName,category,Status,EngineerId);
				problems.add(p);
				
				
			}
			if(!rSet.next())
			{
				System.out.println("Probme database is empty...");
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return problems;
		
	}


	@Override
	public String AssignToEngineer(int complainid, String EngineerID) {
		// TODO Auto-generated method stub
		
       String meString = "Somethink went wrong in assigning..";
		
		try (Connection conn = connection__.provideConnection()){
			
			PreparedStatement pt = conn.prepareStatement("update problems set engineerID = ? where complainid = ?");
			pt.setString(1, EngineerID);
			pt.setInt(2, complainid);
			int x = pt.executeUpdate();
			if(x>0) {
				meString = EngineerID+" assigned to "+ complainid +" problem";
				System.out.println(meString);
			}else {
				System.out.println(meString);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		
		return meString;
		
		
		
	}
	
	
	
	
	
	

}
