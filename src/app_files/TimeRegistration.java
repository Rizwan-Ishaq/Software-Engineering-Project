//Author: Mohaiman Rahim, S174120
package app_files;

public class TimeRegistration {
	
	TimeRegApp timeRegApp = new TimeRegApp();
	private String resource;
	private double hoursWorked;
	private String week;
	private String day;
	
	public TimeRegistration(String initials, String week, String day, int hoursWorked2) {
		this.resource = initials;
		this.week = week;
		this.day = day;
		this.hoursWorked = roundUp(hoursWorked2);
	}
	
	public double roundUp(double x) {
	    return Math.ceil(x * 2) / 2.0;
	}
	
	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = roundUp(hoursWorked);
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
