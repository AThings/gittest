package xmlDOM;

import java.io.*;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;


class TestDefalut extends DefaultHandler{
	private double totalMath = 0.0;
	private double totalPhy = 0.0;
	private boolean mathFlag = false;
	private boolean phyFlag = false;
	public void startDocument() throws SAXException{
		System.out.println("start");
	}
	public void endDocument() throws SAXException{
		System.out.println("数学平均分:" + totalMath/3);
		System.out.println("物理平均分:" + totalPhy/3);
		System.out.println("文档解析结束");
	}
	public void startElement(String uri, String localName, String qName, Attributes attributes)
			throws SAXException {
		if ("数学".equals(qName)) {
			mathFlag = true;
		}
		if ("物理".equals(qName)) {
			phyFlag = true;
		}
	}
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (mathFlag) {
			totalMath += Double.parseDouble(new String(ch, start, length));
		}
		if (phyFlag) {
			totalPhy += Double.parseDouble(new String(ch, start, length));
		}
	
	}
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (mathFlag) {
			mathFlag = false;
		}
		if (phyFlag) {
			phyFlag = false;
		}
	}

}
public class SAX {
	public static void main(String[] args){
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse("Score.xml",new TestDefalut());
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
