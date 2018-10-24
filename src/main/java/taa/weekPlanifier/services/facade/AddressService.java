package taa.weekPlanifier.services.facade;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import taa.weekPlanifier.entities.Address;
import taa.weekPlanifier.entities.dto.AddressDTO;
import taa.weekPlanifier.services.AddressDAO;

@Component
public class AddressService {

	@Autowired
	private AddressDAO addressDao;

	@Autowired
	private ModelMapper modelMapper;

	public String create(AddressDTO addressDto) {
		String addressId = "";
		Address addressCreate = convertToAddress(addressDto);
		try {
			addressDao.save(addressCreate);
			addressId = String.valueOf(addressCreate.getId());
		} catch (Exception ex) {
			return "Error creating the address: " + ex.toString();
		}
		return "Address succesfully created with id = " + addressId;
	}

	public String update(Long id, AddressDTO addressDto) {
		Address addressUpdated = convertToAddress(addressDto);
		addressUpdated.setId(id);
		try {
			if (addressDao.findById(id).isPresent())
				return "Unknown address: " + addressUpdated.getId();
			else
				addressDao.save(addressUpdated);
		} catch (Exception ex) {
			return "Error updating the address: " + ex.toString();
		}
		return "Address succesfully updated!";
	}

	public String delete(long id) {
	    try {
	        addressDao.delete(addressDao.findById(id).get());
	      }
	      catch (Exception ex) {
	        return "Error deleting the address:" + ex.toString();
	      }
	      return "Address succesfully deleted!";
	}

	public AddressDTO getAddress(Long id) {
		return convertToAddressDto(addressDao.findById(id).get());
	}
	
	public List<AddressDTO> getAllAddress() {
		List<AddressDTO> res = new ArrayList<AddressDTO>();
		for (Address address : addressDao.findAll()) {
			res.add(convertToAddressDto(address));
		}
		return res;
	}


	private AddressDTO convertToAddressDto(Address address) {
		AddressDTO addressDto = modelMapper.map(address, AddressDTO.class);
		return addressDto;
	}

	private Address convertToAddress(AddressDTO addressDto) {
		Address address = modelMapper.map(addressDto, Address.class);
		return address;
	}
}