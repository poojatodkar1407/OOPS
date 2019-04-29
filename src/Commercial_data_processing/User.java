package Commercial_data_processing;

public class User {
		private String UserName;
		private String NoOfShare;
		private String SharePrice;
		
		public User()
		{
			
		}
		
		public User(String UserName , String NoOfShare,String Price)
		{
			super();
			this.UserName = UserName;
			this.NoOfShare = NoOfShare;
			this.SharePrice = SharePrice;
		}
		
		public String getUserName()
		{
			return UserName;
		}
		public void setUserName(String Username)
		{
			this.UserName = Username;
		}
		public String getNoOfShares()
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

