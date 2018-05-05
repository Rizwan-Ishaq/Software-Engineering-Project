package UI;

import java.io.IOException;
import java.io.PrintWriter;

public class StartScreen extends Screen {

	@Override
	public void printScreen(PrintWriter out) throws IOException {
		out.println("TimeReg application menu");
		out.println("Commands, <> specifies input parameters, do not use space within a single parameter:");
		out.println("AddProject <ProjectName>]                                                          (-> OK, ProjectID)");
		out.println("ListProjects                                                                       (-> Nx ProjectName, ProjectID)");
		out.println("AddActivity <ProjectId> <ActivityName>                                             (-> OK)");
		out.println("ListActivities                                                                     (-> Nx ProjectId, ActivityName)");
		out.println("ListActivitiesForProject <ProjectId>                                               (-> Nx ActivityName)");
		out.println("AddWorkPlanned <ProjectId> <ActivityName> <ResourceInitials> <StartWeek> <EndWeek> (-> OK)");
		out.println("ListWorkPlanned                                                                    (-> Nx ProjectId, ActivityName, ResourceInitials, FromWeek, ToWeek");
		out.println("ListWorkPlannedForProject <ProjectId>                                              (-> Nx ProjectId, ActivityName, ResourceInitials, FromWeek, ToWeek");
		out.println("ListWorkPlannedForResource <ResourceInitials>                                      (-> Nx ProjectId, ActivityName, ResourceInitials, FromWeek, ToWeek");        System.out.println("Implemented for testing. Not all commands implemented");
		out.println("Exit");
		out.println("Enter Command:");
		
	}
	
	@Override
	public boolean processInput(String selection, PrintWriter out) {
		if ("0".equals(selection)) {
			timeRegUI.setScreen(new InitialsScreen());
		} else if ("1".equals(selection)) {
			timeRegUI.setScreen(new CreateUserScreen());
		} else if ("2".equals(selection)) {
			out.print("Program exited.");
			return true;
		} else {
			out.print("Invalid selection, try again.");
		}
		return false;
	}
	
}
