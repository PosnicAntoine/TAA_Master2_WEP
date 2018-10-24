package taa.weekPlanifier.entities.dto;

import java.util.List;


import taa.weekPlanifier.entities.Activity;


public class AddressDTO {
	private String type;
	private List<Activity> activities;
	private String country;
	private String city;
	private int cityNumber;
	private String street;
	private int streetNumber;
	private String complement;
	
	public AddressDTO() {
	}
	
	public AddressDTO(String type, String country, String city, int cityNumber, String street, int streetNumber,
			String complement) {
		super();
		this.type = type;
		this.country = country;
		this.city = city;
		this.cityNumber = cityNumber;
		this.street = street;
		this.streetNumber = streetNumber;
		this.complement = complement;
	}
	
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getCityNumber() {
		return cityNumber;
	}
	public void setCityNumber(int cityNumber) {
		this.cityNumber = cityNumber;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}

	
}
