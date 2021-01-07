package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

@NamedQueries({ @NamedQuery(name = "getAllPilots", query = "from Pilot"),
		@NamedQuery(name = "getPilotById", query = "from Pilot pilot where pilot.pilotId = :id") })

@Component("pilot")
@Entity
@Table(name = "pilots")
public class Pilot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PILOT_ID")
	private int pilotId;

	@Column(name = "PILOT_NAME", length = 20, unique = true)
	@NotEmpty(message = "Enter Pilot Name")
	@Min(value = 5)
	private String pilotName;

	@Column(name = "PILOT_LOCATION", length = 10)
	private String pilotLocation;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLANE_ID")
	private Plane plane;

	public Pilot() {
		super();
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	public int getPilotId() {
		return pilotId;
	}

	public void setPilotId(int pilotId) {
		this.pilotId = pilotId;
	}

	public String getPilotName() {
		return pilotName;
	}

	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}

	public String getPilotLocation() {
		return pilotLocation;
	}

	public void setPilotLocation(String pilotLocation) {
		this.pilotLocation = pilotLocation;
	}

}
