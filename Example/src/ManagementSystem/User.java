package ManagementSystem;

public class User {
	private int id;
	private String name;
	private UserType type;
	
	public User(int id, String name, UserType type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public UserType getType() {
		return type;
	}
	@Override
	public String toString() {
		return new StringBuilder()
				.append("User{")
				.append("name = ")
				.append(name)
				.append(", type = ")
				.append(type)
				.append("}")
				.toString();
	}
}
