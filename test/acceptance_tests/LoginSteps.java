package acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app_files.TimeRegApp;

public class LoginSteps {
	
	private TimeRegApp timeregapp;
	private String password;
	

	public LoginSteps(TimeRegApp timeregapp) {
		this.timeregapp = timeregapp;
	}


	@Given("^that the resource selected to create a user$")
	public void thatTheResourceSelectedToCreateAUser() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is not already a user$")
	public void theResourceWithIdAndPasswordIsNotAlreadyAUser(String arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@When("^the user is created$")
	public void theUserIsCreated() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the user for the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is created$")
	public void theUserForTheResourceWithIdAndPasswordIsCreated(String arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is already a user$")
	public void theResourceWithIdAndPasswordIsAlreadyAUser(String arg1, String arg2, String arg3) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^we get the error message \"([^\"]*)\"$")
	public void weGetTheErrorMessage(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^that the resource selected to login$")
	public void thatTheResourceSelectedToLogin() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^that the resource \"([^\"]*)\" is not logged in$")
	public void thatTheResourceIsNotLoggedIn(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Given("^the password is \"([^\"]*)\"$")
	public void thePasswordIs(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the \"([^\"]*)\" login succeeds$")
	public void theLoginSucceeds(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the user is logged in$")
	public void theUserIsLoggedIn() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the resource login fails$")
	public void theResourceLoginFails() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	@Then("^the resource is not logged in$")
	public void theResourceIsNotLoggedIn() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}