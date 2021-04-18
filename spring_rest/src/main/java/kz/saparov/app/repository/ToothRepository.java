package kz.saparov.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.saparov.app.entity.ToothEntity;

@Repository
public interface ToothRepository extends JpaRepository<ToothEntity, Long>{
	
}
