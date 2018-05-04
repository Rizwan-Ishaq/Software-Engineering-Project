//Stefan Siggaard Andersen || Kayaba Akihiko || Day Date Month year
//DTU Student ID S144230
//Instructor: Professor Paul Fischer
package app_files;

public class WorkPlanned {

	private String activityId;
	private String projectId;
	private int startWeek;
	private int endWeek;
	private int resourceId;

	public WorkPlanned(String activityId, String projectId, int startWeek, int endWeek, int resourceId) {

		this.activityId = activityId;
		this.projectId = projectId;
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

	public int getResourceId() {
		return resourceId;
	}

}
