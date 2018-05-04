package app_files;

import java.util.ArrayList;
import java.util.List;


public class TimeRegApp {

	private boolean userLoggedIn = false;
	private List<Resource> resources = new ArrayList<>();
	private List<Project> project = new ArrayList<>();
	private List<WorkPlanned> workplanned = new ArrayList<>();
	
	public boolean userLoggedIn() {
		return userLoggedIn;
	}

//	public void registerResource(Resource resource) throws Exception {
//		if (resources.contains(resource)) {
//			throw new Exception("User is already registered");
//		}
//		resources.add(resource);		
//	}
	
	public void addWorkPlanned(WorkPlanned WorkPlanned) {
		workplanned.add(WorkPlanned);
	}
	
	
}
