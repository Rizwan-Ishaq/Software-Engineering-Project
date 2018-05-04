package UI;

import java.io.IOException;
import java.io.PrintWriter;

import app_files.Resource;
import app_files.TimeRegApp;

public class CreateUserScreen extends Screen {

	TimeRegApp timeRegApp = new TimeRegApp();
	
	@Override
	public void printScreen(PrintWriter out) throws IOException {
		out.println("Please enter your name, initials and password seperated by comma");
		out.println("Ex. \"Jens Lars Mortensen, JLM, lyngby123\" ");
	}

	@Override
	public boolean processInput(String input, PrintWriter out) {
		String regex = "[^,\\s][^\\,]*[^,\\s]+";
		String[] inputName = input.split(regex);
		
		
		for (Resource resource : timeRegApp.getResources()) {
			if (resource.getId().equals(inputName[1])) {
				out.println("Already existing user with same initials.");
				out.println("Please try again, with different initials.");
				timeRegUI.setScreen(new StartScreen());
			
			} else if (inputName[0].equals(null) || inputName[1].equals(null) || inputName[2].equals(null)) {
				out.println("Please fill in all required information.");
			} else {
				Resource newUser = new Resource(inputName[0],inputName[1],inputName[2]);
				out.println("User succesfully created. You can now login");
				timeRegApp.addResource(newUser);
				timeRegUI.setScreen(new InitialsScreen());
			}
		}
		return false;
	}

	
}
