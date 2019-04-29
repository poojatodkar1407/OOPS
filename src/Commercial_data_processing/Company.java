package Commercial_data_processing;

public class Company {
		
	private String StockName;
	private String StockSymbol;
	private String NoOfShare;
	private String SharePrice;
	
	public Company()
	{
		
	}
	
	public Company(String StockName, String NoOfShare, String StockSymbol, String SharePrice)
	{
		this.StockName = StockName;
		this.StockSymbol = StockSymbol;
		this.NoOfShare = NoOfShare;
		this.SharePrice = SharePrice;	
	}
	
	public String getStockName()
	{
		return StockName;
	}
	
	public void setStockName(String StockName)
	{
		this.StockName = StockName;
	}
	
	public String getStockSymbol()
	{
		return StockSymbol;
	}
	public void setStockSymbol(String StockSymbol)
	{
		this.StockSymbol = StockSymbol;
	}
	
	public String getNoOfShare()
	{
		return NoOfShare;
	}
	public void setNoOfShare(String NoOfShare)
	{
		this.NoOfShare = NoOfShare;
	}
	public String getSharePrice()
	{
		return SharePrice;
	}
	public void setSharePrice(String SharePrice)
	{
		this.SharePrice = SharePrice;
	}
}