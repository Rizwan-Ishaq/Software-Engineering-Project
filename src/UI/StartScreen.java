package UI;

import java.io.IOException;
import java.io.PrintWriter;

import app_files.Activity;
import app_files.Project;
import app_files.Resource;
import app_files.WorkPlanned;

public class StartScreen extends Screen {

	// @Override
	// StefanAndersen
	public void printScreen(PrintWriter out) throws IOException {
		out.println("TimeReg application menu");
		out.println("Commands, <> specifies input parameters, do not use space within a single parameter:");
		out.println("Login <Initials> <Password>								(-> OK)");
		out.println("CreateUser <FullNameLastName> <Initials> <Password>					(-> OK)");
		out.println(
				"AddProject <ProjectName>                                                          	(-> OK, ProjectID)");
		out.println(
				"ListProjects                                                               	 	(-> Nx ProjectName, ProjectID)");
		out.println("AddActivity <ProjectId> <ActivityName> <BudgetHours> <startWeek> <endWeek>     		(-> OK)");
		out.println(
				"ListActivities                                                                    	(-> Nx ProjectId, ActivityName)");
		out.println(
				"ListActivitiesForProject <ProjectId>                                              	(-> Nx ActivityName)");
		out.println("AddResource <Name> <Initials> <Password>                                           	(-> OK)");
		out.println(
				"ListResources                                                                     	(-> Nx n*Name, n*initials, n*passwords");
		out.println("AddWorkPlanned <ProjectId> <ActivityName> <ResourceInitials> <StartWeek> <EndWeek> 	(-> OK)");
		out.println(
				"ListWorkPlanned                                                                  	(-> Nx ProjectId, ActivityName, ResourceInitials, FromWeek, ToWeek");
		out.println(
				"ListWorkPlannedForProject <ProjectId>                                              	(-> Nx ProjectId, ActivityName, ResourceInitials, FromWeek, ToWeek");
		out.println(
				"ListWorkPlannedForResource <ResourceInitials>                                      	(-> Nx ProjectId, ActivityName, ResourceInitials, FromWeek, ToWeek");
		out.println("RegisterTime <Initials> <Week> <Day> <HoursWorked>					(-> OK)");
		out.println("RegisterSpecialActivity <Initials> <StartWeek> <EndWeek> <StartDay> <EndDay>		(-> OK)");
		out.println("GetTimeRegistration <Initials>								(-> OK)");
		out.println("GetSpecialActivityRegistration <Initials>						(-> OK)");
		out.println("ChangeTimeRegistration <Initials> <Week> <Day> <HoursWorked>				(-> OK)");
		out.println("ChangeSpecialActivity <Initials> <StartWeek> <EndWeek> <StartDay> <EndDay>		(-> OK)");
		out.println("DeleteTimeRegistration <Initials> <Week> <Day> <HoursWorked>				(-> OK)");
		out.println("DeleteSpecialActivity <Initials> <StartWeek> <EndWeek> <StartDay> <EndDay>		(-> OK)");
		System.out.println("Implemented for testing. Not all commands implemented");
		out.println("Exit");
		out.println("Enter Command xx:");

	}

	Boolean handled = true;

	// StefanAndersen
	// @Override
	public boolean processInput(String selection, PrintWriter out) {

		String[] Tokens = selection.split(" "); // Her opdeler vi input der hvor der er mellemrum
		String command = Tokens[0];
		System.out.println("command =" + command);
		handled = false;
		
		//Author: Rizwan Ali Ishaq
		if ("Login".equals(command)) {
			handled = true;
			timeRegUI.getTimeRegApp().userLogin(Tokens[1], Tokens[2]);
			if (timeRegUI.getTimeRegApp().userLoggedIn == false) {
				System.out.println("Wrong login information, please try again.");
			} else if (timeRegUI.getTimeRegApp().userLoggedIn() == true) {
				System.out.println("Login succeeded, you can now proceed.");
			}
		}
		
		//Author: Rizwan Ali Ishaq
		if ("CreateUser".equals(command)) {
			handled = true;
			Resource newUser = new Resource(Tokens[1],Tokens[2],Tokens[3]);
			try {
				timeRegUI.getTimeRegApp().registerResource(newUser);
				System.out.println("User registered");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		if (timeRegUI.getTimeRegApp().userLoggedIn == true) {
			
			// StefanAndersen
			if ("AddProject".equals(command)) {
				handled = true;
				String projectName = Tokens[1];
	
				Project newProject = new Project(projectName);
	
				timeRegUI.getTimeRegApp().addProject(newProject);
	
				System.out.println(newProject.getId());
				System.out.println("Ok");
			}
			
			// StefanAndersen
			if ("ListProjects".equals(command)) {
				handled = true;
	
				for (int i = 0; i < timeRegUI.getTimeRegApp().projectlist.size(); i++) {
	
					Project currentProject = timeRegUI.getTimeRegApp().projectlist.get(i);
	
					System.out.println(currentProject.getId() + " " + currentProject.getName());
				}
			}
			
			// StefanAndersen
			if ("AddActivity".equals(command)) {
				handled = true;
				String projectId = Tokens[1];
				String activityName = Tokens[2];
				int budgetHours = Integer.parseInt(Tokens[3]);
				int startWeek = Integer.parseInt(Tokens[4]);
				int endWeek = Integer.parseInt(Tokens[5]);
	
				Activity newActivity = new Activity(projectId, activityName, budgetHours, startWeek, endWeek);
	
				timeRegUI.getTimeRegApp().addActivity(newActivity);
	
				System.out.println("Ok");
			}
			
			// StefanAndersen
			if ("ListActivities".equals(command)) {
				handled = true;
	
				for (int i = 0; i < timeRegUI.getTimeRegApp().activitylist.size(); i++) {
	
					Activity currentActivity = timeRegUI.getTimeRegApp().activitylist.get(i);
	
					System.out.println(currentActivity.getProjId() + " " + currentActivity.getActId());
				}
			}
			
			// StefanAndersen
			if ("AddResource".equals(command)) {
				handled = true;
				String resourceName = Tokens[1];
				String resourceInitials = Tokens[2];
				String resourcePassword = Tokens[3];
	
				Resource newResource = new Resource(resourceName, resourceInitials, resourcePassword);
	
				try {
					timeRegUI.getTimeRegApp().registerResource(newResource);
				} catch (Exception e) {
					System.out.println(e);
				}
	
				System.out.println("Ok");
			}
			
			// StefanAndersen
			if ("ListResources".equals(command)) {
				handled = true;
	
				for (int i = 0; i < timeRegUI.getTimeRegApp().resourcelist.size(); i++) {
	
					Resource currentResource = timeRegUI.getTimeRegApp().resourcelist.get(i);
	
					System.out.println(currentResource.getFullName() + " " + currentResource.getId() + " "
							+ currentResource.getPassword());
				}
			}
			
			// StefanAndersen
			if ("AddWorkPlanned".equals(command)) {
				handled = true;
				String projectId = Tokens[1];
				String activityName = Tokens[2];
				String resourceInitials = Tokens[3];
				int StartWeek = Integer.parseInt(Tokens[4]);
				int EndWeek = Integer.parseInt(Tokens[5]);
	
				WorkPlanned newWorkPlanned = new WorkPlanned(projectId, activityName, resourceInitials, StartWeek, EndWeek);
				System.out.println(timeRegUI.getTimeRegApp().addWorkPlanned(newWorkPlanned));
				// timeRegApp.addWorkPlanned(newWorkPlanned);
	
				System.out.println("OK");
			}
			
			// StefanAndersen
			if ("ListWorkPlanned".equals(command)) {
				handled = true;
	
				for (int i = 0; i < timeRegUI.getTimeRegApp().workplannedlist.size(); i++) {
	
					WorkPlanned currentWorkPlanned = timeRegUI.getTimeRegApp().workplannedlist.get(i);
	
					System.out.println(currentWorkPlanned.getProjectId() + " " + currentWorkPlanned.getActivityId() + " "
							+ currentWorkPlanned.getResourceId() + " " + currentWorkPlanned.getStartWeek() + " "
							+ currentWorkPlanned.getEndWeek());
	
				}
			}
			
			//
			if ("GetTimeRegistration".equals(command)) {
				handled = true;
			}
		}	
		
		// StefanAndersen
		if ("Exit".equals(command)) {
			handled = true;
			System.out.println("Goodbye");
			return true;
		}
		
		// StefanAndersen
		if (!handled) {

			System.out.println("Unknown Command");
		}

		return false;

	}
}
