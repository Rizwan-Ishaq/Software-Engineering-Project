package app_files;

public class Resource {
	//
	private String id;
	private String fullName;
	private String password;
	private boolean available;
	
	public Resource(String fullName, String initials, String password) {
		this.id = initials;
		this.fullName = fullName;
		this.password = password;
		this.available = true; 
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
