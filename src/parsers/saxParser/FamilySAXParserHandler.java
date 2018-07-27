package parsers.saxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class FamilySAXParserHandler extends DefaultHandler {

	private String space = "";

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Start parse");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("End parse");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName != " ")
			System.out.println(space() + "<" + localName + ">");
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(space + "</" + localName + ">");
		space = new StringBuilder().append(space, 0, space.length() - 3).toString();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

	}

	private String space() {
		return space += "   ";

	}

}
