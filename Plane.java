package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@NamedQueries({ @NamedQuery(name = "getAllPlanes", query = "from Plane"),
		@NamedQuery(name = "getPlaneById", query = "from Plane plane where plane.planeId = :id") })

@Component("plane")
@Entity
@Table(name = "planes")
public class Plane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLANE_ID")
	private int planeId;

	@NotEmpty(message = "Enter Plane Name")
	@Column(name = "PLANE_NAME", length = 10, unique = true)
	private String planeName;

	@OneToOne(mappedBy = "plane", cascade = CascadeType.ALL)
	private Hangar hangar;

	@OneToOne(mappedBy = "plane", cascade = CascadeType.ALL)
	private Pilot pilot;

	public Plane() {
		super();
	}

	public int getPlaneId() {
		return planeId;
	}

	public void setPlaneId(int planeId) {
		this.planeId = planeId;
	}

	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public Hangar getHangar() {
		return hangar;
	}

	public void setHangar(Hangar hangar) {
		this.hangar = hangar;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

}
