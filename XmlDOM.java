package xmlDOM;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlDOM {
	public static void main(String[] args) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File("Score.xml"));
			NodeList math = document.getElementsByTagName("数学");
			NodeList wuli = document.getElementsByTagName("物理");
			double mathavg=0;
			double wuliavg=0;
			for(int i=0;i<math.getLength();i++)
			{
				mathavg+=Double.parseDouble(math.item(i).getTextContent());
				wuliavg+=Double.parseDouble(wuli.item(i).getTextContent());
			}
			mathavg /=math.getLength();
			wuliavg /=wuli.getLength();
			System.out.println("数学平均成绩为："+mathavg+" 物理平均成绩为："+wuliavg);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
