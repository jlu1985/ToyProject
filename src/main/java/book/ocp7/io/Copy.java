package book.ocp7.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// implements a simplified version of "copy" command provided in Windows
// syntax: java Copy SrcFile DstFile
// copies ScrFile to DstFile; over-writes the DstFile if it already exists

public class Copy {
	public static void main(String[] files) {
		if (files.length != 2) {
			System.err
					.println("Incorrect syntax. Correct syntax: Copy SrcFile DstFile");
		}
		String srcFile = files[0];
		String dstFile = files[1];

		// try opening the source and destination file
		// with FileReader and FileWriter

		try (BufferedReader inputFile = new BufferedReader(new FileReader(
				srcFile));
				BufferedWriter outputFile = new BufferedWriter(new FileWriter(
						dstFile))) {
			int ch = 0;

			// while there are characters to fetch, read the characters from
			// source stream and write them to the destination stream

			while ((ch = inputFile.read()) != -1) {
				// ch is of type int - convert it back to char before writing it
				outputFile.write((char) ch);
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("Cannot open the file " + fnfe.getMessage());
		} catch (IOException ioe) {
			System.err.println("Error when processing file; exiting ...");
		}

	}
}