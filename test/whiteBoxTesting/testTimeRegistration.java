//Author: Mohaiman Rahim, S174120
package whiteBoxTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app_files.Resource;
import app_files.TimeRegApp;
import app_files.TimeRegistration;

public class testTimeRegistration {
	
	private TimeRegApp timeRegApp = new TimeRegApp();

	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	@Test //1
	public void testTimeRegistrationWithNonExistingResource() throws Exception {
		Resource GJ = new Resource("Good", "GJ", "job");
		
		TimeRegistration timeRegistration = new TimeRegistration(GJ, 12, 2, 10);
		
		String messageIs = getTimeRegApp().registerTime(timeRegistration);
		assertEquals("User doesn't exist", messageIs);
	}
	
	@Test //2
	public void testTimeRegistrationWithDayOutOfBounds() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 8, 10);
		
		String messageIs = getTimeRegApp().registerTime(timeRegistration);
		assertEquals("Day out of bounds", messageIs);
	}
	
	@Test //3
	public void testTimeRegistrationWithWeekOutOfBounds() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, -3, 2, 10);
		
		String messageIs = getTimeRegApp().registerTime(timeRegistration);
		assertEquals("Week out of bounds", messageIs);
	}
	
	@Test //4
	public void testTimeRegistrationWithHoursOutOfBounds() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 30);
		
		String messageIs = getTimeRegApp().registerTime(timeRegistration);
		assertEquals("Hours out of bounds", messageIs);
	}
	
	@Test //5 success
	public void testTimeRegistrationWithTimeIsRegistered() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 10);
		
		String messageIs = getTimeRegApp().registerTime(timeRegistration);
		assertEquals("Time is registered", messageIs);
	}
	
	@Test //6
	public void testTimeRegistrationWithTimeIsAlreadyRegistered() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 10);
		getTimeRegApp().registerTime(timeRegistration);
		
		String messageIs = getTimeRegApp().registerTime(timeRegistration);
		assertEquals("Time registration already done for this user on that time", messageIs);
	}
	
	@Test //7
	public void testTimeRegistrationWithNoTimeRegistrationsMadeForUserOnThatSpecificTime() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 10);
		getTimeRegApp().registerTime(timeRegistration);
		
		TimeRegistration timeRegistration2 = new TimeRegistration(MR, 14, 2, 10);
		
		String messageIs = getTimeRegApp().deleteTimeRegistration(timeRegistration2);
		assertEquals("No time registration found for this user on that time", messageIs);
	}
	
	@Test //8
	public void testTimeRegistrationWithNoTimeRegistrationsMadeForUser() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 10);
		getTimeRegApp().registerTime(timeRegistration);
		
		Resource JK = new Resource("Just", "JK", "kiding");
		getTimeRegApp().addResource(JK);
		
		String messageIs = getTimeRegApp().getTimeRegistration(JK.getId());
		assertEquals("No time registrations found for this user", messageIs);
	}
	
	@Test //9
	public void testTimeRegistrationWithNoTimeRegistrationsMade() throws Exception {
		getTimeRegApp().getTimeRegistrationList().clear();
		
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		String messageIs = getTimeRegApp().getTimeRegistration(MR.getId());
		assertEquals("No time registrations made", messageIs);
	}
	
	@Test //10 success
	public void testTimeRegistrationWithTimeRegistrationListIsCreated() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 10);
		getTimeRegApp().registerTime(timeRegistration);
		
		String messageIs = getTimeRegApp().getTimeRegistration(MR.getId());
		assertEquals("Time registration list for user is created", messageIs);
	}
	
//	@Test //11 success
//	public void testTimeRegistrationWithTimeRegistrationIsChanged() throws Exception {
//		TimeRegistration timeRegistration = new TimeRegistration("MR", 12, 2, 10);
//		String messageIs = getTimeRegApp().registerTime(timeRegistration);
//		assertEquals("Time registration is changed", messageIs);
//	}
	
	@Test //11 success
	public void testTimeRegistrationWithTimeRegistrationIsRemoved() throws Exception {
		Resource MR = new Resource("Mohaiman", "MR", "roskilde");
		getTimeRegApp().addResource(MR);
		
		TimeRegistration timeRegistration = new TimeRegistration(MR, 12, 2, 10);
		getTimeRegApp().registerTime(timeRegistration);
		
		String messageIs = getTimeRegApp().deleteTimeRegistration(timeRegistration);
		assertEquals("Time registration is removed", messageIs);
	}
}
