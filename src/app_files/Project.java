//Author: Rizwan Ali Ishaq
package app_files;

import java.time.*;

public class Project {
	
	//Author: Rizwan Ali Ishaq
	private String name;
	private String id;
	//Author: Rizwan Ali Ishaq
	private static int idNo = 1;
	private String idNoString = String.valueOf(idNo);
	private String numPadding = "000";
	private int year = Year.now().getValue();
	private String stringID = Integer.toString(year).substring(2, 4);
	private String idAuto = stringID + numPadding.substring(idNoString.length()) + String.valueOf(idNo);
	
	//Author: Rizwan Ali Ishaq
	public Project(String name) {
		this.setName(name);
		this.id = idAuto;
		idNo++;
	}

	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	//Stefan Andersen - For testing purposes
	public void resetCounter() {
		idNo = 1;
	}
}
