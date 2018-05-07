//Author: Mohaiman Rahim, S174120
package app_files;

public class SpecialActivityRegistration {
	
	TimeRegApp timeRegApp = new TimeRegApp();
	private String resource;
	private String activity;
	private int startWeek;
	private int startDay;
	private int endDay;
	private int endWeek;
	
	public SpecialActivityRegistration(String initials, String activity, int startWeek, int endWeek, int startDay, int endDay) {
		this.resource = initials;
		this.setActivity(activity);
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}
	
	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public int getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}

	public int getStartDay() {
		return startDay;
	}

	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}

	public int getEndDay() {
		return endDay;
	}

	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}
}
