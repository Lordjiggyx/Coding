import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;

public class ParserHTML {

	public ParserHTML() throws IOException {
		// TODO Auto-generated constructor stub
		//companies();
		Boris();
	}
	
	public void spans()throws IOException 
	{
		Document doc = Jsoup.connect("https://www.ticketmaster.ie/browse/all-concerts-catid-10001/music-rid-10001").get();
		
		Elements spans = doc.getElementsByTag("span");
		
		for(Element span : spans)
		{
			System.out.println("Span Text:"+span.text());
		}
	}
	
	public void companies()throws IOException 
	{
		Document doc = Jsoup.connect("https://www.rte.ie/news/markets/iseq/").get();
		
		Elements companyrow = doc.getElementsByTag("tr");
		

		
		for(int i = 1; i < companyrow.size(); i++)
		{
			
			System.out.println("Row Number:"+ i);
			System.out.println(" ");
			//System.out.println(companyrow.get(i).getAllElements());
			
			Elements data = companyrow.get(i).getAllElements();
			System.out.println("Company Name:" + data.get(1).text());
			System.out.println("Closing Price:" + data.get(2).text());
			System.out.println(" ");
			
			
			
		}
	}
	public void Boris()throws IOException 
	{
		Document doc = Jsoup.connect("https://www.dailymail.co.uk/news/index.html").get();
		
		Elements links = doc.getElementsByTag("a");
		
		for(Element link : links)
		{
			if(link.attr("itemprop").equals("url"))
			{
				if(link.text().contains("Boris"))
				{
					System.out.println("Text + " + link.text());
				}
			}
		}
		

		
		}
	

	
	public static void main (String[] args) throws IOException
	{
		ParserHTML  P = new ParserHTML();
	}

}
