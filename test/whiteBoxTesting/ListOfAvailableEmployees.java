//Jacob Kjaerby Christensen || Bliz243 ||
package whiteBoxTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app_files.Activity;
import app_files.Project;
import app_files.Resource;
import app_files.TimeRegApp;
import app_files.WorkPlanned;

public class ListOfAvailableEmployees {
	private TimeRegApp timeRegApp = new TimeRegApp();
	
	
	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}
	
	private static boolean setupIsDone = false;

	@Before
	public void setUpSampleData() {
		if (setupIsDone) {
			// return;
		}

		createTestProject();
		createTestActivity();
		createTestResource();

		setupIsDone = true;
	}

	public void createTestProject() {
		Project newProject = new Project("a");
		getTimeRegApp().addProject(newProject);
		Project newProject2 = new Project("b");
		getTimeRegApp().addProject(newProject2);
		newProject.resetCounter();
	}

	public void createTestActivity() {
		Activity newActivity = new Activity("18001", "a", 10, 2, 4);
		getTimeRegApp().addActivity(newActivity);

		// only possible because currently no control of project exists.
		Activity newActivity2 = new Activity("19001", "b", 10, 2, 4);
		getTimeRegApp().addActivity(newActivity2);
	}

	public void createTestResource() {
		Resource newResource = new Resource("Stefan", "SSA", "cocacola");
		Resource newResource2 = new Resource("Stefan", "ASS", "cocacola");
		
		try {
			getTimeRegApp().registerResource(newResource);
			getTimeRegApp().registerResource(newResource2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void testWhatHappensIfNeverExecuteTheFirstForLoop() {
		System.out.println("Test 01");
			
			String output = getTimeRegApp().resourcesAvailableInTimeFrame(1,1);
			
			assertEquals("Error: This isn't the place to be", output);
	}
	
	@Test
	public void testStatementWhichShowsListOfAvailableResourcesBasedOnWorkPlan() {
	System.out.println("Test 02");

		WorkPlanned newWorkPlan = new WorkPlanned("18001","a","SSA", 10, 17);
		getTimeRegApp().addWorkPlanned(newWorkPlan);
		
		System.out.println(getTimeRegApp().workplannedlist.get(0));
		String output = getTimeRegApp().resourcesAvailableInTimeFrame(12,16);
		
		assertEquals("Error: Nothing to find here",output);
	}
	
	@Test
	public void testToSeeWhatHappensWhenTheIfStatementIsTrue() {
		
		WorkPlanned newWorkPlan = new WorkPlanned("18001","a","SSA", 13, 17);
		getTimeRegApp().addWorkPlanned(newWorkPlan);
		
		System.out.println(getTimeRegApp().workplannedlist.get(0));
		String output = getTimeRegApp().resourcesAvailableInTimeFrame(10,12);
		
		assertEquals("Adding people to list",output);
	}
}