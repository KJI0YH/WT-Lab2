package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;

public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String APPLIANCES_DB = "./src/main/resources/appliances_db.xml";

	@Override
	public Appliance find(Criteria criteria) {
		try{

			// Create document builder
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			// Create DOM tree document from a file
			Document document = documentBuilder.parse(new File(APPLIANCES_DB));

			// Get root element
			Node root = document.getDocumentElement();

			// Get all sub elements
			NodeList nodes = root.getChildNodes();

			for (int i = 0; i < nodes.getLength(); i++){
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE){
					if (node.getNodeName().equalsIgnoreCase(criteria.getGroupSearchName())){



						//todo
						//appliance creator factory
						//matches checker criterias
					}


				}
			}
		}
		catch (Exception e){
			return null;
		}
		return null;
	}
	
	// you may add your own code here

}


//you may add your own new classes