package ManagementSystem;

import java.util.Scanner;


public class ManagementSystemMain {
	static TaskManagementSystem tms;
	public static void main(String[] args) {
		tms = TaskManagementSystem.getIntsance();
		
		tms.createUser("Burcak", UserType.DEVELOPER);
		tms.createTask("PAYE", 0, TaskStatus.ANALYSIS, TaskPriority.HIGH );
		
		Scanner scan = new Scanner(System.in);
		boolean a =true;
		while(a) {
			printMainMenu();
			switch(getUserIntInput(scan)){
				case 1:
					createUser(scan,tms);
					break;
				case 2:
					createTask(scan,tms);
					break;
				case 3:
					updateTaskPriorty(scan,tms);
					break;
				case 4:
					updateTaskStatus(scan,tms);
					break;
				case 5:
					updateTaskUser(scan, tms);
					break;
				case 6:
					a=false;
					System.out.println("Programdan çıkılıyor...");
					break;
				default:
					System.out.println("invalid value");
					break;		
			}
		}
	}
	private static void printMainMenu() {
		System.out.println("1-Create User");
		System.out.println("2-Create Task");
		System.out.println("3-Update Task Priority");
		System.out.println("4-Update Task Status");
		System.out.println("5-Update Task User");
		System.out.println("6-Exit");
		System.out.println("Please choose progress: ");
	}
	private static void createUser(Scanner scan, TaskManagementSystem tms) {
		
		try {
			System.out.println("Enter name: ");
			String name =scan.next();
			System.out.println("Enter user type: ");
			System.out.println("ANALYST, DEVELOPER, TESTER");
			String type = scan.next();
			tms.createUser(name, UserType.valueOf(type));
		} 
		catch (Exception e) {
 			System.out.println("Yalnış giriş yaptınız. Çıkışa yönlendiriliyorsunuz.");
 			System.out.println("---------------------------------------");
		}
	}
	private static void createTask(Scanner scan, TaskManagementSystem tms) {
		try {
			System.out.println("Enter task name: ");
			String name =scan.next();
			scan.nextLine();
			tms.getAllUsers();
			System.out.println("Enter user id: ");
			int userId = scan.nextInt();
			System.out.println("Enter task status: ");
			System.out.println("ANALYSIS, DEVELOPMENT, TEST");
			String status=scan.next();
			System.out.println("Enter priority status: ");
			System.out.println("LOW, MEDIUM, HIGH");
			String priority=scan.next();
			tms.createTask(name, userId, TaskStatus.valueOf(status), TaskPriority.valueOf(priority));
			
		} catch (Exception e) {
			System.out.println("Yalnış giriş yaptınız. Çıkışa yönlendiriliyorsunuz.");
 			System.out.println("---------------------------------------");
		}
	}
	private static void updateTaskPriorty(Scanner scan, TaskManagementSystem tms) {
		try {
			tms.getAllTasks();
			System.out.println("Enter task id: ");
			int taskId=scan.nextInt();
			System.out.println("Enter priority status: ");
			System.out.println("LOW, MEDIUM, HIGH");
			String priority=scan.next();
			tms.updatePriority(taskId, TaskPriority.valueOf(priority));
		} catch (Exception e) {
			System.out.println("Yalnış giriş yaptınız. Çıkışa yönlendiriliyorsunuz.");
 			System.out.println("---------------------------------------");
		}
		
	}
	private static void updateTaskStatus(Scanner scan, TaskManagementSystem tms) {
		try {
			tms.getAllTasks();
			System.out.println("Enter task id: ");
			int taskId=scan.nextInt();
			System.out.println("Enter task status: ");
			System.out.println("ANALYSIS, DEVELOPMENT, TEST");
			String status=scan.next();
			tms.updateStatus(taskId, TaskStatus.valueOf(status));
		} catch (Exception e) {
			System.out.println("Yalnış giriş yaptınız. Çıkışa yönlendiriliyorsunuz.");
 			System.out.println("---------------------------------------");
		}
		
	}
	private static void updateTaskUser(Scanner scan, TaskManagementSystem tms) {
		try {
			tms.getAllTasks();
			System.out.println("Enter task id: ");
			int taskId=scan.nextInt();
			tms.getAllUsers();
			System.out.println("Enter user id: ");
			int userId = scan.nextInt();
			tms.updateUser(taskId, userId);
		} catch (Exception e) {
			System.out.println("Yalnış giriş yaptınız. Çıkışa yönlendiriliyorsunuz.");
 			System.out.println("---------------------------------------");
		}
		
	}
	private static int getUserIntInput(Scanner scan) {
		try {
			return scan.nextInt();
		} catch (Exception e) {
			return -1;
		}
	}
	


	/*tms.createUser("Burcak", UserType.DEVELOPER);
	
	tms.createUser("Canan", UserType.ANALYST);
	tms.createUser("Sabiha",UserType.ANALYST);
	tms.createUser("Gokce", UserType.TESTER);
	tms.createTask("PAYE", 1, TaskStatus.ANALYSIS, TaskPriority.HIGH );
	tms.createTask("NETMERA",3, TaskStatus.DEVELOPMENT, TaskPriority.HIGH );
	tms.createTask("ADJUST", 2, TaskStatus.TEST, TaskPriority.HIGH );
	tms.createTask("BURGER KING", 5, TaskStatus.DEVELOPMENT, TaskPriority.HIGH );
	tms.createTask("FINANCELL", 4, TaskStatus.TEST, TaskPriority.HIGH );
	tms.updatePriority(4, TaskPriority.LOW);
	tms.updateStatus(4, TaskStatus.TEST);
	tms.updateUser(2, 2);*/
}