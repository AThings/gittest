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
			NodeList math = document.getElementsByTagName("��ѧ");
			NodeList wuli = document.getElementsByTagName("����");
			double mathavg=0;
			double wuliavg=0;
			for(int i=0;i<math.getLength();i++)
			{
				mathavg+=Double.parseDouble(math.item(i).getTextContent());
				wuliavg+=Double.parseDouble(wuli.item(i).getTextContent());
			}
			mathavg /=math.getLength();
			wuliavg /=wuli.getLength();
			System.out.println("��ѧƽ���ɼ�Ϊ��"+mathavg+" ����ƽ���ɼ�Ϊ��"+wuliavg);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
