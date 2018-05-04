package UI;

import java.io.IOException;
import java.io.PrintWriter;

import app_files.Resource;
import app_files.TimeRegApp;

public class InitialsScreen extends Screen {
	
	private TimeRegApp timeRegApp = new TimeRegApp();

	@Override
	public void printScreen(PrintWriter out) throws IOException {
		out.println("Intials:");
	}

	@Override
	public boolean processInput(String input, PrintWriter out) {
//		if (timeRegApp.getResources().contains(input)) {
//			timeRegUI.setScreen(new PasswordScreen());			
//		}
		
		for (Resource resource : timeRegApp.getResources()) {
			if(input.equals(resource.getId())) {
				timeRegApp.indexUsername = timeRegApp.getResources().indexOf(resource);
				timeRegUI.setScreen(new PasswordScreen());
			} else {
				out.print("No user with matching initials.");
				timeRegUI.setScreen(new StartScreen());
			}
		}
		return false;
	}
}
