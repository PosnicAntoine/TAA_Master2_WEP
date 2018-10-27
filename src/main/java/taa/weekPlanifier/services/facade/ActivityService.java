package taa.weekPlanifier.services.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import taa.weekPlanifier.entities.Activity;
import taa.weekPlanifier.entities.Address;
import taa.weekPlanifier.entities.User;
import taa.weekPlanifier.entities.dto.ActivityDTO;
import taa.weekPlanifier.services.ActivityDAO;
import taa.weekPlanifier.services.AddressDAO;

@Component
public class ActivityService {

	@Autowired
	private ActivityDAO activityDao;
	@Autowired
	private AddressDAO addressDao;

	@Autowired
	private ModelMapper modelMapper;

	public String create(ActivityDTO activityDto) {
		Activity activityCreate = convertToActivity(activityDto);
		activityCreate.setId(null);
		try {
			activityDao.save(activityCreate);
		} catch (Exception ex) {
			return "Error creating the activity: " + ex.toString();
		}
		return "Activity succesfully created.";
	}

	public String update(Long id, ActivityDTO activityDto) {
		Activity activityUpdated = convertToActivity(activityDto);
		activityUpdated.setId(id);
		try {
			if (!activityDao.findById(id).isPresent())
				return "Unknown activity: " + activityUpdated.getId();
			else
				activityDao.save(activityUpdated);
		} catch (Exception ex) {
			return "Error updating the activity: " + ex.toString();
		}
		return "Activity succesfully updated!";
	}
	

	public String addAddress(Long id, Long idAddress) {
		Optional<Activity> activityCurrent = activityDao.findById(id);
		Optional<Address> addressCurrent = addressDao.findById(idAddress);
		try {
			if (!activityCurrent.isPresent())
				return "Unknown activity: " + id;
			if (!addressCurrent.isPresent())
				return "Unknown address: "+ idAddress;
			activityDao.save(activityCurrent.get().addAddrs(addressCurrent.get()));
			addressDao.save(addressCurrent.get().addActivity(activityCurrent.get()));
		} catch (Exception ex) {
			return "Error updating the activity: " + ex.toString();
		}
		return "Activity succesfully updated!";
	}

	public String delete(long id) {
	    try {
	        activityDao.delete(activityDao.findById(id).get());
	      }
	      catch (Exception ex) {
	        return "Error deleting the activity:" + ex.toString();
	      }
	      return "Activity succesfully deleted!";
	}

	public ActivityDTO getActivity(Long id) {
		return convertToActivityDto(activityDao.findById(id).get());
	}
	
	public List<ActivityDTO> getAllActivity() {
		List<ActivityDTO> res = new ArrayList<ActivityDTO>();
		for (Activity activity : activityDao.findAll()) {
			res.add(convertToActivityDto(activity));
		}
		return res;
	}


	private ActivityDTO convertToActivityDto(Activity activity) {
		System.out.println("Activity to ActivityDTO");
		ActivityDTO activityDto = modelMapper.map(activity, ActivityDTO.class);
		return activityDto;
	}

	private Activity convertToActivity(ActivityDTO activityDto) {
		System.out.println("ActivityDTO to Activity");
		Activity activity = modelMapper.map(activityDto, Activity.class);
		return activity;
	}
}