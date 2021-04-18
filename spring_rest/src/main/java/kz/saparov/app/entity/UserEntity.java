package kz.saparov.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="users")
public class UserEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone")
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<ToothEntity> teeth = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user",fetch = FetchType.LAZY)
	@JsonIgnore
	private List<AppointmentEntity> appointments = new ArrayList<>();
	
	public UserEntity() {}
	
	public UserEntity(String name, String lastName, String phone) {
		this.name = name;
		this.lastName = lastName;
		this.phone = phone;
	}

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

	public List<ToothEntity> getTeeth() {
		return teeth;
	}

	public void setTeeth(List<ToothEntity> teeth) {
		this.teeth = teeth;
	}

	public List<AppointmentEntity> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentEntity> appointments) {
		this.appointments = appointments;
	}	
}
