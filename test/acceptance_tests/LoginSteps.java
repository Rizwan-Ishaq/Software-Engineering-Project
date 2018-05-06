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
//	private String inputName;
	private String inputInitials;
	private String inputPassword;
	private Resource resource;
	//private Resource testResource = new Resource("Rizwan Ali Ishaq", "RAI", "lyngby123");
	
	
	private ErrorMessageHolder errorMessageHolder;
	
	public LoginSteps(TimeRegApp timeRegApp, ErrorMessageHolder errorMessageHolder) {
		this.timeRegApp = timeRegApp;
		this.errorMessageHolder = errorMessageHolder;
	}
	
	@Given("^the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" wants to login$")
	public void theResourceWithIdAndPasswordWantsToLogin(String name, String initials, String password) throws Exception {
		resource = new Resource(name,initials,password);
		assertThat(resource.getFullName(),is(equalTo(name)));
		assertThat(resource.getId(),is(equalTo(initials)));
		assertThat(resource.getPassword(),is(equalTo(password)));
		try {
	    	timeRegApp.registerResource(resource);
	    } catch (Exception e) {
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}
	
	@Given("^that the resource is not logged in$")
	public void thatTheResourceIsNotLoggedIn() throws Exception {
		timeRegApp.userLoggedIn = false;
		assertFalse(timeRegApp.userLoggedIn());
	}

	@Given("^the resources initials are \"([^\"]*)\" and the password is \"([^\"]*)\"$")
	public void theResourcesInitialsAreAndThePasswordIs(String initials, String password) throws Exception {
		this.inputInitials = initials;
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
	
	@Given("^there is a resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void thereIsAResourceWithIdAndPassword(String name, String initials, String password ) throws Exception {
		resource = new Resource(name,initials,password);
		assertThat(resource.getFullName(),is(equalTo(name)));
		assertThat(resource.getId(),is(equalTo(initials)));
		assertThat(resource.getPassword(),is(equalTo(password)));
	}

	@When("^the user is created(?: again|)$")
	public void theUserIsCreated() throws Exception {
	    try {
	    	timeRegApp.registerResource(resource);
	    } catch (Exception e) {
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	}

	@Then("^the user for the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is created$")
	public void theUserForTheResourceWithIdAndPasswordIsCreated(String arg1, String arg2, String arg3) throws Exception {
	    assertTrue(timeRegApp.getResources().contains(resource));
	}

	@Given("^that the resource \"([^\"]*)\", with id \"([^\"]*)\" and password \"([^\"]*)\" is already a user$")
	public void thatTheResourceWithIdAndPasswordIsAlreadyAUser(String name, String initials, String password) throws Exception {
		resource = new Resource(name,initials,password);
		assertThat(resource.getFullName(),is(equalTo(name)));
		assertThat(resource.getId(),is(equalTo(initials)));
		assertThat(resource.getPassword(),is(equalTo(password)));
		try {
	    	timeRegApp.registerResource(resource);

	    } catch (Exception e) {
	    	errorMessageHolder.setErrorMessage(e.getMessage());
	    }
	    timeRegApp.userLogin(resource.getId(), resource.getPassword());
	    assertTrue(timeRegApp.userLoggedIn());
	}
	
	@Then("^we get the error message \"([^\"]*)\"$")
	public void weGetTheErrorMessage(String errorMessage) throws Exception {
		assertThat(errorMessageHolder.getErrorMessage(),is(equalTo(errorMessage)));
	}


	
}