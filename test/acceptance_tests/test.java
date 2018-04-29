package acceptance_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class test {

	@Given("^that (\\d+) \\+ (\\d+) = (\\d+)$")
	public void that(int arg1, int arg2, int arg3) throws Exception {
	    assertTrue(arg1+arg2==arg3);
	}

	@Then("^print out \"([^\"]*)\"$")
	public void printOut(String arg1) throws Exception {
	    System.out.println(arg1);
	}
}
