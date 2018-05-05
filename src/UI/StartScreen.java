//Stefan Siggaard Andersen || Kayaba Akihiko || Day Date Month year
//DTU Student ID S144230
//Instructor: Professor Paul Fischer
package UI;

import java.io.IOException;
import java.io.PrintWriter;

public class StartScreen extends Screen {

	@Override
	public void printScreen(PrintWriter out) throws IOException {
		out.println("0) Login");
		out.println("1) Create user");
		out.println("2) Exit the program");
	}
	
	@Override
	public boolean processInput(String selection, PrintWriter out) {
		if ("0".equals(selection)) {
			timeRegUI.setScreen(new InitialsScreen());
		} else if ("1".equals(selection)) {
			timeRegUI.setScreen(new CreateUserScreen());
		} else if ("2".equals(selection)) {
			out.print("Program exited.");
			return true;
		} else {
			out.print("Invalid selection, try again.");
		}
		return false;
	}
	
}