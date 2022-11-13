package H2S_Application.MainExecution;

import java.util.List;
import java.util.Scanner;

import H2S_Application.MethodImplementation.EmployeeImplementation;
import H2S_Application.MethodImplementation.EngineersImplementaion;
import H2S_Application.MethodImplementation.HodImpl;
import H2S_Application.MethodInterface.EmployeeInterface;
import H2S_Application.MethodInterface.EngineersInterface;
import H2S_Application.MethodInterface.HodInterfaces;
import H2S_Application.ModelClasses.AttendedProblems;
import H2S_Application.ModelClasses.Engineer;
import H2S_Application.ModelClasses.Problem;

public class Methods {
	
	

	public static void main(String[] args) {
		
		System.out.println("If you are an HOD Enter ::::: 1");
		System.out.println("If you are an Engineer  Enter ::::: 2");
		System.out.println("If you are an Employee  Enter ::::: 3");
		
		Scanner scanner = new Scanner(System.in);
		int argument = scanner.nextInt();
		
		switch (argument){
		
		 case 1 : {
			
			System.out.print("Enter your Email : ");
			String Email = scanner.nextLine();
			
			System.out.print("Enter your Password : ");
			String password = scanner.nextLine();
			
			HodInterfaces apni = new HodImpl();
			apni.HOD_Login(Email, password);
			
			
			while(true) {
				
				System.out.println("=================================================================");
				System.out.println("LogOut : if you want to logout your account press : 0");
				System.out.println("Registraion : If you want to Register an Engineer to your System Enter --->  1");
				System.out.println("See Engineers : If you want to See all Engineers then Enter --->  2");
				System.out.println("Delete Engineer : If you want to Delete Particular Engineers then Enter --->  3");
				System.out.println("See All Problems : If you want to See all the Raised problems then Enter --->  4");
				System.out.println("Assign Problem : If you want to Assign an Engineers to a problem Enter --->  5");
				System.out.println("==================================================================");
				
				
				
				scanner.nextLine();
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==0) {
					System.out.println("Logout siccesfull...");
					break;
				}
				
				else {
				  switch (key) {
				    
					case 1: {
						System.out.print("Enter  engineerId :");
						String engineerId = scanner.nextLine();
						System.out.print("Enter  name :");
						String name = scanner.nextLine();
						System.out.print("Enter  EmailEng :");
						String EmailEng = scanner.nextLine();
						System.out.print("Enter Password :");
						String Password = scanner.nextLine();
						System.out.print("Enter category :");
						String category = scanner.nextLine();
						
						HodInterfaces h1 = new HodImpl();
						h1.registerIntoEngineerString(engineerId, name, EmailEng, Password, category);
						
						
					    break;
						
					}
					case 2: {
						HodInterfaces h1 = new HodImpl();
						List<Engineer> e1 = h1.getEngineerData();
						
						e1.forEach(s -> System.out.println(s));
						
						
						break;
						
						
					}
					case 3: {
						
						System.out.print("Enter EngineerId which yuo want to delete :");
						String Eid = scanner.nextLine();
						HodInterfaces h1 = new HodImpl();
						h1.deleteengineerS(Eid);
					
						break;
						
					}
					case 4: {
						HodInterfaces h1 = new HodImpl();
						List<Problem> p1 = h1.getProblembsDetails();
						
						p1.forEach(s -> System.out.println(s));
						
						
						break;
						
						
					}
					case 5: {
						System.out.print("Enter EngineerId which you want to assgign : ");
						String engineerId = scanner.nextLine();
						System.out.print("Enter complainId : ");
						int complainid = scanner.nextInt();
						
						HodInterfaces h1 = new HodImpl();
						h1.AssignToEngineer(complainid, engineerId);
						
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + key);
					}
				}
				
			}
			break;
			
		}
		case 2 :{
			
			
            while(true) {
            	
            	System.out.println("==============================================");
        		System.out.println("For LogOut : Press - 0");
            	System.out.println("For Login Another account press = 6");
		
				System.out.println("for See Assigned problems : press -7");
				System.out.println("for Update status : press - 8");
				System.out.println("for see Attented problems : press - 9");
				System.out.println("For change their password : press - 10");
				System.out.println("==============================================");
				
				
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==0) {
					System.out.println("Logout succesfull..");
					break;
				}
				
				else {
				  switch (key) {
				    case 6:{
				    	System.out.print("Enter your Email : ");
						String Email = scanner.nextLine();
						
						System.out.print("Enter your Password : ");
						String password = scanner.nextLine();
						
						EngineersInterface apni = new EngineersImplementaion();
						apni.LoginAsEngineer(Email, password);
				    	break;
				    }
					case 7: {
						
						System.out.print("Enter your engineerId : ");
						String engineerId = scanner.nextLine();
						EngineersInterface eng = new EngineersImplementaion();
						List<Problem> prList = eng.GetAssignedProblems(engineerId);
						prList.forEach(e -> System.out.println(e));
					    break;
						
					}
					case 8: {
						
						System.out.print("Enter your EngineerId : ");
						String engineerId = scanner.nextLine();
						
						System.out.print("Enter your complainId : ");
						int complainId = scanner.nextInt();
						scanner.nextLine();
						System.out.print("Enter Status which you want to set : ");
						String status = scanner.nextLine();
						
						EngineersInterface e1  = new EngineersImplementaion();
						e1.UpdateStatus(status, complainId , engineerId);
						
						break;
						
						
					}
					case 9: {
						
						System.out.print("Enter your engineerId : ");
						String engineerId = scanner.nextLine();
						EngineersInterface eng = new EngineersImplementaion();
						List<AttendedProblems> AtList = eng.getAttendedProblems(engineerId);
						AtList.forEach(e -> System.out.println(e));
					    break;
						
						
					}
					case 10: {
						System.out.print("Enter your email whose password you want to change : ");
						String email = scanner.nextLine();
						System.out.print("Enter your Old Password : ");
						String oldPasssword = scanner.nextLine();
						System.out.print("Enter your New password : ");
						String newPassword = scanner.nextLine();
						
						EngineersInterface e1 = new EngineersImplementaion();
						e1.ChangePassword(email, oldPasssword, newPassword);
						
						
						break;
						
						
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + key);
					}
				}
				
			}
            break;
			 
		}
		case 3:{
			
			
            while(true) {
            	
            	System.out.println("==============================================");
            	System.out.println("For LogOut : Press - 0");
            	System.out.println("For Registration  press = 11");
            	System.out.println("For Login  account press = 12");
            	System.out.println("For Raise problem or complain press = 13");
            	System.out.println("For Problem Status press = 14");
            	System.out.println("Check complain History press = 15");
            	System.out.println("Change your password = 16");
				System.out.println("==============================================");
				
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==0) {
					
			       					
					System.out.println("Logout succesfull..");
					break;
				}
				
				else {
				  switch (key) {
				    case 11:{
				    	System.out.print("Enter your EmployeeID : ");
						String EmployeeID = scanner.nextLine();
						
						System.out.print("Enter your Name : ");
						String Name = scanner.nextLine();
						
						System.out.println("Enter you emailID");
                        String emailID = scanner.nextLine();
						
						System.out.print("Enter your Password : ");
						String password = scanner.nextLine();
						
						EmployeeInterface apni = new EmployeeImplementation();
						apni.RegisterAsEmployee(EmployeeID, Name, emailID, password);
				    	break;
				    }
					case 12: {
						
						System.out.print("Enter your Email : ");
						String Email = scanner.nextLine();
						
						System.out.print("Enter your Password : ");
						String password = scanner.nextLine();
						
						EmployeeInterface apni = new EmployeeImplementation();
						apni.LiginAsEmployee(Email, password);
				    	break;
						
					}
					case 13: {
						
						System.out.print("Enter your problemName : ");
						String problemName = scanner.nextLine();
						
						System.out.print("Enter your category : ");
						String category = scanner.nextLine();
						
						System.out.print("Enter your Status : ");
						String Status = scanner.nextLine();
						
						System.out.print("Enter your EmployeeID : ");
						String EmployeeID = scanner.nextLine();
						
						
						EmployeeInterface e1  = new EmployeeImplementation();
						e1.raiseProblem(problemName, category, Status, EmployeeID);
						
						break;
						
						
					}
					case 14: {
						
						System.out.print("Enter your EmployeeID : ");
						String  EmployeeID = scanner.nextLine();
						
						System.out.print("Enter your ComplainId : ");
						int ComplainId = scanner.nextInt();

						EmployeeInterface e1  = new EmployeeImplementation();
						e1.checkStatus(ComplainId,EmployeeID);
						
						break;
						
					}
					case 15: {
						System.out.println("Enter your EmployeeID :");
						String employeeID = scanner.nextLine();
						
						EmployeeInterface e = new EmployeeImplementation();
						List<Problem> lstList=e.ComplainHistory(employeeID);
						lstList.forEach(s->System.out.println(s));
						
						
						break;
						
						
					}
					case 16: {
						System.out.print("Enter your email whose password you want to change : ");
						String email = scanner.nextLine();
						System.out.print("Enter your Old Password : ");
						String oldPasssword = scanner.nextLine();
						System.out.print("Enter your New password : ");
						String newPassword = scanner.nextLine();
						
						EmployeeInterface e1 = new EmployeeImplementation();
						e1.changePassword(email,oldPasssword,newPassword);
					    break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + key);
					}
				}
				
			}
            break;
			 
		}
		
		
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + argument);
			
		}
		
		
		
		
		
	}

}
