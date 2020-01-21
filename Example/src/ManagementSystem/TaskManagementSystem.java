package ManagementSystem;

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

	public void createUser(String name, UserType type) {
		int id = users.size();
		users.put(id, new User(id, name, type));
		System.out.println(users.get(id));
	}

	public void createTask(String name, int userId, TaskStatus status, TaskPriority priority) throws TaskException {
		if (users.isEmpty()) throw new TaskException(TypeError.NO_USER);
		else if (!users.containsKey(userId)) throw new TaskException(TypeError.NO_USER_WITH_ID);
		int id = tasks.size();
		tasks.put(id, new Task(id, name, userId, status, priority));
		System.out.println(tasks.get(id));
	}

	public void getAllUsers() throws TaskException {
		if (users.isEmpty()) throw new TaskException(TypeError.NO_USER);

		for (Map.Entry<Integer, User> e : users.entrySet()) {
			System.out.println(e.getValue());
		}
	}

	public void getAllTasks() throws TaskException {
		if (tasks.isEmpty()) throw new TaskException(TypeError.NO_TASK);

		for (Map.Entry<Integer, Task> e : tasks.entrySet()) {
			System.out.println(e.getValue());
		}
	}

	public void updateUser(int id, int userId) throws TaskException {
		if (!tasks.containsKey(id)) throw new TaskException(TypeError.NO_TASK_WITH_ID);

		Task task = tasks.get(id);
		task.setUser(userId);
		System.out.println(task);
	}

	public void updateStatus(int id, TaskStatus status) throws TaskException {
		if (!tasks.containsKey(id)) throw new TaskException(TypeError.NO_TASK_WITH_ID);

		Task task = tasks.get(id);
		task.setStatus(status);
		System.out.println(task);
	}

	public void updatePriority(int id, TaskPriority priority) throws TaskException {
		if (!tasks.containsKey(id)) throw new TaskException(TypeError.NO_TASK_WITH_ID);

		Task task = tasks.get(id);
		task.setPriority(priority);
		System.out.println(task);
	}

	public User getUserbyId(int i) {
		return users.get(i);
	}

}
