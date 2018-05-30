package beans;

import java.io.Serializable;

public class DeliveryMethodBeans implements Serializable {
	private int id;
	private String deliveryName;
	private int deliveryPrice;

	public DeliveryMethodBeans(int id2, String deliveryName2, int deliveryPrice2) {
		this.id = id2;
		this.deliveryName = deliveryName2;
		this.deliveryPrice = deliveryPrice2;
	}
	public DeliveryMethodBeans() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

}
