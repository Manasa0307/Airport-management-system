package com.dao;

import java.util.List;

import com.model.Hangar;
import com.model.Manager;
import com.model.Pilot;
import com.model.Plane;

public interface ManagerDao {
	public List<Manager> getAllManagers();
	
	public boolean addManager(Manager manager);

	public boolean allotPilotToPlane(int pilotId, int planeId);

	public boolean allotHangarToPlane(int hangarId, int planeId);

}
