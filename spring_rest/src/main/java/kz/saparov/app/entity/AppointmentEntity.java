package kz.saparov.app.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="appointments")
public class AppointmentEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@Column(name="date_time")
	private LocalDateTime dateTime;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="comment")
	private String comment;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity user;
	
	public AppointmentEntity() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}