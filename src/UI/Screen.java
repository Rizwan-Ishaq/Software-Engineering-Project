package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

abstract public class Screen {
	
	TimeRegUI timeregUI;
	
	abstract public void printScreen(PrintWriter out) throws IOException;
	
	public String readInput(BufferedReader in) throws IOException {
		return in.readLine();
	}
	
	void setTimeRegUI(TimeRegUI timeregUI) {
		this.timeregUI = timeregUI;
	}

	abstract public boolean processInput(String input, PrintWriter out);
}
