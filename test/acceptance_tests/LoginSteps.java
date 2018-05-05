package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import UI.InitialsScreen;
import UI.StartScreen;
import UI.TimeRegUI;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app_files.Resource;
import app_files.TimeRegApp;

public class LoginSteps{
	
	private TimeRegUI timeRegUI;
	private TimeRegApp timeRegApp;
	private Resource resource;
	
	public LoginSteps(TimeRegApp timeRegApp) {
		this.timeRegApp = timeRegApp;
	}


//	@Given("^that the resource selected to create a user$")
//	public void thatTheResourceSelectedToCreateAUser() throws Exception {
//		timeRegUI.setScreen(new StartScreen());
//		System.out.println("1");
//	}
	
	@Given("^there is a resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void theResourceWithIdAndPasswordIsNotAlreadyAUser(String fullName, String initials, String password) throws Exception {
		resource = new Resource(fullName,initials,password);
		assertThat(resource.getFullName(),is(equalTo(fullName)));
		assertThat(resource.getId(),is(equalTo(initials)));
		assertThat(resource.getPassword(),is(equalTo(password)));
	}
	
	@When("^the user is created$")
	public void theUserIsCreated() throws Exception {
		try {
			timeRegApp.addResource(resource);
		} catch (Exception e) { }
	}
	
	@Then("^the user for the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is created$")
	public void theUserForTheResourceWithIdAndPasswordIsCreated(String fullName, String initials, String password) throws Exception {
		int index = timeRegApp.getResources().indexOf(resource);
		assertThat(timeRegApp.getResources().get(index).toString(),is(initials));
	}
	
	@Then("^we get the error message \"([^\"]*)\"$")
	public void weGetTheErrorMessage(String errorMessage) throws Exception {
		System.out.println(errorMessage);
	}
	
//	@Given("^that the resource selected to login$")
//	public void thatTheResourceSelectedToLogin() throws Exception {
//		timeRegUI.setScreen(new StartScreen());
//		System.out.println("0");
//	}
	
	@Given("^that the resource \"([^\"]*)\" is not logged in$")
	public void thatTheResourceIsNotLoggedIn(String user) throws Exception {
		assertFalse(timeRegApp.userLoggedIn());
		System.out.println(user);
	}
	
	@Given("^the password is \"([^\"]*)\"$")
	public void thePasswordIs(String password) throws Exception {
		System.out.println(password);
	}
	
	@Then("^the user is logged in$")
	public void theUserIsLoggedIn() throws Exception {
		assertTrue(timeRegApp.userLoggedIn());
	}
	
	@Then("^the resource is not logged in$")
	public void theResourceIsNotLoggedIn() throws Exception {
		assertFalse(timeRegApp.userLoggedIn());
	}

}