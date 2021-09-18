package practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadFromXML {
	@Test
	public void readDataFromXML(XmlTest xmlobj) {
		System.out.println(xmlobj.getParameter("browser"));
		System.out.println(xmlobj.getParameter("url"));

	}
}
