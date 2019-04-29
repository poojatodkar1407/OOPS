package Commercial_data_processing;

import java.io.FileReader;
import java.util.Scanner;

import org.codehaus.jackson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Utility {
	
	Scanner sc = new Scanner(System.in);
	
	public String inputString()
	{
		return sc.next();
	}
	
	public Integer inputinteger()
	{
		return sc.nextInt();
	}
	
	public void stockDetails()
	{
		JSONParser parser = new JSONParser();
		
		try
		{
			JSONObject obj = (JSONObject) parser.parse(new FileReader("Stock.json"));
			JSONObject object = obj;
			JSONArray array = (JSONArray) object.get("Stock");
			
			long totalValue = 0;
			long total = 0;
			
			System.out.println("Stock name\tNo of shares\tshare price\ttotal value of stock");
			
			for(int i=0;i<array.size();i++)
			{
				JSONObject simple = (JSONObject) array.get(i);
				total = (long)simple.get("No Of Share") * (long)simple.get("Share Price");
				System.out.println(simple.get("Stock Name")+"\t\t"+simple.get("No Of Share")+"\t\t"+simple.get("Share Price")+"\t\t");
				totalValue = totalValue+total;
			}
			System.out.println("total value is " +totalValue);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}