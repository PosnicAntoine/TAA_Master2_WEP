package taa.weekPlanifier.services.facade;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import taa.weekPlanifier.entities.User;
import taa.weekPlanifier.entities.dto.UserDTO;
import taa.weekPlanifier.services.UserDAO;

@Component
public class UserFacade {

	@Autowired
	private UserDAO userDao;

	@Autowired
	private ModelMapper modelMapper;
	
	@SuppressWarnings("null")
	public List<UserDTO> findAll() {
		List<UserDTO> res = null;
		for (User user : userDao.findAll()) {
			res.add(convertToUserDto(user));
		}
		return res;
	}
	
	public UserDTO getUserById(Long id) {
		return convertToUserDto(userDao.findById(id).get());
	}

	private UserDTO convertToUserDto(User user) {
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return userDto;
	}
}