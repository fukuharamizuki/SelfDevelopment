package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BuyDataBeans implements Serializable {
	private int id;
	private int userId;
	private int totalPrice;
	private int deliveryId;
	private Date buyDate;

	private String deliveryName;
	private int deliveryPrice;
	private int waribiki;


	public BuyDataBeans(int id2, int userId2, int totalPrice2, int deliveryId2, java.sql.Date createDate) {
		this.id = id2;
		this.userId = userId2;
		this.totalPrice = totalPrice2;
		this.deliveryId = deliveryId2;
		this.buyDate = createDate;
	}
	public BuyDataBeans() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public int getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(int deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	public String getFormatDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(buyDate);
	}
	public int getWaribiki() {
		return waribiki;
	}
	public void setWaribiki(int waribiki) {
		this.waribiki = waribiki;
	}



}
