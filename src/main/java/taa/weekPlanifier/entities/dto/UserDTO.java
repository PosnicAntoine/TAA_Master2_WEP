package taa.weekPlanifier.entities.dto;

import java.util.List;

import taa.weekPlanifier.entities.Activity;
import taa.weekPlanifier.entities.Address;

public class UserDTO {
	private Long id;
	private String name;
	
	private List<AddressDTO> addrs;


	public UserDTO() {
	}


	public UserDTO(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public List<AddressDTO> getAddrs() {
		return addrs;
	}


	public void setAddrs(List<AddressDTO> addrs) {
		this.addrs = addrs;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


}
