package app_files;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import app_files.Project;

public class TimeRegApp {

	public boolean userLoggedIn = false;
	public int indexUsername;
	public int indexResource;
	public List<Resource> resourcelist = new ArrayList<>();
	public List<Project> projectlist = new ArrayList<>();
	public List<WorkPlanned> workplannedlist = new ArrayList<>();
	public List<Activity> activitylist = new ArrayList<>();
	public List<TimeRegistration> timeregistrationlist = new ArrayList<>();
//	public List<SpecialActivityRegistration> specialactivityregistrationlist = new ArrayList<>();
	public List<TimeRegistration> usertimeregistrationlist = new ArrayList<>();
//	public List<SpecialActivityRegistration> userspecialactivityregistrationlist = new ArrayList<>();

	//StefanAndersen
	public List<Activity> getActivityList() {
		return activitylist;
	}

	// testpurposes
	Boolean standAloneTest = false;
	private String message;

	public boolean userLoggedIn() {
		return userLoggedIn;
	}
	
	//Author: Rizwan Ali Ishaq
	public void registerResource(Resource resource) throws Exception {
		if (resourcelist.contains(resource)) {
			throw new Exception("User is already registered");
		}
		resourcelist.add(resource);
	}
	
	//Author: Mohaiman Rahim, S174120
	public List<TimeRegistration> getTimeRegistrationList() {
		return timeregistrationlist;
	}
	
	//Author: Mohaiman Rahim, S174120
//		public List<SpecialActivityRegistration> getSpecialActivityRegistrationList() {
//			return specialactivityregistrationlist;
//	}
	
	//Author: Mohaiman Rahim, S174120
	public String registerTime(TimeRegistration timeRegistration) throws Exception {
		if (timeRegistration.getDay() > 7 || timeRegistration.getDay() < 1) {
			message = "Day out of bounds";
		} else if (timeRegistration.getWeek() > 52 || timeRegistration.getWeek() < 1) {
			message = "Week out of bounds";
		} else if (timeRegistration.getHoursWorked() > 24 || timeRegistration.getHoursWorked() < 1) {
			message = "Hours out of bounds";
		} else {	
			if (resourcelist.contains(timeRegistration.getResource())) {
				if (timeregistrationlist.size() == 0) {
					timeregistrationlist.add(timeRegistration);
					message = "Time is registered";
				} else {
					for (TimeRegistration timeRegistrationInList : timeregistrationlist) {
						if(timeRegistration.getResource().equals(timeRegistrationInList.getResource()) && 
								timeRegistration.getWeek()==timeRegistrationInList.getWeek() && 
								timeRegistration.getDay()==timeRegistrationInList.getDay()) {
							message = "Time registration already done for this user on that time";
						} else {
							timeregistrationlist.add(timeRegistration);
							message = "Time is registered";
						}
					}
				}
			} else {
				message = "User doesn't exist";
			}
		}
		return message;
	}
	
	//Author: Mohaiman Rahim, S174120
//		public void registerSpecialActivity(SpecialActivityRegistration specialActivityRegistration) throws Exception {
//			if (specialActivityRegistration.getStartDay() > 7 || specialActivityRegistration.getStartDay() < 1
//					|| specialActivityRegistration.getEndDay() > 7 || specialActivityRegistration.getEndDay() < 1) {
//				throw new Exception("Day out of bounds");
//			} else if (specialActivityRegistration.getStartWeek() > 52 || specialActivityRegistration.getStartWeek() < 1
//					|| specialActivityRegistration.getEndWeek() > 52 || specialActivityRegistration.getEndWeek() < 1) {
//				throw new Exception("Week out of bounds");
//			} else if (specialActivityRegistration.getStartWeek()==specialActivityRegistration.getEndWeek() && 
//					specialActivityRegistration.getStartDay() > specialActivityRegistration.getEndDay()) {
//				throw new Exception("Start day is after end day");
//			} else if (specialActivityRegistration.getStartWeek() > specialActivityRegistration.getEndWeek()) {
//				throw new Exception("Start week is after end week");
//			} else {
//				if (resourcelist.contains(specialActivityRegistration.getResource())) {
//					for (SpecialActivityRegistration specialActivityRegistrationInList : specialactivityregistrationlist) {
//						if(specialActivityRegistration.getResource().equals(specialActivityRegistrationInList.getResource()) &&
//								specialActivityRegistration.getActivity().equals(specialActivityRegistrationInList.getActivity()) && 
//								specialActivityRegistration.getStartWeek()==specialActivityRegistrationInList.getStartWeek() && 
//								specialActivityRegistration.getStartDay()==specialActivityRegistrationInList.getStartDay() && 
//								specialActivityRegistration.getEndWeek()==specialActivityRegistrationInList.getEndWeek() && 
//								specialActivityRegistration.getEndDay()==specialActivityRegistrationInList.getEndDay()) {
//							throw new Exception("Special activity already exist for this user on these days");
//						} else {
//							specialactivityregistrationlist.add(specialActivityRegistration);
//						}
//					}
//				} else {
//					throw new Exception("User doesn't exist");
//				}
//			}
//		}
	
	//Author: Mohaiman Rahim, S174120
	public String getTimeRegistration(String initials) throws Exception {
		if (timeregistrationlist.size() > 0) {
			for (TimeRegistration timeRegistrationInList : timeregistrationlist) {
				if(initials.equals(timeRegistrationInList.getResource().getId())) {
					usertimeregistrationlist.add(timeRegistrationInList);
				}
			}
			
			if (usertimeregistrationlist.size() > 0) {
				message = "Time registration list for user is created";
				Arrays.toString(usertimeregistrationlist.toArray());
			} else {
				message = "No time registrations found for this user";
			}
		} else {
			message = "No time registrations made";
		}
		
		usertimeregistrationlist.clear();
		
		return message;
	}
	
	//Author: Mohaiman Rahim, S174120
//	public String changeTimeRegistration(TimeRegistration timeRegistration) throws Exception {
//		if (timeregistrationlist.size() > 0) {
//			for (TimeRegistration timeRegistrationInList : timeregistrationlist) {
//				if(timeRegistration.getResource().equals(timeRegistrationInList.getResource()) && 
//						timeRegistration.getWeek()==timeRegistrationInList.getWeek() && 
//						timeRegistration.getDay()==timeRegistrationInList.getDay()) {
//					indexResource =  getTimeRegistrationList().indexOf(timeRegistrationInList);
//				} else {
//					message = "No time registration found for this user on that time";
//				}
//			}
//			
//			if (timeRegistration.getDay() > 7 || timeRegistration.getDay() < 1) {
//				message = "Day out of bounds";
//			} else if (timeRegistration.getWeek() > 52 || timeRegistration.getWeek() < 1) {
//				message = "Week out of bounds";
//			} else if (timeRegistration.getHoursWorked() > 24 || timeRegistration.getHoursWorked() < 1) {
//				message = "Hours out of bounds";
//			} else {
//				timeregistrationlist.get(indexResource).setHoursWorked(timeRegistration.getHoursWorked());
//				message = "Time registration is changed";
//			}
//		} else {
//			message = "No time registrations made";
//		}
//		
//		return message;
//	}
	
	//Author: Mohaiman Rahim, S174120
	public String deleteTimeRegistration(TimeRegistration timeRegistration) throws Exception {
		if (timeregistrationlist.size() > 0) {
			for (TimeRegistration timeRegistrationInList : timeregistrationlist) {
				if(timeRegistration.getResource().equals(timeRegistrationInList.getResource()) && 
						timeRegistration.getWeek()==timeRegistrationInList.getWeek() && 
						timeRegistration.getDay()==timeRegistrationInList.getDay()) {
					indexResource =  getTimeRegistrationList().indexOf(timeRegistrationInList);
					message = "Time registration is removed";
				} else {
					message = "No time registration found for this user on that time";
				}
			}
			
			timeregistrationlist.remove(indexResource);
		} else {
			message = "No time registrations made";
		}
		
		return message;
	}

	//Author: Mohaiman Rahim, S174120
//	public void getSpecialActivityRegistration(String initials) throws Exception {
//		for (SpecialActivityRegistration specialActivityRegistrationInList : specialactivityregistrationlist) {
//			if(initials.equals(specialActivityRegistrationInList.getResource())) {
//				userspecialactivityregistrationlist.add(specialActivityRegistrationInList);
//			} else {
//				throw new Exception("No special activity registrations found for this user");
//			}
//		}
//		
//		Arrays.toString(userspecialactivityregistrationlist.toArray());
//		userspecialactivityregistrationlist.clear();
//	}
	
	//Author: Mohaiman Rahim, S174120
//	public void changeSpecialActivityRegistration(SpecialActivityRegistration specialActivityRegistration) throws Exception {
//		for (SpecialActivityRegistration specialActivityRegistrationInList : specialactivityregistrationlist) {
//			if(specialActivityRegistration.getResource().equals(specialActivityRegistrationInList.getResource()) &&
//					specialActivityRegistration.getActivity().equals(specialActivityRegistrationInList.getActivity()) && 
//					specialActivityRegistration.getStartWeek()==specialActivityRegistrationInList.getStartWeek() && 
//					specialActivityRegistration.getStartDay()==specialActivityRegistrationInList.getStartDay() && 
//					specialActivityRegistration.getEndWeek()==specialActivityRegistrationInList.getEndWeek() && 
//					specialActivityRegistration.getEndDay()==specialActivityRegistrationInList.getEndDay()) {
//				indexResource =  getSpecialActivityRegistrationList().indexOf(specialActivityRegistrationInList);
//			} else {
//				throw new Exception("No special activity registration found for this user on that time");
//			}
//		}
//		
//		if (specialActivityRegistration.getStartDay() > 7 || specialActivityRegistration.getStartDay() < 1
//				|| specialActivityRegistration.getEndDay() > 7 || specialActivityRegistration.getEndDay() < 1) {
//			throw new Exception("Day out of bounds");
//		} else if (specialActivityRegistration.getStartWeek() > 52 || specialActivityRegistration.getStartWeek() < 1
//				|| specialActivityRegistration.getEndWeek() > 52 || specialActivityRegistration.getEndWeek() < 1) {
//			throw new Exception("Week out of bounds");
//		} else if (specialActivityRegistration.getStartWeek()==specialActivityRegistration.getEndWeek() && 
//				specialActivityRegistration.getStartDay() > specialActivityRegistration.getEndDay()) {
//			throw new Exception("Start day is after end day");
//		} else if (specialActivityRegistration.getStartWeek() > specialActivityRegistration.getEndWeek()) {
//			throw new Exception("Start week is after end week");
//		} else {
//			specialactivityregistrationlist.get(indexResource).setActivity(specialActivityRegistration.getActivity());
//			specialactivityregistrationlist.get(indexResource).setStartWeek(specialActivityRegistration.getStartWeek());
//			specialactivityregistrationlist.get(indexResource).setStartDay(specialActivityRegistration.getStartDay());
//			specialactivityregistrationlist.get(indexResource).setEndWeek(specialActivityRegistration.getEndWeek());
//			specialactivityregistrationlist.get(indexResource).setEndDay(specialActivityRegistration.getEndDay());		
//		}
//	}
	
	//Author: Mohaiman Rahim, S174120
//	public void deleteSpecialActivityRegistration(SpecialActivityRegistration specialActivityRegistration) throws Exception {
//		for (SpecialActivityRegistration specialActivityRegistrationInList : specialactivityregistrationlist) {
//			if(specialActivityRegistration.getResource().equals(specialActivityRegistrationInList.getResource()) && 
//					specialActivityRegistration.getActivity().equals(specialActivityRegistrationInList.getActivity()) && 
//					specialActivityRegistration.getStartWeek()==specialActivityRegistrationInList.getStartWeek() && 
//					specialActivityRegistration.getStartDay()==specialActivityRegistrationInList.getStartDay() && 
//					specialActivityRegistration.getEndWeek()==specialActivityRegistrationInList.getEndWeek() && 
//					specialActivityRegistration.getEndDay()==specialActivityRegistrationInList.getEndDay()) {
//				indexResource =  getSpecialActivityRegistrationList().indexOf(specialActivityRegistrationInList);
//			} else {
//				throw new Exception("No special activity registration found for this user on that time");
//			}
//		}
//
//		specialactivityregistrationlist.remove(indexResource);
//}
	
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

	// StefanAndersen FirstRealImplementedMethodOfProject
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

//	public void addWorkPlanned(WorkPlanned WorkPlanned) {
//		workplannedlist.add(WorkPlanned);
//	}


	//StefanAndersen
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

	public List<Resource> getResources() {
		return resourcelist;
	}
	
	//Author: Rizwan Ali Ishaq
	public int getIndexUsername() {
		return indexUsername;
	}
	
	//Author: Rizwan Ali Ishaq
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