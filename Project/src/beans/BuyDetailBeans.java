package beans;

import java.io.Serializable;

public class BuyDetailBeans implements Serializable {

	private int id;
	private int buyId;
	private int itemId;
	private int count;
	private int buyType;
	private String size;

	public BuyDetailBeans(String size2, int count) {
		this.size = size2;
		this.count=count;
	}
	public BuyDetailBeans() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBuyId() {
		return buyId;
	}
	public void setBuyId(int buyId) {
		this.buyId = buyId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getcount() {
		return count;
	}
	public void setItemCount(int count) {
		this.count = count;
	}
	public int getBuyType() {
		return buyType;
	}
	public void setBuyType(int buyType) {
		this.buyType = buyType;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

}
