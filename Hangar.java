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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@NamedQueries({ @NamedQuery(name = "getAllHangars", query = "from Hangar"),
		@NamedQuery(name = "getHangerById", query = "from Hangar hangar where hangar.hangarId = :id") })

@Component("hangar")
@Entity
@Table(name = "hangars")
public class Hangar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "HANGAR_ID")
	private int hangarId;

	@Column(name = "HANGAR_LOCATION", length = 10, unique = true)
	@NotEmpty(message = "Enter Location")
	private String hangarLocation;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLANE_ID")
	private Plane plane;

	public Hangar() {
		super();
	}

	public int getHangarId() {
		return hangarId;
	}

	public void setHangarId(int hangarId) {
		this.hangarId = hangarId;
	}

	public String getHangarLocation() {
		return hangarLocation;
	}

	public void setHangarLocation(String hangarLocation) {
		this.hangarLocation = hangarLocation;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

}
