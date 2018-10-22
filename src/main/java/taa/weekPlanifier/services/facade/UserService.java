package taa.weekPlanifier.services.facade;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import taa.weekPlanifier.entities.User;
import taa.weekPlanifier.entities.dto.UserDTO;
import taa.weekPlanifier.services.UserDAO;

@Component
public class UserService {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private ModelMapper modelMapper;

	public String create(UserDTO userDto) {
		String userId = "";
		User userCreate = convertToUser(userDto);
		try {
			userDao.save(userCreate);
			userId = String.valueOf(userCreate.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

	public String update(Long id, UserDTO userDto) {
		User userUpdated = convertToUser(userDto);
		userUpdated.setId(id);
		try {
			if (userDao.findById(id).isPresent())
				return "Unknown user: " + userUpdated.getId();
			else
				userDao.save(userUpdated);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	public String delete(long id) {
	    try {
	        userDao.delete(userDao.findById(id).get());
	      }
	      catch (Exception ex) {
	        return "Error deleting the user:" + ex.toString();
	      }
	      return "User succesfully deleted!";
	}

	public UserDTO getUser(Long id) {
		return convertToUserDto(userDao.findById(id).get());
	}
	
	public List<UserDTO> getAllUser() {
		List<UserDTO> res = new ArrayList<UserDTO>();
		for (User user : userDao.findAll()) {
			res.add(convertToUserDto(user));
		}
		return res;
	}


	private UserDTO convertToUserDto(User user) {
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return userDto;
	}

	private User convertToUser(UserDTO userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
}