package taa.weekPlanifier.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import taa.weekPlanifier.entities.Activity;

@Transactional
public interface ActivityDAO extends JpaRepository<Activity, Long> {

}
