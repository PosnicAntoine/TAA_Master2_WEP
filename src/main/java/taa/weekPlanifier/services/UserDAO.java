package taa.weekPlanifier.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import taa.weekPlanifier.entities.User;

@Transactional
public interface UserDAO extends JpaRepository<User, Long> {
  

}
