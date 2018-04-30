package app_files;

import java.time.*;

import acceptance_tests.test;

public class Project {
	
	private String name;
	private static int idNo = 1;
	private String idNoString = String.valueOf(idNo);
	private String numPadding = "000";
	private int year = Year.now().getValue();
	private String stringID = Integer.toString(year).substring(2, 4);
	private String id = stringID + numPadding.substring(idNoString.length()) + String.valueOf(idNo);;
	private String ManageID;
	
	public Project(String name) {
		this.setName(name);
		this.id = id;
		idNo++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
