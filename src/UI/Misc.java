package UI;

import app_files.SpecialActivityRegistration;
import app_files.TimeRegistration;

public class Misc {
	out.println("RegisterTime <Initials> <Week> <Day> <HoursWorked>					(-> OK)");
	out.println("RegisterSpecialActivity <Initials> <Activity> <StartWeek> <EndWeek> <StartDay> <EndDay>		(-> OK)");
	out.println("GetTimeRegistration <Initials>								(-> OK)");
	out.println("GetSpecialActivityRegistration <Initials>						(-> OK)");
	out.println("ChangeTimeRegistration <Initials> <Week> <Day> <HoursWorked>				(-> OK)");
	out.println("ChangeSpecialActivityRegistration <Initials> <Activity> <StartWeek> <EndWeek> <StartDay> <EndDay>	(-> OK)");
	out.println("DeleteTimeRegistration <Initials> <Week> <Day> <HoursWorked>				(-> OK)");
	out.println("DeleteSpecialActivityRegistration <Initials> <Activity> <StartWeek> <EndWeek> <StartDay> <EndDay>	(-> OK)");
	
	
	//Author: Mohaiman Rahim, S174120
	if ("RegisterTime".equals(command)) {
		handled = true;
		
		String initials = Tokens[1];
		String week = Tokens[2];
		String day = Tokens[3];
		int hoursWorked = Integer.parseInt(Tokens[4]);

		TimeRegistration timeRegistration = new TimeRegistration(initials, week, day, hoursWorked);
		try {
			timeRegUI.getTimeRegApp().registerTime(timeRegistration);
		} catch (Exception e) {
		}
		
		System.out.println("Ok");
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("RegisterSpecialActivity".equals(command)) {
		handled = true;
		
		String initials = Tokens[1];
		String activity = Tokens[2];
		String startWeek = Tokens[3];
		String endWeek = Tokens[4];
		String startDay = Tokens[5];
		String endDay = Tokens[6];

		SpecialActivityRegistration specialActivityRegistration = new SpecialActivityRegistration(initials, activity, startWeek, endWeek, startDay, endDay);
		try {
			timeRegUI.getTimeRegApp().registerSpecialActivity(specialActivityRegistration);
		} catch (Exception e) {
		}
		
		System.out.println("Ok");
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("GetTimeRegistration".equals(command)) {
		handled = true;				
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("GetSpecialActivityRegistration".equals(command)) {
		handled = true;
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("ChangeTimeRegistration".equals(command)) {
		handled = true;
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("ChangeSpecialActivityRegistration".equals(command)) {
		handled = true;
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("DeleteTimeRegistration".equals(command)) {
		handled = true;
	}
	
	//Author: Mohaiman Rahim, S174120
	if ("DeleteSpecialActivityRegistration".equals(command)) {
		handled = true;
	}
}
