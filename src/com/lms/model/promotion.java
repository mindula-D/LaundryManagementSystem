package com.lms.model;

public class promotion {

	public int getPromotionID() {
		return promotionID;
	}
	public void setPromotionID(int promotionID) {
		this.promotionID = promotionID;
	}
	public String getPromotionName() {
		return promotionName;
	}
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	
	
	public promotion(int promotionID, String promotionName) {
		super();
		this.promotionID = promotionID;
		this.promotionName = promotionName;
	}

	private int promotionID;
	private String promotionName;
	
}
