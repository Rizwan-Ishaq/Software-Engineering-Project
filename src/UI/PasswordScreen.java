package UI;

import java.io.IOException;
import java.io.PrintWriter;

import app_files.Resource;
import app_files.TimeRegApp;

public class PasswordScreen extends Screen {
	
	private TimeRegApp timeRegApp = new TimeRegApp();

	@Override
	public void printScreen(PrintWriter out) throws IOException {
		out.println("Password:");

	}

	@Override
	public boolean processInput(String input, PrintWriter out) {
		
		Resource correctUser = timeRegApp.getResources().get(timeRegApp.getIndexUsername());
		
		if(input.equals(correctUser.getPassword())) {
			timeRegApp.userLoggedIn = true;
			timeRegUI.setScreen(new MainMenu());
		} else {
			out.print("Wrong Password");
			timeRegUI.setScreen(new StartScreen());
		}
		return false;
	}

}
