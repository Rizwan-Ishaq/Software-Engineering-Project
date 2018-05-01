package app_files;

public class Resource {
	
	private String id;
	private boolean available;
	
	public Resource(String initials) {
		this.id = initials;
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
}
