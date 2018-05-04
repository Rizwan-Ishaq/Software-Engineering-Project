package app_files;

public class Activities {
	
	private int totalTime;
	private int startTime;
	private int endTime;
	
	public void Activity(int totalTime, int startTime, int endTime) {
		this.totalTime = totalTime;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public int getTotalTime() {
		return totalTime;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}	
}