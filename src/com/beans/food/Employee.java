package com.beans.food;

public class Employee {

	private int id;
	private String name;
	private String address;
	private String contact;
	private int salary;
	public Employee(int id, String name, String address, String contact, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", contact=" + contact + ", salary="
				+ salary + "]";
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(String name, String address, String contact, int salary) {
		super();
		this.name = name;
		this.address = address;
		this.contact = contact;
		this.salary = salary;
	}
}
