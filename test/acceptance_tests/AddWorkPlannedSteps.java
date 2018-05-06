package acceptance_tests;

import static org.junit.Assert.assertEquals;

import app_files.Activity;
import app_files.Project;
import app_files.Resource;
import app_files.TimeRegApp;
import app_files.WorkPlanned;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//StefanSiggaardAndersen
public class AddWorkPlannedSteps {

	private TimeRegApp timeRegApp = new TimeRegApp();
	WorkPlanned newWorkPlanned;
	WorkPlanned newWorkPlanned2;
	
	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	@Given("^a project with name \"([^\"]*)\"$")
	public void aProjectWithName(String arg1) throws Exception {
		
		Project newProject = new Project(arg1);
		getTimeRegApp().addProject(newProject);
		newProject.resetCounter();
	}

	@Given("^an activity with projectId \"([^\"]*)\" and actId \"([^\"]*)\" and budgethours \"([^\"]*)\" and startWeek \"([^\"]*)\" and endWeek \"([^\"]*)\"$")
	public void anActivityWithProjectIdAndActIdAndBudgethoursAndStartWeekAndEndWeek(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
	    
		Activity newActivity = new Activity(arg1, arg2, Integer.parseInt(arg3), Integer.parseInt(arg4), Integer.parseInt(arg5));
		getTimeRegApp().addActivity(newActivity);
		
	}

	@Given("^a resource with fullName \"([^\"]*)\" and initials \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void aResourceWithFullNameAndInitialsAndPassword(String arg1, String arg2, String arg3) throws Exception {
		Resource newResource = new Resource(arg1, arg2, arg3);
		getTimeRegApp().registerResource(newResource);

	}

	@When("^I create newWorkPlanned with projectId \"([^\"]*)\" and actId \"([^\"]*)\" and resource initials \"([^\"]*)\" and startWeek \"([^\"]*)\" and endWeek \"([^\"]*)\"$")
	public void iCreateNewWorkPlannedWithProjectIdAndActIdAndResourceInitialsAndStartWeekAndEndWeek(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
		newWorkPlanned = new WorkPlanned(arg1, arg2, arg3, Integer.parseInt(arg4), Integer.parseInt(arg5));
	    
	}

	@Then("^workPlanned is created$")
	public void workplannedIsCreated() throws Exception {
		getTimeRegApp().addWorkPlanned(newWorkPlanned);
	}
	
	@Then("^we get project error \"([^\"]*)\"$")
	public void weGetProjectError(String arg1) throws Exception {
	  
		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		assertEquals("Error: Project does not exist", output);
		
	}

	@Then("^we get activity error \"([^\"]*)\"$")
	public void weGetActivityError(String arg1) throws Exception {
		/*
		System.out.println("cucumbertest"+newWorkPlanned.getProjectId());
		for (int i = 0; i < getTimeRegApp().projectlist.size(); i++) {

			Project currentProject = getTimeRegApp().projectlist.get(i);

			System.out.println(currentProject.getId() + " " + currentProject.getName());
		} 
		*/
		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Activity does not exist or isn't assigned to project", output);
	}

	@Then("^we get resource error \"([^\"]*)\"$")
	public void weGetResourceError(String arg1) throws Exception {

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Resource does not exist.", output);
		
	}

	@Then("^we get start end error \"([^\"]*)\"$")
	public void weGetStartEndError(String arg1) throws Exception {
		
		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Your project ends before it starts.", output);
	}
	
	@Given("^a project with name \"([^\"]*)\" and a project with name \"([^\"]*)\" exists$")
	public void aProjectWithNameAndAProjectWithNameExists(String arg1, String arg2) throws Exception {
	    
		Project newProject = new Project(arg1);
		getTimeRegApp().addProject(newProject);
		Project newProject2 = new Project(arg2);
		getTimeRegApp().addProject(newProject2);
		newProject.resetCounter();
	}

	@Given("^add newWorkPlanned to WorkPlannedList$")
	public void addNewWorkPlannedToWorkPlannedList() throws Exception {
		getTimeRegApp().addWorkPlanned(newWorkPlanned);
	}
	
	@Given("^I create newWorkPlannedtwo with projectId \"([^\"]*)\" and actId \"([^\"]*)\" and resource initials \"([^\"]*)\" and startWeek \"([^\"]*)\" and endWeek \"([^\"]*)\"$")
	public void iCreateNewWorkPlannedtwoWithProjectIdAndActIdAndResourceInitialsAndStartWeekAndEndWeek(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
		newWorkPlanned2 = new WorkPlanned(arg1, arg2, arg3, Integer.parseInt(arg4), Integer.parseInt(arg5));
	}

	@Then("^newworkPlannedtwo is created$")
	public void newworkplannedIsCreated() throws Exception {
		getTimeRegApp().addWorkPlanned(newWorkPlanned2);
		
	}
	
	@Then("^we get overlapping error \"([^\"]*)\"$")
	public void weGetOverlappingError(String arg1) throws Exception {
		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned2);
		assertEquals("Error: Resource is not available in the given timeframe, end WorkPlanned will not be added", output);
	}


}

	
