package taa.weekPlanifier.entities.dto;

import java.util.List;

import taa.weekPlanifier.entities.Address;
import taa.weekPlanifier.entities.User;

public class ActivityDTO {
	private String name;
	private String description;
	private List<Address> addrs;
	private List<User> users;
	
	public ActivityDTO() {
		
	}
	
	public ActivityDTO(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String desc) {
		this.description = desc;
	}
	
	public List<Address> getAddrs() {
		return addrs;
	}
	public void setAddrs(List<Address> addrs) {
		this.addrs = addrs;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "Activities [name=" + name + ", desc=" + description + ", addrs=" + addrs + "]";
	}
}
