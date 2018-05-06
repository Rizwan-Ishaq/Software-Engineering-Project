package acceptance_tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import UI.InitialsScreen;
import UI.StartScreen;
import UI.TimeRegUI;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import app_files.OperationNotAllowedException;
import app_files.Project;
import app_files.Resource;
import app_files.TimeRegApp;

public class ProjectSteps {
	
	private TimeRegUI timeRegUI;
	private TimeRegApp timeRegApp;
	//private Resource resource;
	
	private ErrorMessageHolder errorMessage;
	private SuccessMessageHolder succesMessage;
	private Project project;
	private List<Project> projects = new ArrayList<>();
	
	public ProjectSteps(TimeRegApp timeRegApp, ErrorMessageHolder errorMessage) {
		this.timeRegApp = timeRegApp;
		this.errorMessage = errorMessage;
	}

	@Given("^that the resource is logged in$")
	public void thatTheResourceIsLoggedIn() throws Exception {
	    assertTrue(timeRegApp.userLoggedIn);
	}	

	@Given("^wants to create the project \"([^\"]*)\"$")
	public void wantsToCreateTheProject(String projectName) throws Exception {
	    project = new Project(projectName); 
	}

	@When("^the project is created$")
	public void theProjectIsCreated() throws Exception {
//		try {
//			timeRegApp.addProject(project);
//		} catch (OperationNotAllowedException e) {
//			errorMessage.setErrorMessage(e.getMessage());
//		} 		
		
		timeRegApp.addProject(project);
	}

	@Then("^the project \"([^\"]*)\" is created$")
	public void theProjectIsCreated(String projectName) throws Exception {
	    assertThat(project.getName(),is(equalTo(projectName)));
	}
	
//	@Then("^we get the message \"([^\"]*)\" and the id number of the project \"([^\"]*)\"$")
//	public void weGetTheMessageAndTheIdNumberOfTheProject(String successMessage, String projectName) throws Exception {
//		assertEquals(successMessage, this.succesMessage.getSuccesMessage());
//		assertEquals(projectName, project.getId());
//	}


}
