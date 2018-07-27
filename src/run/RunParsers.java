package run;

import parsers.domParser.FamilyDOMParser;
import parsers.interfaces.FamilyParser;
import parsers.saxParser.FamilySAXParser;
import parsers.staxParser.FamilySTAXParser;

public class RunParsers {

	public static void main(String[] args) {
		System.out.println("SAXParser");
		System.out.println();
		FamilyParser familySaxParser= new FamilySAXParser();
		familySaxParser.familyParse("resources/Family.xml");
		
		System.out.println("DOMParser");
		System.out.println();
		FamilyParser familyDOMParser = new FamilyDOMParser();
		familyDOMParser.familyParse("resources/Family.xml");
		
		System.out.println("STAXParser");
		System.out.println();
		FamilyParser familySTAXParser = new FamilySTAXParser();
		familySTAXParser.familyParse("resources/Family.xml");
		

	}

}
