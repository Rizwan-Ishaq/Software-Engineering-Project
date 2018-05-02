package app_files;

import java.util.ArrayList;
import java.util.List;

public class TimeRegApp {

	private boolean userLoggedIn = false;
	private List<Resource> resources = new ArrayList<>();
	private List<Project> project = new ArrayList<>();
	
	public boolean userLoggedIn() {
		return userLoggedIn;
	}
}
