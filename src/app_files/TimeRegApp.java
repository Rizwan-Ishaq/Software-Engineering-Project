package app_files;

import java.util.ArrayList;
import java.util.List;

public class TimeRegApp {

	public boolean userLoggedIn = false;
	private List<Resource> resourcelist = new ArrayList<>();
	private List<Project> projectlist = new ArrayList<>();
	private List<WorkPlanned> workplannedlist = new ArrayList<>();
	private List<Activity> activitylist = new ArrayList<>();
	public int indexUsername;
	
	public List getActivityList() {
		return activitylist;
	}
	
	public boolean userLoggedIn() {
		return userLoggedIn;
	}
	
	public void registerResource(Resource resource) throws Exception {
		if (resourcelist.contains(resource)) {
			throw new Exception("User is already registered");
		}
		resourcelist.add(resource);
	}
	
	public void addWorkPlanned(WorkPlanned WorkPlanned) {
		workplannedlist.add(WorkPlanned);
	}
	
	public List<Resource> getResources() {
		return resourcelist;
	}
	
	public int getIndexUsername() {
		return indexUsername;
	}
	
	public void addResource(Resource newUser) {
		resourcelist.add(newUser);
	}
	
	public void addProject(Project newProject) {
		projectlist.add(newProject);
	}
	
	public boolean userLogin(String inputInitials, String inputPassword) {
		for (Resource resource : resourcelist) {
			if(inputInitials.equals(resource.getId())) {
				indexUsername =  getResources().indexOf(resource);
			} else {
				userLoggedIn = false;
			}
		}
		
		if (inputPassword.equals(resourcelist.get(indexUsername).getPassword())) {
			userLoggedIn = true;
		}
		
		return userLoggedIn();
	}
}
