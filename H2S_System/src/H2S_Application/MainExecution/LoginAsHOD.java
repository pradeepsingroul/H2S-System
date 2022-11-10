package H2S_Application.MainExecution;

import java.util.List;
import java.util.Scanner;

import H2S_Application.MethodImplementation.HodImpl;
import H2S_Application.MethodInterface.HodInterfaces;
import H2S_Application.ModelClasses.Engineer;
import H2S_Application.ModelClasses.Problem;

public class LoginAsHOD {
	
	

	public static void main(String[] args) {
		
		System.out.println("If you want to 'login as HOD' than Enter ::::: 1");
		System.out.println("If you want to 'login as Enginee'r than Enter ::::: 2");
		System.out.println("If you want 'to Register as Employee' than Enter ::::: 3");
		
		Scanner scanner = new Scanner(System.in);
		int argument = scanner.nextInt();
		
		switch (argument){
		
		 case 1 : {
			
			System.out.print("Enter your Email : ");
			String Email = scanner.next();
			
			System.out.print("Enter your Password : ");
			String password = scanner.next();
			
			HodInterfaces apni = new HodImpl();
			apni.HOD_Login(Email, password);
			
			
			while(true) {
				
				System.out.println("====================================================================================");
				System.out.println("LogOut : if you want to logout your account press : 00000");
				System.out.println("Registraion : If you want to Register an Engineer to your System Enter --->  1");
				System.out.println("See Engineers : If you want to See all Engineers then Enter --->  2");
				System.out.println("Delete Engineer : If you want to Delete Particular Engineers then Enter --->  3");
				System.out.println("See All Problems : If you want to See all the Raised problems then Enter --->  4");
				System.out.println("Assign Problem : If you want to Assign an Engineers to a problem Enter --->  5");
				System.out.println("====================================================================================");
				
				
				
				int key = scanner.nextInt();
				scanner.nextLine();
				if(key==00000) {
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
						
						
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + key);
					}
				}
				
				
				
			}
			
			
			
			
		}
		case 2 :{
			
			
			
			 
		}
		
		
		
		
		
		
		
		
		
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + argument);
		}
		
		
	
		
		
		
		
		
	}

}
