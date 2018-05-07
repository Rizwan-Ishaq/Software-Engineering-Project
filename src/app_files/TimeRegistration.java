//Author: Mohaiman Rahim, S174120
package app_files;

public class TimeRegistration {
	
	TimeRegApp timeRegApp = new TimeRegApp();
	private Resource resource;
	private double hoursWorked;
	private int week;
	private int day;
	
	public TimeRegistration(Resource resource, int week, int day, int hoursWorked2) {
		this.resource = resource;
		this.week = week;
		this.day = day;
		this.hoursWorked = roundUp(hoursWorked2);
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

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}