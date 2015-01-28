package jl.playground.xml.sax;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXLocalNameCount extends DefaultHandler {
	private Hashtable<String, Integer> tags;

	@Override
	public void startDocument() throws SAXException {
		tags = new Hashtable<>();
	}

	private static String convertToFileURL(String filename) {
		String path = new File(filename).getAbsolutePath();
		if (File.separatorChar != '/') {
			path = path.replace(File.separatorChar, '/');
		}
		if (!path.startsWith("/")) {
			path = "/" + path;
		}
		return "file:" + path;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		String key = localName;
		Integer value = tags.get(key);
		System.out.printf(
				"parsing: URI %s, LOCALNAME %s, QNAME %s, ATTRIBUTES %s\n",
				uri, localName, qName, attributes);
		System.out.println("qname index: " +attributes.getIndex(qName));
		System.out.println(attributes.getValue(localName));
		if (value == null) {
			tags.put(key, 1);
		} else {
			tags.put(key, ++value);
		}

	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.print("SAX Event: CHARACTERS[ ");
		try {
			OutputStreamWriter outw = new OutputStreamWriter(System.out);
			outw.write(ch, start, length);
			outw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(" ]");
	}

	@Override
	public void endDocument() throws SAXException {
		Enumeration<String> e = tags.keys();
		while (e.hasMoreElements()) {
			String tag = e.nextElement();
			int count = tags.get(tag);
			System.out.println("Local Name \"" + tag + "\" occurs " + count
					+ " times");
		}
	}

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		String filename = null;

		for (int i = 0; i < args.length; i++) {
			filename = args[i];
			if (i != args.length - 1) {
				usage();
			}
			if (filename == null) {
				usage();
			}

			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			SAXParser saxParser = spf.newSAXParser();

			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(new SAXLocalNameCount());
			xmlReader.parse(convertToFileURL(filename));

		}
	}

	private static void usage() {
		System.err.println("Usage: SAXLocalNameCount <file.xml>");
		System.err.println("       -usage or -help = this message");
		System.exit(1);
	}
}
