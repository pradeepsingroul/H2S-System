package H2S_Application.MethodImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.function.IntBinaryOperator;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

import H2S_Application.Dao_Uility.connection__;
import H2S_Application.MethodInterface.EmployeeInterface;
import H2S_Application.ModelClasses.Problem;

public class EmployeeImplementation implements EmployeeInterface{

	@Override
	public String RegisterAsEmployee(String EmployeeID, String Name, String Email, String password) {
		String message = "";
		
		try( Connection connection = connection__.provideConnection()) {
			
			PreparedStatement pt = connection.prepareStatement("insert into employees values(?,?,?,?)");
			pt.setString(1, EmployeeID);
			pt.setString(2, Name);
			pt.setString(3, Email);
			pt.setString(4, password);
			
			int x = pt.executeUpdate();
			if(x>0) {
				message = "Employee succesfuly register....";
				System.out.println(message);
			}else {
				message = "You have enter somethink wrong details";
				System.out.println(message);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		return message;
	}

	@Override
	public String LiginAsEmployee(String email, String password) {
		String message = "";
		
        try( Connection connection = connection__.provideConnection()) {
			
			PreparedStatement pt = connection.prepareStatement("select * from employees where username = ? AND password = ?");
			pt.setString(1, email);
			pt.setString(2, password);
			
			ResultSet rSet = pt.executeQuery();
			if(rSet.next()) {
				message = "Welcome"+rSet.getString("Name");
				System.out.println(message);
			}else {
				message = "Employee deosn't exits with "+email;
				System.out.println(message);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return message;
	}

	@Override
	public String raiseProblem(String problemName, String Category, String status, String EmployeeID) {
		
		String prblmString = "Problem can't raise...";
		
		try (Connection connection  = connection__.provideConnection()){
			
			PreparedStatement pr = connection.prepareStatement("insert into problems (problem,category,status,EmployeeID) values(?,?,?,?)");
			
			pr.setString(1, problemName);
			pr.setString(2, Category);
			pr.setString(3, status);
			pr.setString(4, EmployeeID);
			
			int x = pr.executeUpdate();
			if(x>0) {
				prblmString = "Registe successfull...";
				System.out.println("Register successful....");
			}else {
				prblmString = "you have entered somethink wrong credential";
				System.out.println(prblmString);
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return prblmString;
		
		
	}

	@Override
	public String checkStatus(int complainId,String EmployeeId) {
		
		String message = "";
		
       try (Connection connection  = connection__.provideConnection()){
			
			PreparedStatement pr = connection.prepareStatement("Select * from problems p INNER JOIN employees e ON p.employeeId = e.employeeID AND p.employeeId = ? and p.complainId = ?");
			
			pr.setString(1, EmployeeId);
			pr.setInt(2, complainId);
			
			
			ResultSet x = pr.executeQuery();
			if(x.next()) {
				
				message = "your problem Assigned to "+x.getString("EngineerID");
				System.out.println(message);
				
			}else {
			
				message = "you didn't raise any problems....";
				System.out.println(message);
				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		
		
		return message;
	}

}
