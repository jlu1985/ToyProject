package book.ocp7.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Type {

	public static void main(String[] files) {
		if (files.length == 0) {
			System.err.println("pass the name of the file(s) as argument");
			System.exit(-1);
		}

		for (String file : files) {
			// process each file passed as argument
			try (FileReader inputFile = new FileReader(file)) {
				int ch = 0;

				// while there are characters to fetch, read, and print the
				// characters when EOF is reached, read() will return -1
				// terminating the loop

				while ((ch = inputFile.read()) != -1) {
					// ch is of type int - convert it back to char
					// before printing
					System.out.print((char) ch);
				}

			} catch (FileNotFoundException fnfe) {
				System.err.printf("Cannot open the given file %s ", file);
			} catch (IOException ioe) {
				System.err.printf(
						"Error when processing file %s... skipping it", file);
			}
			// tye-with-resources will automatically release FileReader object
		}
	}

}
