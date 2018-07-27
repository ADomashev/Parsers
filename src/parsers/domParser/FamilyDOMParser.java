package parsers.domParser;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Child;
import entity.Families;
import entity.Family;
import entity.FamilyMember;
import entity.Father;
import entity.Mother;
import parsers.interfaces.FamilyParser;


public class FamilyDOMParser implements FamilyParser {

	private Families families;
	private Family family;
	private FamilyMember member;

	private String space = "";

	@Override
	public void familyParse(String path) {

		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(path);
			Element element = document.getDocumentElement();

			printXMLDocument(element);

			getInstance(element);
			System.out.println(families);

		} catch (ParserConfigurationException e) {
			System.out.println("Cannot build DOMParser");
			e.printStackTrace();
		} catch (SAXException e) {
			System.out.println("SAXParser exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problems with XML file");
			e.printStackTrace();
		}
	}

	private void printXMLDocument(Node node) {
		NodeList nodeList = node.getChildNodes();
		for (int j = 0; j < nodeList.getLength(); j++) {
			Node nodeChild = nodeList.item(j);
			if (!nodeChild.getNodeName().equals("#text")) {
				System.out.println(space() + "<" + nodeChild.getNodeName() + ">");
				printXMLDocument(nodeChild);
				space = new StringBuilder().append(space, 0, space.length() - 3).toString();
			}
		}
	}

	private void getInstance(Node node) {
		if (!node.getNodeName().equals("#text")) {
			switch (node.getNodeName()) {
			case "families":
				families = new Families();
				break;
			case "family":
				family = new Family();
				family.setId(Integer.valueOf(node.getAttributes().getNamedItem("id").getNodeValue()));
				families.addFamily(family);
				break;
			case "mother":
				member = new Mother();
				Mother mother = (Mother) member;
				mother.setMaidenName(node.getAttributes().getNamedItem("maiden-name").getNodeValue());
				family.setMother(mother);
				break;
			case "father":
				member = new Father();
				family.setFather((Father) member);
				break;
			case "military":
				break;
			case "child":
				member = new Child();
				family.addChild((Child) member);
				break;
			case "gender":
				Child child = (Child) member;
				child.setGender(node.getTextContent());
				break;
			case "name":
				member.setName(node.getTextContent());
				break;
			case "surname":
				member.setSurname(node.getTextContent());
				break;
			case "age":
				member.setAge(Integer.valueOf(node.getTextContent()));
				break;
			}
		}
		NodeList nodeList = node.getChildNodes();
		for (int j = 0; j < nodeList.getLength(); j++) {
			Node nodeChild = nodeList.item(j);
			getInstance(nodeChild);
		}
	}

	private String space() {
		return space += "   ";
	}
}
