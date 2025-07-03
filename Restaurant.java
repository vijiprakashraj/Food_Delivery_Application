package com.dao.foodApplication.model;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private String cuisineType;
	private int deliveryTime;
	private String address;
	private float ratings;
	private boolean isActive;
	private String imgPath;
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public int getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
	
	
	public Restaurant() {
		super();
	}
	public Restaurant(int restaurantId, String name, String cuisineType, int deliveryTime, String address,
			float ratings, boolean isActive, String imgPath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.cuisineType = cuisineType;
		this.deliveryTime = deliveryTime;
		this.address = address;
		this.ratings = ratings;
		this.isActive = isActive;
		this.imgPath = imgPath;
	}
	@Override
	public String toString() {
		return  restaurantId + "    " + name + "    " + cuisineType
				+ "   " + deliveryTime + "    " + address + "   " + ratings + "    "
				+ isActive + "     " + imgPath ;
	}
	
	
	
	

}
