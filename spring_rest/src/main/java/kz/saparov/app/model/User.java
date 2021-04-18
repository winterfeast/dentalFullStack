package kz.saparov.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import kz.saparov.app.entity.UserEntity;

public class User {
	
	private Long id;
	private String name;
	private String lastName;
	private String phone;
	private List<Tooth> teeth = new ArrayList<>();
	private List<Appointment> appointments = new ArrayList<>();
	
	public static User toModel(UserEntity user) {
		User model = new User();
		model.setId(user.getId());
		model.setName(user.getName());
		model.setLastName(user.getLastName());
		model.setPhone(user.getPhone());
		
		model.setTeeth(user.getTeeth().stream()
				           .map(a->Tooth.toModel(a))
				           .collect(Collectors.toList()));
		
		model.setAppointments(user.getAppointments().stream()
							      .map(a->Appointment.toModel(a))
							      .collect(Collectors.toList()));
		return model;
	}
	
	
	public static User UserListModel(UserEntity user) {
		User model = new User();
		model.setId(user.getId());
		model.setName(user.getName());
		model.setLastName(user.getLastName());
		model.setPhone(user.getPhone());
		return model;
	}
	
	public User() {}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public List<Tooth> getTeeth() {
		return teeth;
	}

	public void setTeeth(List<Tooth> teeth) {
		this.teeth = teeth;
	}
	
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + "]";
	}
	
}
