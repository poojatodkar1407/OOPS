package Commercial_data_processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Commercial_data_processing.Utility;


public class StockMethods {
		Utility utility = new Utility();
		Company company = new Company();
		Scanner sc = new Scanner(System.in);
		
		String companyPath = ("/home/admin1/eclipse-workspace/ObjectOriented_json/Company.json");
		String stockPath = ("/home/admin1/eclipse-workspace/ObjectOriented_json/UserStock.json");
		Company companyPojo = new Company();
		
		public void addDetails()
		{
				System.out.println("Enter your choice");
				System.out.println("1. To create account of company");
				System.out.println("2. To create account of user");
	
				int choice = utility.inputinteger();
				
				switch(choice)
				{
				case 1:
					try
					{
						addStockDetails();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					break;
					
				case 2:
					try
					{
						addUser();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
					break;
					
					default:
						System.out.println("Invalid choice...");
						
				}
		}

		public void addStockDetails()
		{
			File file = new File(companyPath);
			
			System.out.println("Enter stock name");
			String stockName = utility.inputString();
			company.setStockName(stockName);
			
			System.out.println("Enter stock symbol");
			String stockSymbol = utility.inputString();
			company.setStockSymbol(stockSymbol);
			
			System.out.println("Enter the no of share");
			String noOfShare = utility.inputString();
			company.setSharePrice(noOfShare);
			
			System.out.println("Enter share price");
			String sharePrice = utility.inputString();
			company.setSharePrice(sharePrice);
			
			try
			{
				createcompanyJsonObj(company,file);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		public void createcompanyJsonObj(Company company,File file) throws FileNotFoundException, IOException, ParseException
		{
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(new FileReader(file));
			JSONArray array = (JSONArray) object.get("StockDetails");
			JSONObject simple = new JSONObject();
			
			simple.put("StockName",company.getStockName());
			simple.put("StockSymbol",company.getStockSymbol());
			simple.put("NoOfShare",company.getNoOfShare());
			simple.put("SharePrice",company.getSharePrice());
			
			array.add(simple);
			object.put("StockDetails", array);
			
			System.out.println("object");
			
			try
			{
				writeIntoFile(object,companyPath);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		private void writeIntoFile(JSONObject object2 , String filePath) throws IOException
		{
			File file = new File(filePath);
			FileWriter writer = new FileWriter(file);
			writer.write(object2.toString());
			writer.flush();
		}
		
		public void addUser()
		{
			User user = new User();
			File file = new File(stockPath);
			System.out.println("Enter the username");
			String userName = utility.inputString();
			user.setUserName(userName);
			
			System.out.println("Enter number of share");
			String NoOfShare = utility.inputString();
			user.setNoOfShare(NoOfShare);
			
			System.out.println("Enter the share price");
			String SharePrice = utility.inputString();
			user.setSharePrice(SharePrice);
			try
			{
				createUserJsonObj(user,file);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}

		public void createUserJsonObj(User user, File file) throws IOException, IOException, ParseException {
			JSONParser parser = new JSONParser();
			JSONObject object = (JSONObject) parser.parse(new FileReader(file));
			JSONArray array = (JSONArray) object.get("UserDetails");
			JSONObject simple = new JSONObject();
			simple.put("UserName",user.getUserName());
			simple.put("NoOfShare",user.getNoOfShares());
			simple.put("SharePrice",user.getSharePrice());
			array.add(simple);
			object.put("UserDetails",array);
			System.out.println(object);
			writeIntoFile(object,stockPath);
		}

	@SuppressWarnings("unchecked")
	public void buyStock() throws ParseException, IOException 
	{
		File file1 = new File(companyPath);
		JSONParser parser1 = new JSONParser();
		JSONObject jsonObj1 = (JSONObject)parser1.parse(new FileReader(file1));
		JSONArray array1 = (JSONArray)jsonObj1.get("StockDetails"); 
		System.out.println(array1);

		File file2 = new File(stockPath);
		JSONParser parser2 = new JSONParser();
		JSONObject jsonObj2 = (JSONObject)parser2.parse(new FileReader(file2));
		JSONArray array2 = (JSONArray)jsonObj2.get("UserDetails");
		System.out.println(array2);
		JSONObject compareObj1;
		JSONObject compareObj2;
		System.out.println("Enter User name : ");
		String userName = utility.inputString();
		for(int i = 0;i<array2.size();i++)
		{
			compareObj2 = (JSONObject)array2.get(i);
			if(compareObj2.get("UserName").equals(userName))
			{
				System.out.print(compareObj2);
				System.out.println("\nFollowing is available stock list");
				for(i=0 ; i<array1.size();i++)
				{
					compareObj1 = (JSONObject)array1.get(i);
					System.out.println(compareObj1);
				}
				System.out.println("Enter Stock Name from above list ");
				String stockName = utility.inputString();
				for(i=0 ; i<array1.size();i++)
				{
					compareObj1 = (JSONObject)array1.get(i);
					if(compareObj1.get("StockName").equals(stockName)) 
					{
						System.out.println(compareObj1);
						System.out.println("Enter how many stocks you want to buy");
						int stocksToBuy = utility.inputinteger();
						
						int companyIntStocks = Integer.parseInt(compareObj1.get("NoOfShare").toString());
						int userIntStocks = Integer.parseInt(compareObj2.get("NoOfShare").toString());
						int userSharePrice = Integer.parseInt(compareObj2.get("SharePrice").toString());
						int companySharePrice = Integer.parseInt(compareObj1.get("SharePrice").toString());
						
						int newUserShares = userIntStocks + stocksToBuy;
						int newCompanyShares = companyIntStocks - stocksToBuy;
						
						int priceOfEachShare = companySharePrice / companyIntStocks;
						int newStockCalculation = (priceOfEachShare * stocksToBuy);
						int newComapnySharePrice=  companySharePrice + newStockCalculation ;						
						int newUserSharePrice = userSharePrice - newStockCalculation;
						
						if(companyIntStocks > stocksToBuy && userSharePrice > newStockCalculation)
						{						
							compareObj1.remove("NoOfShare");
							compareObj2.remove("NoOfShare");
							compareObj1.remove("SharePrice");
							compareObj2.remove("SharePrice");
							
							compareObj1.put("NoOfShare", newCompanyShares);
							compareObj2.put("NoOfShare", newUserShares);
							compareObj1.put("SharePrice", newComapnySharePrice);
							compareObj2.put("SharePrice", newUserSharePrice);
														
							System.out.println(compareObj1);
							System.out.println(compareObj2);
							
							Date dateObj = new Date();
	                        String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(dateObj);
	                        System.out.println("Shares Buy Date & Time : " + date);
						}
						else
							System.out.println("Sorry.!!! Insufficient amount or shares not available....");
					}
				}
			}
		}
		writeIntoFile(jsonObj1, companyPath);
		writeIntoFile(jsonObj2, stockPath);
	}
	
	@SuppressWarnings("unchecked")
	public void sellStock() throws ParseException, IOException 
	{
		File file1 = new File(companyPath);
		JSONParser parser1 = new JSONParser();
		JSONObject jsonObj1 = (JSONObject)parser1.parse(new FileReader(file1));
		JSONArray array1 = (JSONArray)jsonObj1.get("StockDetails"); 
		System.out.println(array1);		
		File file2 = new File(stockPath);
		JSONParser parser2 = new JSONParser();
		JSONObject jsonObj2 = (JSONObject)parser2.parse(new FileReader(file2));
		JSONArray array2 = (JSONArray)jsonObj2.get("UserDetails");
		System.out.println(array2);
		JSONObject compareObj1;
		JSONObject compareObj2;
		System.out.println("Enter User name : ");
		String userName = utility.inputString();
		for(int i = 0;i<array2.size();i++)
		{
			compareObj2 = (JSONObject)array2.get(i);
			if(compareObj2.get("UserName").equals(userName))
			{
				
				System.out.print(compareObj2);
				System.out.println("\nFollowing is available stock list");
				for(i=0 ; i<array1.size();i++)
				{
					compareObj1 = (JSONObject)array1.get(i);
					System.out.println(compareObj1);
				}
				System.out.println("Enter name of stock to whom you want to buy shares ");
				String stockName = utility.inputString();
				for(i = 0 ; i<array1.size();i++)
				{
					compareObj1 = (JSONObject)array1.get(i);
					if(compareObj1.get("StockName").equals(stockName))
					{
						
						System.out.println(compareObj1);						
						System.out.println("How many shares you wants to sell ? ");
						int sellShares = utility.inputinteger();
						
						int companyIntStocks = Integer.parseInt(compareObj1.get("NoOfShare").toString());
						int userIntStocks = Integer.parseInt(compareObj2.get("NoOfShare").toString());
						int userSharePrice = Integer.parseInt(compareObj2.get("SharePrice").toString());
						int companySharePrice = Integer.parseInt(compareObj1.get("SharePrice").toString());
												
						int newUserShares = userIntStocks - sellShares;
						int newCompanyShares = companyIntStocks + sellShares;							
						
						int priceOfEachUserShares = userSharePrice / userIntStocks; 
						int newShareCalculation =  priceOfEachUserShares * sellShares;
						int newUserSharePrice = userSharePrice + newShareCalculation;
						int newCompanySharePrice = companySharePrice - newShareCalculation ; 
						
						if(sellShares < userIntStocks && newShareCalculation < companySharePrice )
						{
							compareObj1.remove("NoOfShare");
							compareObj2.remove("NoOfShare");
							compareObj1.remove("SharePrice");
							compareObj2.remove("SharePrice");
							
							compareObj1.put("NoOfShare", newCompanyShares);
							compareObj2.put("NoOfShare", newUserShares);
							compareObj1.put("SharePrice", newCompanySharePrice);
							compareObj2.put("SharePrice", newUserSharePrice);
							
							System.out.println(compareObj1);
							System.out.println(compareObj2);					

							Date dateObj = new Date();
	                        String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(dateObj);
	                        System.out.println("Shares Sell Date & Time : " + date);
						}
					}
				}	
			}
		}
		
		writeIntoFile(jsonObj1, companyPath);
		writeIntoFile(jsonObj2, stockPath);
	}
	
	public void printReport() throws ParseException, IOException 
	{
		System.out.println("Whose data you want to see\n1. Company\t2. User");
		int reportchoice = utility.inputinteger();
		switch (reportchoice) 
		{
		case 1:
			try {
				printCompanyReport();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
			break;
		case 2:
			try {
				printUserReport();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}		
	}
	public void  printCompanyReport() throws ParseException, IOException 
	{
		File file = new File(companyPath);
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject)parser.parse(new FileReader(file));
		JSONArray array = (JSONArray)jsonObj.get("StockDetails");
		System.out.println(array);
	}
	public void printUserReport() throws ParseException, IOException 
	{
		File file = new File(stockPath);
		JSONParser parser = new JSONParser();
		JSONObject jsonObj = (JSONObject)parser.parse(new FileReader(file));
		JSONArray array = (JSONArray)jsonObj.get("UserDetails");
		System.out.println(array);
	}
}
