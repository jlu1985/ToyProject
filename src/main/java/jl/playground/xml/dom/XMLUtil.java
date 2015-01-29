package jl.playground.xml.dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class XMLUtil {
	
	public static String convertToFileURL(String filename) {
		String path = new File(filename).getAbsolutePath();
		if(File.separatorChar != '/') {
			path = path.replace(File.separatorChar, '/');
		}
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		return "file:" + path;
	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		String filename = null;
		
		for (int i = 0; i < args.length; i++) {
			filename = args[i];
			if (i != args.length -1) {
				usage();
			}
			if (filename == null) {
				usage ();
			}
			
		}
	}
	
	public static void usage() {
		 System.err.println(" <file.xml>");
		    System.err.println("       -usage or -help = this message");
		    System.exit(1);
	}
}
