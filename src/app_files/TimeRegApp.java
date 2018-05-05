package app_files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeRegApp {

	private boolean userLoggedIn = false;
	private List<Resource> resources = new ArrayList<>();
	public List<Project> projectlist = new ArrayList<>();
	private List<WorkPlanned> workplannedlist = new ArrayList<>();
	private List<Activity> activitylist = new ArrayList<>();

	Boolean standAloneTest = true;

	public boolean userLoggedIn() {
		return userLoggedIn;
	}

	public void registerResource(Resource resource) throws Exception {
		if (resources.contains(resource)) {
			throw new Exception("User is already registered");
		}
		resources.add(resource);
	}

	// StefanAndersen Test
	public void whatever() {

		WorkPlanned work1 = new WorkPlanned(this, "hej", "med", 15, 17, 1);
		WorkPlanned work2 = new WorkPlanned(this, "ohhhboy", "awwjeez", 14, 19, 99941);

		TimeRegApp fjols = new TimeRegApp();
		fjols.addWorkPlanned(work1);
		fjols.addWorkPlanned(work2);
		fjols.printList();
	}

	// StefanAndersen
	public void addWorkPlanned(WorkPlanned WorkPlanned) {

		// Check of parameter legality
		if (getProject(WorkPlanned.getProjectId()).equals(null)) {

			throw new IllegalArgumentException("Project doesn't exist.");
		}
		
		if (getActivity(WorkPlanned.getActivityId()).equals(null)) {

			throw new IllegalArgumentException("Activity doesn't exist.");
		}
		
		if (getResource(WorkPlanned.getResourceId()).equals(null)) {

			throw new IllegalArgumentException("Employee doesn't exist.");
		}

		workplannedlist.add(WorkPlanned);
	}

	// StefanAndersen
	public void addActivity(Activity Activity) {
		activitylist.add(Activity);
	}

	// StefanAndersen
	public List<WorkPlanned> getListofWorkPlanned() {
		return Collections.unmodifiableList(workplannedlist);
	}

	// StefanAndersen
	public Project getProject(String projectId) {
		// Method returns project object if exists or else Null

		if (standAloneTest = true) {

			if (projectId.substring(0, 1) == "A") {
				return null;
			} else {
				Project project = new Project("RickSanchez");
				return project;
			}

		} else {

			for (int i = 0; i < projectlist.size(); i++) {
				if (projectlist.get(i).getId().equals(projectId)) {
					return projectlist.get(i);
				}
			}
			
		}
		return null;

	}
	
	public Activity getActivity(String activityId) {
		
		for ( int i = 0; i < activitylist.size(); i++) {
			if (activitylist.get(i).getActId().equals(activityId)) {
				return activitylist.get(i);
			}
		}
		return null;
		
	}

	// StefanAndersen
	public void printList() {
		for (int i = 0; i < workplannedlist.size(); i++) {
			WorkPlanned work = workplannedlist.get(i);
			System.out.print(work.getActivityId() + " " + work.getProjectId() + " " + work.getStartWeek() + " "
					+ work.getEndWeek());
			System.out.println();
		}
	}

}
