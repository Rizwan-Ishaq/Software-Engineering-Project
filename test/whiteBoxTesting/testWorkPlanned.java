//Stefan Siggaard Andersen || Kayaba Akihiko || Day Date Month year
//DTU Student ID S144230
//Instructor: Professor Paul Fischer
package whiteBoxTesting;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import app_files.Activity;
import app_files.Project;
import app_files.Resource;
import app_files.TimeRegApp;
import app_files.WorkPlanned;

public class testWorkPlanned {


	private TimeRegApp timeRegApp = new TimeRegApp();

	TimeRegApp getTimeRegApp() {
		return timeRegApp;
	}

	private static boolean setupIsDone = false;
	@Before
	public void setUpSampleData() {
		if(setupIsDone) {
			//return;
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
		getTimeRegApp().addResource(newResource);
		Resource newResource2 = new Resource("Stefan", "ASS", "cocacola");
		getTimeRegApp().addResource(newResource2);
	}

	
	
	@Test //test1
	public void testAddWorkplannedWithNonExistingProject() {
		
		for (int i = 0; i < getTimeRegApp().projectlist.size(); i++) {

			Project currentProject = getTimeRegApp().projectlist.get(i);

			System.out.println(currentProject.getId() + " " + currentProject.getName());
		
		}
		WorkPlanned newWorkPlanned = new WorkPlanned("19001", "irrelevant", "irrelevant",
				00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		assertEquals("Error: Project does not exist", output);

	}

	@Test //test2
	public void testAddWorkplannedWithNonExistingActivity() {
		//System.out.println("8888");
		/*for (int i = 0; i < getTimeRegApp().projectlist.size(); i++) {

			Project currentProject = getTimeRegApp().projectlist.get(i);

			System.out.println(currentProject.getId() + " " + currentProject.getName());
		
		}*/
		
		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "c", "irrelevant",
				00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		
		assertEquals("Error: Activity does not exist or isn't assigned to project", output);
	}
	
	@Test //test3
	public void testAddWorkplannedWithExistingActivityDoesNotPointToProject() {

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "b", "irrelevant",
				00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Activity does not exist or isn't assigned to project", output);
	}
	
	@Test //test4
	public void testAddWorkplannedWithNonExistingResource() {

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SAS",
				00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		System.out.println(output);
	}
	
	@Test //test5
	public void testAddWorkplannedProjectEndsBeforeStarts() {

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SSA",
				20, 10);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		System.out.println(output);
	}
	
	@Test //test6
	public void testAddWorkplannedScheduledWorkHasBeenAddedEmptyWorkPlannedList() {

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SAS",
				10, 20);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		System.out.println(output);
	}
	
	@Test //test7
	public void testAddWorkplanned() {

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SAS",
				10, 20);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		System.out.println(output);
	}

}
