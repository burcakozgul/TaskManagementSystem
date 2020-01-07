package ManagementSystem;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TaskManagementSystem {
	private static TaskManagementSystem INSTANCE = new TaskManagementSystem();
	private Map<Integer, User> users;
	private Map<Integer, Task> tasks;
	
	public static TaskManagementSystem getIntsance() {
		return INSTANCE;
	}
	
	private TaskManagementSystem() {
		users = new HashMap<>();
		tasks = new HashMap<>();
	}
	
	public void createUser(int id,String name, UserType type) {
		if(users.containsKey(id)) {
			System.out.println("Bu id'e sahip kullanici var.");
			return;
		}
		
		users.put(id, new User(id, name, type));
		System.out.println(users.get(id));
	}
	
	public void createTask(int id,String name,User user, TaskStatus status,TaskPriority priority ) {
		if(tasks.containsKey(id)) {
			System.out.println("Bu id'e sahip task var.");
			return;
		}

		tasks.put(id, new Task(id, name, user, status, priority));
		System.out.println(tasks.get(id));

	}
	
	public void getAllTasks() {
		if (tasks.isEmpty()) {
			System.out.println("Task Yok");
			return;
		}

		for(Map.Entry<Integer, Task> e:tasks.entrySet()) {
			System.out.println(e.getValue());
		}	
	}
	
	public void updateUser(int id,User user) {
		if (!tasks.containsKey(id)) {
			System.out.println("Task yok");
			return;
		} 
		
		Task task = tasks.get(id);
		task.setUser(user);
		System.out.println(task);
	}
	
	public void updateStatus(int id,TaskStatus status) {
		if (!tasks.containsKey(id)) {
			System.out.println("Task yok");
			return;
		} 
		
		Task task = tasks.get(id);
		task.setStatus(status);
		System.out.println(task);
	}
	public void updatePriority(int id,TaskPriority priority) {
		if (!tasks.containsKey(id)) {
			System.out.println("Task yok");
			return;
		} 

		Task task = tasks.get(id);
		task.setPriority(priority);
		System.out.println(task);
	}

	public User getUserbyId(int i) {
		return users.get(i);
	}

}
