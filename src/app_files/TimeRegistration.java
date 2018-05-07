//Author: Mohaiman Rahim, S174120
package app_files;

public class TimeRegistration {
	
	TimeRegApp timeRegApp = new TimeRegApp();
	private Resource resource;
	private double hoursWorked;
	private String week;
	private String day;
	
	public TimeRegistration(Resource resource, String week, String day, double hoursWorked) {
		this.resource = resource;
		this.week = week;
		this.day = day;
		this.hoursWorked = roundUp(hoursWorked);
	}
	
	public double roundUp(double x) {
	    return Math.ceil(x * 2) / 2.0;
	}
	
	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
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
