package jl.playground.xml.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import jl.playground.xml.dom.XMLUtil;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class SAXSimple extends DefaultHandler {

	@Override
	public void startDocument() throws SAXException {
		System.out.println("start doc");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("end doc");
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.printf("in char method: start %d, length %d, value is %s \n", start,
				length, new String (ch, start,length));
		
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.printf("in start Element: URI %s, localName %s, qName %s\n",
				uri, localName, qName);
System.out.printf("[ATTRIBUTES] name: %s, contribution: %s, shares: %s\n",
		attributes.getValue("name"),
		attributes.getValue("contribution"),
		attributes.getValue("shares")
		);

		
		
	}

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {
		String filename = null;

		for (int i = 0; i < args.length; i++) {
			filename = args[i];
			if (i != args.length - 1) {
				XMLUtil.usage();
			}
			if (filename == null) {
				XMLUtil.usage();
			}

			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setNamespaceAware(true);
			SAXParser saxParser = spf.newSAXParser();

			XMLReader xmlReader = saxParser.getXMLReader();
			xmlReader.setContentHandler(new SAXSimple());
			xmlReader.parse(XMLUtil.convertToFileURL(filename));

		}
	}

}
