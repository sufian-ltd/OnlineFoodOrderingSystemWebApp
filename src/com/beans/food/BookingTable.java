package com.beans.food;

import java.sql.Date;
import java.sql.Time;

public class BookingTable {

	private int contact;
	private Time time;
	private Date date;
	private int persons;
	private int advance;
	private int due;
	private int cost;
	private int foods;
	public BookingTable(int contact, Time time, Date date, int persons, int advance, int due, int cost, int foods) {
		super();
		this.contact = contact;
		this.time = time;
		this.date = date;
		this.persons = persons;
		this.advance = advance;
		this.due = due;
		this.cost = cost;
		this.foods = foods;
	}
	@Override
	public String toString() {
		return "BookingTable [contact=" + contact + ", time=" + time + ", date=" + date + ", persons=" + persons
				+ ", advance=" + advance + ", due=" + due + ", cost=" + cost + ", foods=" + foods + "]";
	}
	public int getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public int getAdvance() {
		return advance;
	}
	public void setAdvance(int advance) {
		this.advance = advance;
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
	public int getFoods() {
		return foods;
	}
	public void setFoods(int foods) {
		this.foods = foods;
	}
}
