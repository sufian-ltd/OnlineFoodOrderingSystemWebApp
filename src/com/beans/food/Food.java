package com.beans.food;

import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.http.Part;

public class Food {

	private int id;
	private String catagory;
	private String foodName;
	private int foodPrice;
	private InputStream foodImage;
	private Blob foodImageBlob;
	
	private String base64Image;
	private String numOfFood;
	public String getBase64Image() {
		return base64Image;
	}
	public String getNumOfFood() {
		return numOfFood;
	}
	public void setNumOfFood(String numOfFood) {
		this.numOfFood = numOfFood;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	@Override
	public String toString() {
		return "Food [id=" + id + ", catagory=" + catagory + ", foodName=" + foodName + ", foodPrice=" + foodPrice
				+ ", foodImage=" + foodImage + "]";
	}
	public Blob getFoodImageBlob() {
		return foodImageBlob;
	}
	public void setFoodImageBlob(Blob foodImageBlob) {
		this.foodImageBlob = foodImageBlob;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public InputStream getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(InputStream foodImage) {
		this.foodImage = foodImage;
	}
	public Food(int id, String catagory, String foodName, int foodPrice, InputStream foodImage) {
		super();
		this.id = id;
		this.catagory = catagory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
	}
	public Food(String catagory, String foodName, int foodPrice, InputStream foodImage) {
		super();
		this.catagory = catagory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImage = foodImage;
	}
	public Food(int id, String catagory, String foodName, int foodPrice, Blob foodImageBlob) {
		super();
		this.id = id;
		this.catagory = catagory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodImageBlob = foodImageBlob;
	}
	public Food(int id, String catagory, String foodName, int foodPrice, String base64Image) {
		super();
		this.id = id;
		this.catagory = catagory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.base64Image = base64Image;
	}
	public Food(String catagory, String foodName, int foodPrice, String base64Image) {
		super();
		this.catagory = catagory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.base64Image = base64Image;
	}
	public Food(int id, String foodName, int foodPrice, String base64Image) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.base64Image = base64Image;
	}
	public Food(int id, String catagory, String foodName, int foodPrice, String base64Image, String numOfFood) {
		super();
		this.id = id;
		this.catagory = catagory;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.base64Image = base64Image;
		this.numOfFood = numOfFood;
	}
}
