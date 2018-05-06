package app_files;

import java.util.ArrayList;
import java.util.List;

public class TimeRegApp {

	public boolean userLoggedIn = true;
	private List<Resource> resources = new ArrayList<>();
	private List<Project> projects = new ArrayList<>();
	private List<WorkPlanned> workplanned = new ArrayList<>();
	public int indexUsername;
	
	public boolean userLoggedIn() {
		return userLoggedIn;
	}
	
	public void addWorkPlanned(WorkPlanned WorkPlanned) {
		workplanned.add(WorkPlanned);
	}
	
	public List<Resource> getResources() {
		return resources;
	}
	
	public int getIndexUsername() {
		return indexUsername;
	}
	
	public void addResource(Resource newUser) {
		resources.add(newUser);
	}
	
	public void addProject(Project newProject) {
		projects.add(newProject);
	}
	
	public boolean userLogin(String inputInitials, String inputPassword) {
		for (Resource resource : resources) {
			if(inputInitials.equals(resource.getId())) {
				indexUsername =  getResources().indexOf(resource);
			} else {
				userLoggedIn = false;
			}
		}
		
		if (inputPassword.equals(resources.get(indexUsername).getPassword())) {
			userLoggedIn = true;
		}
		
		return userLoggedIn();
	}
}
