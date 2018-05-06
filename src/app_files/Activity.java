
//Stefan Siggaard Andersen || Kayaba Akihiko || Day Date Month year
//DTU Student ID S144230
//Instructor: Professor Paul Fischer
package app_files;

public class Activity {

	private String actId;
	private String projId;
	private int budgetHours;
	private int startWeek;
	private int endWeek;

	public Activity(String projId, String actId, int budgetHours, int startWeek, int endWeek) {

		this.projId = projId;
		this.actId = actId;
		this.budgetHours = budgetHours;
		this.startWeek = startWeek;
		this.endWeek = endWeek;
		
	}
	
	public String getActId() {
		return this.actId;
	}
	
	public String getProjId() {
		return this.projId;
	}
	
	public int getBudgetHours() {
		return this.budgetHours;
	}
	
	public int getStartWeek() {
		return this.startWeek;
	}
	
	public int getEndWeek() {
		return this.endWeek;
	}
}