package ManagementSystem;


public class ManagementSystemMain {
	public static void main(String[] args) {
		TaskManagementSystem tms = TaskManagementSystem.getIntsance();
		tms.createUser(1, "Burcak", UserType.DEVELOPER);
		tms.createUser(2, "Ahmet", UserType.DEVELOPER);
		tms.createUser(3, "Sule", UserType.DEVELOPER);
		tms.createUser(4, "Canan", UserType.ANALYST);
		tms.createUser(5, "Sabiha",UserType.ANALYST);
		tms.createUser(6, "Gokce", UserType.TESTER);
		tms.createTask(1, "PAYE", tms.getUserbyId(1), TaskStatus.ANALYSIS, TaskPriority.HIGH );
		tms.createTask(2, "NETMERA", tms.getUserbyId(3), TaskStatus.DEVELOPMENT, TaskPriority.HIGH );
		tms.createTask(3, "ADJUST", tms.getUserbyId(2), TaskStatus.TEST, TaskPriority.HIGH );
		tms.createTask(4, "BURGER KING", tms.getUserbyId(5), TaskStatus.DEVELOPMENT, TaskPriority.HIGH );
		tms.createTask(5, "FINANCELL", tms.getUserbyId(4), TaskStatus.TEST, TaskPriority.HIGH );
		tms.updatePriority(5, TaskPriority.LOW);
		tms.updateStatus(4, TaskStatus.TEST);
		tms.updateUser(2, tms.getUserbyId(2));
	}
}
