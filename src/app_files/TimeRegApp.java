package app_files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeRegApp {

	private boolean userLoggedIn = false;
	public List<Resource> resourcelist = new ArrayList<>();
	public List<Project> projectlist = new ArrayList<>();
	public List<WorkPlanned> workplannedlist = new ArrayList<>();
	public List<Activity> activitylist = new ArrayList<>();

	public List getActivityList() {
		return activitylist;
	}

	// testpurposes
	Boolean standAloneTest = false;

	public boolean userLoggedIn() {
		return userLoggedIn;
	}

	public void registerResource(Resource resource) throws Exception {
		if (resourcelist.contains(resource)) {
			throw new Exception("User is already registered");
		}
		resourcelist.add(resource);
	}

	// StefanAndersen Test
	/*
	 * public void whatever() {
	 * 
	 * WorkPlanned work1 = new WorkPlanned(this, "hej", "med", 15, 17, 1);
	 * WorkPlanned work2 = new WorkPlanned(this, "ohhhboy", "awwjeez", 14, 19,
	 * 99941);
	 * 
	 * TimeRegApp fjols = new TimeRegApp(); fjols.addWorkPlanned(work1);
	 * fjols.addWorkPlanned(work2); fjols.printList(); }
	 */

	// StefanAndersen
	public void addWorkPlanned(WorkPlanned WorkPlanned) {
		// Check of parameter legality
		if (getProject(WorkPlanned.getProjectId()) == null) {

			System.out.println("ERROR: Project does not exist");
			
			return;
			// throw new IllegalArgumentException("Project doesn't exist.");
		}

		if (getActivity(WorkPlanned.getProjectId(), WorkPlanned.getActivityId()) == null) {

			System.out.println("ERROR: Activity does not exist");
			
			return;
			// throw new IllegalArgumentException("Activity doesn't exist.");
		}

		if (getResource(WorkPlanned.getResourceId()) == null) {

			System.out.println("ERROR: Resource does not exist. ");
			
			return;
			// throw new IllegalArgumentException("Employee doesn't exist.");
		}

		// Check if resource is booked for the time being
		// If end time is before start time, and it's true that start time is after end
		// time of comparable then resource is free.
		// written as NOT
		Boolean resourceAvailable = true;

		for (int i = 0; i < workplannedlist.size(); i++) {
			if (WorkPlanned.getResourceId().equals(workplannedlist.get(i).getResourceId())) {
				if (!(WorkPlanned.getEndWeek() < workplannedlist.get(i).getStartWeek()
						|| WorkPlanned.getStartWeek() > workplannedlist.get(i).getEndWeek())) {

					resourceAvailable = false;
					System.out.println(
							"ERROR: Resource is not available in the given timeframe, and WorkPlanned will not be added.");

				}

			}
		}

		if (resourceAvailable) {
			workplannedlist.add(WorkPlanned);
		}

	}

	// StefanAndersen
	public void addActivity(Activity Activity) {
		activitylist.add(Activity);
	}

	// StefanAndersen
	public void addProject(Project Project) {
		projectlist.add(Project);
	}

	public void addResource(Resource Resource) {
		resourcelist.add(Resource);
	}

	// StefanAndersen
	public List<WorkPlanned> getListofWorkPlanned() {
		return Collections.unmodifiableList(workplannedlist);
	}

	// StefanAndersen
	public Project getProject(String projectId) {
		// Method returns project object if exists or else Null
		System.out.println("x004");

		if (standAloneTest) {
			if (projectId.substring(0, 1).equals("A")) {
				return null;
			} else {
				Project project = new Project("RickSanchez");
				return project;
			}

		} else {
			for (int i = 0; i < projectlist.size(); i++) {
				System.out.println("x003");
				if (projectlist.get(i).getId().equals(projectId)) {
					return projectlist.get(i);
				}
			}

		}
		return null;

	}

	public Activity getActivity(String projectId, String activityId) {

		if (standAloneTest) {

			if (activityId.substring(0, 1).equals("A")) {
				return null;
			} else {
				Activity activity = new Activity("Testesttest", "Tsettsettsettset", 100, 3, 5);
				return activity;
			}

		} else {
			System.out.println("x001 " + projectId + " " + activityId);
			for (int i = 0; i < activitylist.size(); i++) {
				System.out.println(activitylist.get(i).getActId() + " " + activitylist.get(i).getProjId());
				if (activitylist.get(i).getActId().equals(activityId)
						&& activitylist.get(i).getProjId().equals(projectId)) {
					return activitylist.get(i);
				}
			}
			return null;
		}
	}

	public Resource getResource(String resourceId) {

		if (standAloneTest) {

			if (resourceId.substring(0, 1).equals("A")) {
				return null;
			} else {
				Resource resource = new Resource("StefanAndersen", "SSA", "hubert");
				return resource;
			}

		} else {

			for (int i = 0; i < resourcelist.size(); i++) {
				if (resourcelist.get(i).getId().equals(resourceId)) {
					return resourcelist.get(i);
				}
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
