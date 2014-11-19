package book.ocp7.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

// illustrates how use File class to compare two paths
public class PathCompare2 {
	public static void main(String[] args) throws IOException {
		Path path1 = Paths.get("Test");
		Path path2 = Paths.get("/home/Test/test");

		System.out.println("Files.isSameFile(path1, path2 is: "
				+ Files.isSameFile(path1, path2));
	}
}
