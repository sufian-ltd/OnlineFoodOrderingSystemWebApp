package com.beans.food;

public class Customer {

	int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private String address;
	private String cellNo;
	private int advancePayment;
	private int due;
	private int cost;
	private String service;
	int numberOfFood;
	public Customer(String name, String address, String cellNo, int advancePayment, int due, int cost, String service,
			int numberOfFood) {
		super();
		this.name = name;
		this.address = address;
		this.cellNo = cellNo;
		this.advancePayment = advancePayment;
		this.due = due;
		this.cost = cost;
		this.service = service;
		this.numberOfFood = numberOfFood;
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", cellNo=" + cellNo + ", advancePayment="
				+ advancePayment + ", due=" + due + ", cost=" + cost + ", service=" + service + ", numberOfFood="
				+ numberOfFood + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public int getAdvancePayment() {
		return advancePayment;
	}
	public void setAdvancePayment(int advancePayment) {
		this.advancePayment = advancePayment;
	}
	public int getDue() {
		return due;
	}
	public void setDue(int due) {
		this.due = due;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getNumberOfFood() {
		return numberOfFood;
	}
	public void setNumberOfFood(int numberOfFood) {
		this.numberOfFood = numberOfFood;
	}
	public Customer(int id, String name, String address, String cellNo, int advancePayment, int due, int cost,
			String service, int numberOfFood) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.cellNo = cellNo;
		this.advancePayment = advancePayment;
		this.due = due;
		this.cost = cost;
		this.service = service;
		this.numberOfFood = numberOfFood;
	}
}
