package parsers.staxParser;

import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import entity.Child;
import entity.Families;
import entity.Family;
import entity.FamilyMember;
import entity.Father;
import entity.Mother;
import parsers.interfaces.FamilyParser;



public class FamilySTAXParser implements FamilyParser, Closeable {
	private Families families;
	private Family family;
	private FamilyMember member;

	private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

	private XMLStreamReader reader;

	private void printFamilies() {
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println(families);
	}

	@Override
	public void familyParse(String path) {
		try {
			InputStreamReader is = new InputStreamReader(new FileInputStream(path));
			reader = FACTORY.createXMLStreamReader(is);
			while (reader.hasNext()) {
				int event = reader.next();
				if (event == XMLEvent.START_ELEMENT) {
					switch (reader.getLocalName()) {
					case "families":
						families = new Families();
						break;
					case "family":
						family = new Family();
						family.setId(Integer.valueOf(reader.getAttributeValue(0)));
						families.addFamily(family);
						break;
					case "mother":
						member = new Mother();
						Mother mother = (Mother) member;
						mother.setMaidenName(reader.getAttributeValue(0));
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
					case "gender":
						Child child = (Child) member;
						child.setGender(reader.getElementText());
						break;
					case "name":
						member.setName(reader.getElementText());
						break;
					case "surname":
						member.setSurname(reader.getElementText());
						break;
					case "age":
						member.setAge(Integer.valueOf(reader.getElementText()));
						break;
					}
				}
				if (event == XMLEvent.END_ELEMENT)
					reader.next();
				if (event == XMLEvent.END_DOCUMENT)
					break;
			}
			printFamilies();
		} catch (XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void close() {
		if (reader != null) {
			try {
				reader.close();
			} catch (XMLStreamException e) {
			}
		}
	}
}
