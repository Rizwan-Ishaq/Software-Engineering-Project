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
	
public class ListPlannedWorkSteps {
	
	private TimeRegApp timeRegApp = new TimeRegApp();
	
	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	@Given("^I want to list planned work$")
	public void iWantToListPlannedWork() throws Exception {

	}

	@Then("^print list of planned work$")
	public void printListOfPlannedWork() throws Exception {

		getTimeRegApp().getListofWorkPlanned();
	}
	

}
