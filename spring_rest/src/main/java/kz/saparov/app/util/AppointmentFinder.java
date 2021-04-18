package kz.saparov.app.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppointmentFinder {
	
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private Integer status;
	
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	
	public AppointmentFinder(){}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		startDate += " 00:00";
		this.startDate = LocalDateTime.parse(startDate, formatter);
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		endDate += " 23:59";
		this.endDate = LocalDateTime.parse(endDate, formatter);
	}

	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
