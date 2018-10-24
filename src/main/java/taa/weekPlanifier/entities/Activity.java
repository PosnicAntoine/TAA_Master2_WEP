package taa.weekPlanifier.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Activity {
	@Id
	@GeneratedValue
	private Long id;
	@Column(unique=true)
	private String name;
	private String description;
	@ManyToMany(mappedBy= "activities")
	private List<Address> addrs;
	@ManyToMany(mappedBy= "activities")
	private List<User> users;
	
	public Activity() {
		
	}
	
	public Activity(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Activities [id=" + id +", name=" + name + ", desc=" + description + ", addrs=" + addrs + "]";
	}
}
