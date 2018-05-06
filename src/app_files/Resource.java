package app_files;

public class Resource {
	
	private String id;
	private String fullName;
	private String password;
	
	public Resource(String fullName, String initials, String password) {
		this.id = initials;
		this.fullName = fullName;
		this.password = password;

	}

	public String getFullName() {
		return fullName;
	}

	
	public String getId() {
		return id;
	}


	public String getPassword() {
		return password;
	}
	
}
