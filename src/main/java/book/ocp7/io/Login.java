package book.ocp7.io;

import java.io.Console;
import java.util.Arrays;

public class Login {
	public static void main(String[] args){
		Console console = System.console();
		
		if (console != null){
			String userName = null;
			char[] password = null;
			userName = console.readLine("Enter your username:");
			password = console.readPassword("Enter password:");
			
			System.out.println("Login successful");
			Arrays.fill(password, ' ');
		
		}
	}
}
