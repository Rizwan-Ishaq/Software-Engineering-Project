//Author: Mohaiman Rahim, S174120
package app_files;

public class SpecialActivityRegistration {
	
	TimeRegApp timeRegApp = new TimeRegApp();
	private Resource resource;
	private String activity;
	private String startWeek;
	private String startDay;
	private String endDay;
	private String endWeek;
	
	public SpecialActivityRegistration(Resource resource, String activity, String startWeek, String endWeek, String startDay, String endDay) {
		this.resource = resource;
		this.setActivity(activity);
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	
	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(String startWeek) {
		this.startWeek = startWeek;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(String endWeek) {
		this.endWeek = endWeek;
	}
}
