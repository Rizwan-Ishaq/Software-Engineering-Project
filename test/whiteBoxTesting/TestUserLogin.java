//Author: Rizwan Ali Ishaq
package whiteBoxTesting;

import app_files.Resource;
import app_files.TimeRegApp;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class TestUserLogin {
	private TimeRegApp timeRegApp = new TimeRegApp();

	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	public void createTestResource() {
		Resource resource = new Resource("Rizwan", "RAI", "lyngby123");
		try {
			getTimeRegApp().registerResource(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	
	@Test
	public void testEmptyResourceList() {
		assertTrue(getTimeRegApp().userLogin("RAI", "lyngby123"));		
		assertFalse(getTimeRegApp().userLoggedIn());
	}
	
	@Test
	public void testWrongInitials() {
		createTestResource();
		
		getTimeRegApp().userLogin("IAR", "lyngby123");
		assertFalse(getTimeRegApp().userLoggedIn());
	}
	
	@Test
	public void testWrongPassword() {
		createTestResource();
		
		getTimeRegApp().userLogin("RAI", "321lyngby");
		assertFalse(getTimeRegApp().userLoggedIn());
	}
	
	@Test
	public void testSuccesfulLogin() {
		createTestResource();
		
		getTimeRegApp().userLogin("RAI", "lyngby123");
		assertTrue(getTimeRegApp().userLoggedIn());
	}
	
}
