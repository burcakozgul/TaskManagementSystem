package ManagementSystem;

import java.util.Date;

public class Task {
	private int id;
	private String name;
	private int userId;
	private TaskStatus status;
	private TaskPriority priority;
	private Date updateDate;
	
	public Task(int id, String name, int userId, TaskStatus status, TaskPriority priority) {
		this.id = id;
		this.name = name;
		this.userId = userId;
		this.status = status;
		this.priority = priority;
		this.updateDate = new Date();
	}
	@Override
	public String toString() {
		return new StringBuilder()
				.append("Task id = ")
				.append(id)
				.append(" {userId = ")
				.append(userId)
				.append(", name = ")
				.append(name)
				.append(", status = ")
				.append(status)
				.append(", priority = ")
				.append(priority)
				.append(", updateDate = ")
				.append(updateDate)
				.append("}")
				.toString();
	}
	
	public int getUser() {
		return userId;
	}
	public void setUser(int userId) {
		this.userId = userId;
		updateDate = new Date();
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
		updateDate = new Date();
	}
	public TaskPriority getPriority() {
		return priority;
	}
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
		updateDate = new Date();
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

}
