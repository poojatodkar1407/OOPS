package com.bridgeit.objectOrientedPrograms;

import java.io.Serializable;

public class Stock implements Serializable {
	private String Stock_Name;
	private int Number_of_Share;
	private double Share_Price;

	public String getShare_name() {
		return Stock_Name;
	}

	public void setShare_name(String stock_name) {
		this.Stock_Name = stock_name;
	}

	public int getNumber_of_share() {
		return Number_of_Share;
	}

	public void setNumber_of_share(int number_of_share) {
		this.Number_of_Share = number_of_share;
	}

	public double getShare_price() {
		return Share_Price;
	}

	public void setShare_price(double share_price) {
		this.Share_Price = share_price;
	}

	@Override
	public String toString() {
		return "Stock [share_name=" + Stock_Name + ", number_of_share=" + Number_of_Share + ", share_price="
				+ Share_Price + "]";
	}

}
