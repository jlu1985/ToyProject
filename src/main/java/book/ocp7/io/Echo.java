package book.ocp7.io;
import java.io.Console;

public class Echo {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
        	System.err.println("cannot retrive console object - are you running your application from an IDE? Exiting the application ... ");
        	
        }
        console.printf(console.readLine());
    }
}