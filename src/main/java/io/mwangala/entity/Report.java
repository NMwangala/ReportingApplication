package io.mwangala.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "TBREPORTS")
public class Report {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "REGION")
	private String region;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ITEM_TYPE")
	private String itemType;
	@Column(name = "SALES_CHANNEL")
	private String saleChannel;
	@Column(name = "ORDER_PRIORITY")
	private String orderPriority;
	@Column(name = "ORDER_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date orderDate;
	@Column(name = "ORDER_ID")
	private String orderId;
	@Column(name = "SHIP_DATE")
	@Temporal(TemporalType.DATE)
	private java.util.Date shipDate;
	@Column(name = "UNITS_SOLD")
	private int unitsSold;
	@Column(name = "UNIT_PRICE")
	private double unitPrice;
	@Column(name = "UNIT_COST")
	private double unitCost;
	@Column(name = "TOTAL_REVENUE")
	private double totalRevenue;
	@Column(name = "TOTAL_COST")
	private double totalCost;
	@Column(name = "TOTAL_PROFIT")
	private double totalProfit;
	@Transient
	private MultipartFile file;

	

	public Report() {
	}

	public Report(String region, String country, String itemType, String saleChannel, String orderPriority,
			Date orderDate, String orderId, Date shipDate, int unitsSold, double unitPrice, double unitCost,
			double totalRevenue, double totalCost, double totalProfit) {
		this.region = region;
		this.country = country;
		this.itemType = itemType;
		this.saleChannel = saleChannel;
		this.orderPriority = orderPriority;
		this.orderDate = orderDate;
		this.orderId = orderId;
		this.shipDate = shipDate;
		this.unitsSold = unitsSold;
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.totalRevenue = totalRevenue;
		this.totalCost = totalCost;
		this.totalProfit = totalProfit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getSaleChannel() {
		return saleChannel;
	}

	public void setSaleChannel(String saleChannel) {
		this.saleChannel = saleChannel;
	}

	public String getOrderPriority() {
		return orderPriority;
	}

	public void setOrderPriority(String orderPriority) {
		this.orderPriority = orderPriority;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public int getUnitsSold() {
		return unitsSold;
	}

	public void setUnitsSold(int unitsSold) {
		this.unitsSold = unitsSold;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(double unitCost) {
		this.unitCost = unitCost;
	}

	public double getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(double totalRevenue) {
		this.totalRevenue = totalRevenue;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Report [id=" + id + ", region=" + region + ", country=" + country + ", itemType=" + itemType
				+ ", saleChannel=" + saleChannel + ", orderPriority=" + orderPriority + ", orderDate=" + orderDate
				+ ", orderId=" + orderId + ", shipDate=" + shipDate + ", unitsSold=" + unitsSold + ", unitPrice="
				+ unitPrice + ", unitCost=" + unitCost + ", totalRevenue=" + totalRevenue + ", totalCost=" + totalCost
				+ ", totalProfit=" + totalProfit + "]";
	}

}
