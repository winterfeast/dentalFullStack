package kz.saparov.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kz.saparov.app.entity.AppointmentEntity;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long>{
	
	List<AppointmentEntity> findByStatusAndDateTimeBetween(Integer status,LocalDateTime start, LocalDateTime end);

}
