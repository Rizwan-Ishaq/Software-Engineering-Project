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
		getTimeRegApp().addResource(newResource);
		Resource newResource2 = new Resource("Stefan", "ASS", "cocacola");
		getTimeRegApp().addResource(newResource2);
	}

	@Test // test1
	public void testAddWorkplannedWithNonExistingProject() {
		System.out.println("Test 001");

		for (int i = 0; i < getTimeRegApp().projectlist.size(); i++) {

			Project currentProject = getTimeRegApp().projectlist.get(i);

			System.out.println(currentProject.getId() + " " + currentProject.getName());

		}
		WorkPlanned newWorkPlanned = new WorkPlanned("19001", "irrelevant", "irrelevant", 00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);
		assertEquals("Error: Project does not exist", output);

	}

	@Test // test2
	public void testAddWorkplannedWithNonExistingActivity() {
		System.out.println("Test 002");
		// System.out.println("8888");
		/*
		 * for (int i = 0; i < getTimeRegApp().projectlist.size(); i++) {
		 * 
		 * Project currentProject = getTimeRegApp().projectlist.get(i);
		 * 
		 * System.out.println(currentProject.getId() + " " + currentProject.getName());
		 * 
		 * }
		 */

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "c", "irrelevant", 00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Activity does not exist or isn't assigned to project", output);
	}

	@Test // test3
	public void testAddWorkplannedWithExistingActivityDoesNotPointToProject() {

		System.out.println("Test 003");

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "b", "irrelevant", 00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Activity does not exist or isn't assigned to project", output);
	}

	@Test // test4
	public void testAddWorkplannedWithNonExistingResource() {

		System.out.println("Test 004");

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SAS", 00, 00);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Resource does not exist.", output);
	}

	@Test // test5
	public void testAddWorkplannedProjectEndsBeforeStarts() {

		System.out.println("Test 005");

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SSA", 20, 10);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Your project ends before it starts.", output);
	}

	@Test // test6
	public void testAddWorkplannedScheduledWorkHasBeenAddedEmptyWorkPlannedList() {

		System.out.println("Test 006");

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SAS", 10, 20);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Resource does not exist.", output);
	}

	@Test // test7
	public void testAddWorkplannedScheduledWorkhasbeenAddedNonExistingSimilarResourceId() {

		System.out.println("Test 007");

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "ASS", 10, 20);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Succes: Scheduled work has been added for the resource", output);
	}

	@Test // test8
	public void testAddWorkplannedScheduledWorkHasBeenAddedNoSimilarResourceIdInWorkPlanned() {

		System.out.println("Test 008");

		WorkPlanned newWorkPlanned2 = new WorkPlanned("18001", "a", "SSA", 01, 05);
		getTimeRegApp().addWorkPlanned(newWorkPlanned2);

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "ASS", 01, 05);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Succes: Scheduled work has been added for the resource", output);
	}

	@Test // test9
	public void testAddWorkplannedScheduledWorkHasBeenAddedSimilarInititalsNoOverlapOfTime() {

		System.out.println("Test 009");

		WorkPlanned newWorkPlanned2 = new WorkPlanned("18001", "a", "SSA", 01, 05);
		getTimeRegApp().addWorkPlanned(newWorkPlanned2);

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SSA", 06, 10);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Succes: Scheduled work has been added for the resource", output);
	}

	@Test // test10
	public void testAddWorkplannedScheduledWorkHasNotBeenAddedSimilarInitialsOverlappingTimeFrame() {

		System.out.println("Test 010");

		WorkPlanned newWorkPlanned2 = new WorkPlanned("18001", "a", "SSA", 01, 05);
		getTimeRegApp().addWorkPlanned(newWorkPlanned2);

		WorkPlanned newWorkPlanned = new WorkPlanned("18001", "a", "SSA", 04, 10);

		String output = getTimeRegApp().addWorkPlanned(newWorkPlanned);

		assertEquals("Error: Resource is not available in the given timeframe, end WorkPlanned will not be added",
				output);
	}

}
