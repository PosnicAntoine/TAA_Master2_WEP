package taa.weekPlanifier.entities.dto;

import java.util.List;

import taa.weekPlanifier.entities.Address;
import taa.weekPlanifier.entities.User;

public class ActivityDTO {
	private Long id;
	private String name;
	private String description;
	private List<AddressDTO> addrs;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String desc) {
		this.description = desc;
	}
	
	public List<AddressDTO> getAddrs() {
		return addrs;
	}
	public void setAddrs(List<AddressDTO> addrs) {
		this.addrs = addrs;
	}
	
	@Override
	public String toString() {
		return "Activities [name=" + name + ", description=" + description + ", addrs=" + addrs + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
