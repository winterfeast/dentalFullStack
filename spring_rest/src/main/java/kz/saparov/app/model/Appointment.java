package kz.saparov.app.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import kz.saparov.app.entity.AppointmentEntity;
import kz.saparov.app.entity.UserEntity;

public class Appointment {
	private Long id;
	private String dateTime;
	private Integer status;
	private String comment;
	private Long userId;
	private String userFullName;
	private String adminUser;
	
	public static Appointment toModel(AppointmentEntity appointment) {
		Appointment model = new Appointment();
		model.setId(appointment.getId());
		model.setDateTime(appointment.getDateTime());
		model.setStatus(appointment.getStatus());
		model.setComment(appointment.getComment());
		
		UserEntity user = appointment.getUser();
		model.setUserId(user.getId());
		model.setUserFullName(user.getLastName() + " " + user.getName());
		return model;
	}

	public Appointment() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").format(dateTime);
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	
}
