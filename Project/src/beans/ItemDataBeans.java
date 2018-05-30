package beans;

import java.io.Serializable;

public class ItemDataBeans implements Serializable {

	private int id;
	private String name;
	private String detail;
	private int price;
	private int RPrice;
	private String fileName;
	private String type;

	// カートに入れる際のみ利用
	private String size;;
	private int buyTypePrice;
	private int count;
	private int buyType;

	// 購入画面　小計の際のみ使用
	private int subTotal;

	public ItemDataBeans(int id, String name, String detail, int price, int rPrice, String file, String type) {
		this.id = id;
		this.name =name;
		this.detail = detail;
		this.price = price;
		this.RPrice = rPrice;
		this.fileName = file;
		this.type = type;
	}
	public ItemDataBeans(int id2, String name2, String detail2, int rPrice2, String fileName2, String type2,
			String size2, int count2,int subTotal,int buyType) {
		this.id = id2;
		this.name = name2;
		this.detail = detail2;
		this.buyTypePrice = rPrice2;
		this.fileName = fileName2;
		this.type = type2;
		this.size = size2;
		this.count = count2;
		this.subTotal = subTotal;
		this.buyType = buyType;
	}
	public ItemDataBeans() {
	}
	public ItemDataBeans(int id2, String name1, String detail1, int price2, int rPrice2) {
		this.id = id2;
		this.name = name1;
		this.detail = detail1;
		this.price = price2;
		this.RPrice = rPrice2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRPrice() {
		return RPrice;
	}
	public void setRPrice(int rPrice) {
		RPrice = rPrice;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getBuyTypePrice() {
		return buyTypePrice;
	}
	public void setBuyType(int buyTypePrice) {
		this.buyTypePrice = buyTypePrice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}
	public int getBuyType() {
		return buyType;
	}

}
