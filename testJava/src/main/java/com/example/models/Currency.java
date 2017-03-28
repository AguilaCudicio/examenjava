package com.example.models;

public class Currency {

	private float buy;
	private float sell;
	private String date;

	public Currency(float b, float s, String d) {
	        this.setBuy(b);
	        this.setSell(s);
	        this.setDate(d);
	}

	public float getBuy() {
		return buy;
	}

	public void setBuy(float buy) {
		this.buy = buy;
	}

	public float getSell() {
		return sell;
	}

	public void setSell(float sell) {
		this.sell = sell;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
