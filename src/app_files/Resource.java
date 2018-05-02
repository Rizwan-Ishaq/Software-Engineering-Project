package app_files;

public class Resource {
	
	private String id;
	private String fullName;
	private boolean available;
	
	public Resource(String initials, String fullName) {
		this.id = initials;
		this.setFullName(fullName);
		this.available = true; 
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
}
