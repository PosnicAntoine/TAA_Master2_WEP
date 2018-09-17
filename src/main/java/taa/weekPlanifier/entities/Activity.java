package taa.weekPlanifier.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Activity {
	@Id
	@Column(name="ID")
	private String name;
	private String desc;
	@ManyToMany(mappedBy= "activities")
	private List<Address> addrs;
	@ManyToMany(mappedBy= "activities")
	private List<User> users;
	
	public Activity(String name) {
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
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public List<Address> getAddrs() {
		return addrs;
	}
	public void setAddrs(List<Address> addrs) {
		this.addrs = addrs;
	}
	@Override
	public String toString() {
		return "Activities [name=" + name + ", desc=" + desc + ", addrs=" + addrs + "]";
	}
}
