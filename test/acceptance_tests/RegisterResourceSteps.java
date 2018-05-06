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

public class RegisterResourceSteps {

	private TimeRegApp timeRegApp = new TimeRegApp();
	Resource newResource;
	Resource newResourcetwo;
	
	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	@Given("^a Resource with name \"([^\"]*)\" initials \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void aResourceWithNameInitialsAndPassword(String arg1, String arg2, String arg3) throws Exception {
		newResource = new Resource(arg1, arg2, arg3);
	}

	@Then("^I register resource$")
	public void iRegisterResource() throws Exception {
		getTimeRegApp().registerResource(newResource);
	}
	
	@Given("^a Resourcetwo with name \"([^\"]*)\" initials \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void aResourcetwoWithNameInitialsAndPassword(String arg1, String arg2, String arg3) throws Exception {
		newResourcetwo = new Resource(arg1, arg2, arg3);
	}

	@Given("^Resource is registered$")
	public void resourceIsRegistered() throws Exception {
		getTimeRegApp().registerResource(newResource);
	}

	@When("^I register Resourcetwo$")
	public void iRegisterResourcetwo() throws Exception {
		getTimeRegApp().registerResource(newResourcetwo);
	}

	@Then("^we get Resource exists error \"([^\"]*)\"$")
	public void weGetResourceExistsError(String arg1) throws Exception {

		String output = getTimeRegApp().registerResource(newResourcetwo);
		assertEquals("User is already registered", output);
		
	}
	
	

}
