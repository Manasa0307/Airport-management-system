package com.dao;

import java.util.List;
import com.model.Admin;
import com.model.Hangar;
import com.model.Manager;
import com.model.Pilot;
import com.model.Plane;

public interface AdminDao {

	public List<Admin> getAllAdmins();

	public boolean addAdmin(Admin admin);

	public boolean addPilot(Pilot pilot);

	public boolean addPlane(Plane plane);

	public boolean addHangar(Hangar hangar);

	public List<Pilot> getAllPilots();

	public List<Plane> getAllPlanes();

	public List<Hangar> getAllHangars();

	public Pilot getPilotById(int pilotId);

	public Plane getPlaneById(int planeId);

	public Hangar getHangerById(int hangarId);

	public boolean managerApproval(int managerId);
}
