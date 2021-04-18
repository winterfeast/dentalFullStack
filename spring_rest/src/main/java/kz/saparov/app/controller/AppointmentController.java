package kz.saparov.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kz.saparov.app.entity.AppointmentEntity;
import kz.saparov.app.model.Appointment;
import kz.saparov.app.service.AppointmentService;
import kz.saparov.app.util.AppointmentFinder;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	
	private AppointmentService appointmentService;

	@Autowired
	public AppointmentController(AppointmentService appointmentService) {
		this.appointmentService = appointmentService;
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<Appointment> createAppointment(@RequestBody AppointmentEntity appointment,
														 @PathVariable Long userId) {
		Appointment savedAppontment = appointmentService.createAppointment(appointment, userId);
		return ResponseEntity.ok(savedAppontment);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public List<Appointment> findByStatusAndDates(@RequestBody AppointmentFinder finder) {
		return appointmentService.findByStatusAndPeriod(finder);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
	public ResponseEntity<Appointment> findById(@PathVariable Long id) {
		Appointment appointment = appointmentService.findById(id);
		return ResponseEntity.ok(appointment);
	}
	
}
