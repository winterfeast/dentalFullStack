package kz.saparov.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kz.saparov.app.entity.AppointmentEntity;
import kz.saparov.app.entity.UserEntity;
import kz.saparov.app.exception.ResourceNotFoundException;
import kz.saparov.app.model.Appointment;
import kz.saparov.app.repository.AppointmentRepository;
import kz.saparov.app.repository.UserRepository;
import kz.saparov.app.util.AppointmentFinder;

@Service
public class AppointmentService {
	
	private AppointmentRepository appointmentRepository;
	private UserRepository userRepository;

	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository, UserRepository userRepository) {
		this.appointmentRepository = appointmentRepository;
		this.userRepository = userRepository;
	}
	
	
	public Appointment createAppointment(AppointmentEntity appointment, Long id) {
		UserEntity user = userRepository.findById(id)
		          .orElseThrow(()-> new ResourceNotFoundException("Пациент с id:" + id + " не найден"));
		appointment.setUser(user);
		return Appointment.toModel(appointmentRepository.save(appointment));
	}
	
	
	public Appointment findById(Long id) {
		
		AppointmentEntity appointment = appointmentRepository.findById(id)
		          .orElseThrow(()-> new ResourceNotFoundException("Запись с id:" + id + " не найден"));
		return Appointment.toModel(appointment);
	}
	
	
	public List<Appointment> findByStatusAndPeriod(AppointmentFinder finder) {
		List<Appointment> list = appointmentRepository.findByStatusAndDateTimeBetween(finder.getStatus(), 
																					  finder.getStartDate(), 
																					  finder.getEndDate()).stream()
				                  .map(a->Appointment.toModel(a))
				                  .collect(Collectors.toList());
		return list;
	}
	
	

}
