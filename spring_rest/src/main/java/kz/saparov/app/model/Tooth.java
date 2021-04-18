package kz.saparov.app.model;

import kz.saparov.app.entity.ToothEntity;

public class Tooth {
	private Long id;
	private Integer number;
	private Integer condition;
	private String comment;
	
	public static Tooth toModel(ToothEntity tooth) {
		Tooth model = new Tooth();
		model.setId(tooth.getId());
		model.setNumber(tooth.getNumber());
		model.setCondition(tooth.getCondition());
		model.setComment(tooth.getComment());
		return model;
	}
	
	public Tooth() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getCondition() {
		return condition;
	}

	public void setCondition(Integer condition) {
		this.condition = condition;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
