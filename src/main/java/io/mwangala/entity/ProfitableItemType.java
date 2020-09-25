package io.mwangala.entity;

public class ProfitableItemType {

	String itemType;
	String totalItemProfit;
	
	
	public ProfitableItemType() {
	
	}


	public ProfitableItemType(String itemType, String totalItemProfit) {
		this.itemType = itemType;
		this.totalItemProfit = totalItemProfit;
	}


	public String getItemType() {
		return itemType;
	}


	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	public String getTotalItemsSold() {
		return totalItemProfit;
	}


	public void setTotalItemsSold(String totalItemProfit) {
		this.totalItemProfit = totalItemProfit;
	}


	@Override
	public String toString() {
		return "ProfitableItemType [itemType=" + itemType + ", totalItemsSold=" + totalItemProfit + "]";
	}
	
	
}
