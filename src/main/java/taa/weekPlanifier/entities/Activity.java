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
	@ManyToMany
	private List<Address> addrs;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
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
		return "Activities [id=" + id +", name=" + name + ", description=" + description + ", addrs=" + addrs + "]";
	}

	public Activity addAddrs(Address address) {
		if(this.addrs.contains(address))
			return this;
		this.addrs.add(address);
		return this;
	}
}
