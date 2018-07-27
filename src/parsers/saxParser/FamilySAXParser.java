package parsers.saxParser;

import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import entity.Families;
import parsers.interfaces.FamilyParser;


public class FamilySAXParser implements FamilyParser {

	@Override
	public void familyParse(String path) {

		try {

			XMLReader xmlReader = XMLReaderFactory.createXMLReader();
			xmlReader.setContentHandler(new FamilySAXParserHandler());
			xmlReader.parse(path);
			FamilySAXParserHandlerObject familySAXParserHandlerObject = new FamilySAXParserHandlerObject();
			xmlReader.setContentHandler(familySAXParserHandlerObject);
			xmlReader.parse(path);
			Families families = familySAXParserHandlerObject.getInstance();
			
			System.out.println(families);

		} catch (SAXException e) {
			System.out.println("Cannot create SaxParser ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Cannot find XMLFile");
			e.printStackTrace();
		}

	}
}
