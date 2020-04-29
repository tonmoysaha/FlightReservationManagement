package com.flightreservation.entity;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PersistentLoginToken extends AbstractEntity {
	
	private  String username;
	private  String series;
	private  String tokenValue;
	private  Date date;
	
	
	public PersistentLoginToken() {
	}


	public PersistentLoginToken(String username, String series, String tokenValue, Date date) {
		this.username = username;
		this.series = series;
		this.tokenValue = tokenValue;
		this.date = date;
	}


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getTokenValue() {
		return tokenValue;
	}
	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	


}
