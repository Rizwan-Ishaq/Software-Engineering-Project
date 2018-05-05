package app_files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TimeRegApp {

	private boolean userLoggedIn = false;
	private List<Resource> resourcelist = new ArrayList<>();
	public List<Project> projectlist = new ArrayList<>();
	private List<WorkPlanned> workplannedlist = new ArrayList<>();
	private List<Activity> activitylist = new ArrayList<>();

	// testpurposes
	Boolean standAloneTest = true;

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

		if (getActivity(WorkPlanned.getProjectId(), WorkPlanned.getActivityId()).equals(null)) {

			throw new IllegalArgumentException("Activity doesn't exist.");
		}

		if (getResource(WorkPlanned.getResourceId()).equals(null)) {

			throw new IllegalArgumentException("Employee doesn't exist.");
		}

		// Check if resource is booked for the time being
		// If end time is before start time, and it's true that start time is after end time of comparable then resource is free.
		// written as NOT
		Boolean resourceAvailable = true;

		for (int i = 0; i < workplannedlist.size(); i++) {
			if (WorkPlanned.getResourceId() == workplannedlist.get(i).getResourceId()) {
				if (!(WorkPlanned.getEndWeek() < workplannedlist.get(i).getStartWeek())
						&& !(WorkPlanned.getStartWeek() > workplannedlist.get(i).getEndWeek())) {

					resourceAvailable = false;

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

	public Activity getActivity(String projectId, String activityId) {

		if (standAloneTest = true) {

			if (activityId.substring(0, 1) == "A") {
				return null;
			} else {
				Activity activity = new Activity("Testesttest", "Tsettsettsettset", 100, 3, 5);
				return activity;
			}

		} else {

			for (int i = 0; i < activitylist.size(); i++) {
				if (activitylist.get(i).getActId().equals(activityId)
						&& activitylist.get(i).getProjId().equals(projectId)) {
					return activitylist.get(i);
				}
			}
			return null;
		}
	}

	public Resource getResource(String resourceId) {

		if (standAloneTest = true) {

			if (resourceId.substring(0, 1) == "A") {
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
