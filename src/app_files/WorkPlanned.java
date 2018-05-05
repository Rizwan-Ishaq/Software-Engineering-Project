//Stefan Siggaard Andersen || Kayaba Akihiko || Day Date Month year
//DTU Student ID S144230
//Instructor: Professor Paul Fischer
package app_files;

import java.io.IOException;

public class WorkPlanned {

	private TimeRegApp timeRegApp;
	private String activityId;
	private String projectId;
	private int startWeek;
	private int endWeek;
	private String resourceId;

	public WorkPlanned(TimeRegApp timeRegApp, String projectId, String activityId, int startWeek, int endWeek,
			String resourceId) {

		this.timeRegApp = timeRegApp;
		// ----------------------------

		this.projectId = projectId;
		this.activityId = activityId;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.resourceId = resourceId;
	}

	public String getActivityId() {
		return activityId;
	}

	public String getProjectId() {
		return projectId;
	}

	public int getStartWeek() {
		return startWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public String getResourceId() {
		return resourceId;
	}

}
