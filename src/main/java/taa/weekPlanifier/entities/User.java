package taa.weekPlanifier.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany
	private List<Address> addrs;


	public User() {
	}


	public User(String name) {
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


	public List<Address> getAddrs() {
		return addrs;
	}


	public void setAddrs(List<Address> addrs) {
		this.addrs = addrs;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", addrs=" + addrs + "]";
	}


	public User addAddrs(Address address) {
		if(this.addrs.contains(address))
			return this;
		this.addrs.add(address);
		return this;		
	}


}

