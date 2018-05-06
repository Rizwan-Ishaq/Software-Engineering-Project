package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

//import UI.InitialsScreen;
//import UI.StartScreen;
//import UI.TimeRegUI;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app_files.Resource;
import app_files.TimeRegApp;

public class LoginSteps {
	
//	private TimeRegUI timeRegUI;
	private TimeRegApp timeRegApp;
	private Resource resource;
	private String inputName;
	private String inputInitials;
	private String inputPassword;
	
	private Resource testResource = new Resource("Rizwan Ali Ishaq", "RAI", "lyngby123");
	
	public LoginSteps(TimeRegApp timeRegApp) {
		this.timeRegApp = timeRegApp;
	}
	
	
	
	@Given("^that the resource is not logged in$")
	public void thatTheResourceIsNotLoggedIn() throws Exception {
		timeRegApp.addResource(testResource);
		assertFalse(timeRegApp.userLoggedIn());
	}

	@Given("^the resources initials are \"([^\"]*)\" and the password is \"([^\"]*)\"$")
	public void theResourcesInitialsAreAndThePasswordIs(String intials, String password) throws Exception {
		this.inputInitials = intials;
		this.inputPassword = password;
	}

	@Then("^the resource login succeeds$")
	public void theResourceLoginSucceeds() throws Exception {
	    assertTrue(timeRegApp.userLogin(inputInitials, inputPassword));
	}

	@Then("^the resource is logged in$")
	public void theResourceIsLoggedIn() throws Exception {
	    assertTrue(timeRegApp.userLoggedIn());
	}
	
	@Then("^the resource login fails$")
	public void theResourceLoginFails() throws Exception {
		 assertFalse(timeRegApp.userLogin(inputInitials, inputPassword));
	}

	@Then("^the resource is not logged in$")
	public void theResourceIsNotLoggedIn() throws Exception {
	     assertFalse(timeRegApp.userLoggedIn());
	}
	
	//////////
	
	@Given("^there is a resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void thereIsAResourceWithIdAndPassword(String name, String initials, String password ) throws Exception {
		resource = new Resource(name,initials,password);
		assertThat(resource.getFullName(),is(equalTo(name)));
		assertThat(resource.getId(),is(equalTo(initials)));
		assertThat(resource.getPassword(),is(equalTo(password)));
		
//	    this.inputName = name;
//	    this.inputInitials = initials;
//	    this.inputPassword = password;
	}

	@When("^the user is created(?: again|)$")
	public void theUserIsCreated() throws Exception {
	    try {
	    	timeRegApp
	    } catch {
	    	
	    }
	}

	@Then("^the user for the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is created$")
	public void theUserForTheResourceWithIdAndPasswordIsCreated(String arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the resource is already a user$")
	public void theResourceIsAlreadyAUser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^the resource tries to create a user again$")
	public void theResourceTriesToCreateAUserAgain() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
}