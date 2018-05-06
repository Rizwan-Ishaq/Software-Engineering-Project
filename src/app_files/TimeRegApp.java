package app_files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app_files.Project;

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
	public String addWorkPlanned(WorkPlanned WorkPlanned) {
		// Check of parameter legality
		if (getProject(WorkPlanned.getProjectId()) == null) { // wbt 010

			return "Error: Project does not exist";
			// throw new IllegalArgumentException("Project doesn't exist.");
		}

		if (getActivity(WorkPlanned.getProjectId(), WorkPlanned.getActivityId()) == null) { // wbt 020

			// System.out.println("ERROR: Activity does not exist or isn't assigned to
			// project");

			return "Error: Activity does not exist or isn't assigned to project";
			// throw new IllegalArgumentException("Activity doesn't exist.");
		}

		if (getResource(WorkPlanned.getResourceId()) == null) { // wbt 030

			// System.out.println("ERROR: Resource does not exist. ");

			return "Error: Resource does not exist.";
			// throw new IllegalArgumentException("Employee doesn't exist.");
		}

		// Check if resource is booked for the time being
		// If end time is before start time, and it's true that start time is after end
		// time of comparable then resource is free.
		// written as NOT

		if (WorkPlanned.getEndWeek() < WorkPlanned.getStartWeek()) { // wbt 040

			System.out.println("ERROR: Your project ends before it starts.");

			return "Error: Your project ends before it starts.";
		}

		Boolean resourceAvailable = true;

		for (int i = 0; i < workplannedlist.size(); i++) { // wbt 050
			if (WorkPlanned.getResourceId().equals(workplannedlist.get(i).getResourceId())) { // wbt 060
				if (!(WorkPlanned.getEndWeek() < workplannedlist.get(i).getStartWeek() // wbt 070
						|| WorkPlanned.getStartWeek() > workplannedlist.get(i).getEndWeek())) {

					resourceAvailable = false;
					// System.out.println(
					// "ERROR: Resource is not available in the given timeframe, and WorkPlanned
					// will not be added.");
					return "Error: Resource is not available in the given timeframe, end WorkPlanned will not be added";

				}

			}
		}

		if (resourceAvailable) { // wbt 080
			// System.out.println("Success: Scheduled work has been added for the
			// resource");
			workplannedlist.add(WorkPlanned);
			return "Succes: Scheduled work has been added for the resource";
		}
		return "We should've never reached this part of the galaxy lord vader";

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
