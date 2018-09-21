package taa.weekPlanifier.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import taa.weekPlanifier.entities.Address;

@Transactional
public interface AddressDAO extends JpaRepository<Address, Long> {


}
