package acceptance_tests;

import app_files.TimeRegApp;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
