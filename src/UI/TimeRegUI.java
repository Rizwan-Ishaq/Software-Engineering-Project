package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import app_files.TimeRegApp;

public class TimeRegUI {

	private Screen screen;
	private TimeRegApp timeRegApp = new TimeRegApp();


	public static void main(String[] args) throws IOException {

		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out, true);
		TimeRegUI ui = new TimeRegUI();
		ui.basicLoop(in, out);
		System.out.println("byeeee");
	}
	
	public TimeRegUI() {
		setScreen(new StartScreen());
	}
	
	
	TimeRegApp getTimeRegApp() {
        return timeRegApp;
    }

	public void printMenu(PrintWriter out) throws IOException {
		getScreen().printScreen(out);
	}

	public void basicLoop(BufferedReader in, PrintWriter out) throws IOException {
		String selection;
		do {
			printMenu(out);
			selection = readInput(in);
		} while (!processInput(selection, out));
	}

	public String readInput(BufferedReader in) throws IOException {
		return getScreen().readInput(in);
	}

	public boolean processInput(String input, PrintWriter out) throws IOException {
		boolean exit = getScreen().processInput(input, out);
		out.println();
		return exit;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
		this.screen.setTimeRegUI(this);
	}

	Screen getScreen() {
		return screen;
	}

}