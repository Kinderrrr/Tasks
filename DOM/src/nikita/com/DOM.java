package nikita.com;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOM {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, ParseException {
		// TODO Auto-generated method stub

		String url="";
		String name="";
		String city="";
		String country="";
		String DateTime="";
		
		Date currentDate = new Date();
        
        System.out.println("today   " + currentDate);
		
			
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document doc = documentBuilder.parse(new File("src/file/event.xml"));
		
		
		NodeList nodeList = doc.getElementsByTagName("venue");
		NodeList nodeList1 = doc.getElementsByTagName("event");
		 
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		
		for (int i=0; i< nodeList.getLength(); i++) {
			Element element1 =(Element)nodeList1.item(i);
			Element element =(Element)nodeList.item(i);
			DateTime = element1.getElementsByTagName("datetime").item(0).getChildNodes().item(0).getNodeValue();
			
			url = element.getElementsByTagName("url").item(0).getChildNodes().item(0).getNodeValue();
			name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
			city = element.getElementsByTagName("city").item(0).getChildNodes().item(0).getNodeValue();
			country = element.getElementsByTagName("country").item(0).getChildNodes().item(0).getNodeValue();
			
			Date date = format.parse(DateTime);
         
			System.out.println("datetime:   " + date);
			System.out.println("url:        "+ url);
			System.out.println("name:       "+ name);
			System.out.println("city:       "+ city);
			System.out.println("country:    " +country);
			System.out.println("//////////////////////////////////////////////////////");
			
			
		}
		
     //   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		

            
            
            
            
            
            
	

		
		
		
	}

}
