package taa.weekPlanifier.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Address {
	@Id
	@GeneratedValue
	private long id;
	private String type;
	@ManyToMany(mappedBy= "addrs")
	private List<Activity> activities;
	@ManyToMany(mappedBy= "addrs")
	private List<User> users;
	private String country;
	private String city;
	private int cityNumber;
	private String street;
	private int streetNumber;
	private String complement;
	
	public Address() {
	}
	
	public Address(String type, String country, String city, int cityNumber, String street, int streetNumber,
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
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", type=" + type + ", activities=" + activities + ", users=" + users + 
				", country=" + country	+ ", city=" + city + ", cityNumber=" + cityNumber + ", street="
				+ street + ", streetNumber=" + streetNumber + ", complement=" + complement + "]";
	}

	public Address addUsers(User user) {
		if(this.users.contains(user))
			return this;
		this.users.add(user);
		return this;
		
	}

	public Address addActivity(Activity activity) {
		if(this.activities.contains(activity))
			return this;
		this.activities.add(activity);
		return this;
	}
	
}
