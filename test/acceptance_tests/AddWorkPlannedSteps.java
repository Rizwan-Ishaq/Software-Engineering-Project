package acceptance_tests;

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
	
	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	@Given("^a project with name \"([^\"]*)\"$")
	public void aProjectWithName(String arg1) throws Exception {
		
		Project newProject = new Project(arg1);
		getTimeRegApp().addProject(newProject);
		
	}

	@Given("^an activity with projectId \"([^\"]*)\" and actId \"([^\"]*)\" and budgethours \"([^\"]*)\" and startWeek \"([^\"]*)\" and endWeek \"([^\"]*)\"$")
	public void anActivityWithProjectIdAndActIdAndBudgethoursAndStartWeekAndEndWeek(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
	    
		Activity newActivity = new Activity(arg1, arg2, Integer.parseInt(arg3), Integer.parseInt(arg4), Integer.parseInt(arg5));
		getTimeRegApp().addActivity(newActivity);
		
	}

	@Given("^a resource with fullName \"([^\"]*)\" and initials \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void aResourceWithFullNameAndInitialsAndPassword(String arg1, String arg2, String arg3) throws Exception {
		Resource newResource = new Resource(arg1, arg2, arg3);
		getTimeRegApp().addResource(newResource);

	}

	@When("^I create newWorkPlanned with projectId \"([^\"]*)\" and actId \"([^\"]*)\" and resource initials \"([^\"]*)\" and startWeek \"([^\"]*)\" and endWeek \"([^\"]*)\"$")
	public void iCreateNewWorkPlannedWithProjectIdAndActIdAndResourceInitialsAndStartWeekAndEndWeek(String arg1, String arg2, String arg3, String arg4, String arg5) throws Exception {
		newWorkPlanned = new WorkPlanned(arg1, arg2, arg3, Integer.parseInt(arg4), Integer.parseInt(arg5));
	    
	}

	@Then("^workPlanned is created$")
	public void workplannedIsCreated() throws Exception {
		getTimeRegApp().addWorkPlanned(newWorkPlanned);
	}
}
