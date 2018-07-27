package parsers.saxParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import entity.Child;
import entity.Families;
import entity.Family;
import entity.FamilyMember;
import entity.Father;
import entity.Mother;



public class FamilySAXParserHandlerObject extends DefaultHandler {

	private Families families;
	private Family family;
	private FamilyMember member;
	private String next;

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (localName) {
		case "families":
			families = new Families();
			break;
		case "family":
			family = new Family();
			family.setId(Integer.valueOf(attributes.getValue("id")));
			families.addFamily(family);
			break;
		case "mother":
			member = new Mother();
			Mother mother = (Mother) member;
			mother.setMaidenName(attributes.getValue("maiden-name"));
			family.setMother(mother);
			break;
		case "father":
			member = new Father();
			family.setFather((Father) member);
			break;
		case "child":
			member = new Child();
			family.addChild((Child) member);
			break;

		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
		case "name":
			member.setName(next);
			break;
		case "surname":
			member.setSurname(next);
			break;
		case "age":
			member.setAge(Integer.valueOf(next));
			break;
		case "gender":
			Child child = (Child) member;
			child.setGender(next);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.next = new StringBuilder().append(ch, start, length).toString().trim();
	}

	public Families getInstance() {
		return families;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

}
