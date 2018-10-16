package taa.weekPlanifier.entities.dto;

import java.util.List;

import taa.weekPlanifier.entities.Activity;

public class UserDTO {
	private Long id;
	private String name;
	
	private List<Activity> activities;


	public UserDTO() {
	}


	public UserDTO(String name) {
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


	public List<Activity> getActivities() {
		return activities;
	}


	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}


}
