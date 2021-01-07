package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminDao;
import com.model.Admin;
import com.model.Hangar;
import com.model.Pilot;
import com.model.Plane;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public List<Admin> getAllAdmins() {
		return adminDao.getAllAdmins();
	}

	@Override
	public boolean addPilot(Pilot pilot) {
		// logger.info("Saving pilot");
		return adminDao.addPilot(pilot);

	}

	@Override
	public boolean addPlane(Plane plane) {
		// logger.info("Adding plane");
		return adminDao.addPlane(plane);
	}

	@Override
	public boolean addHangar(Hangar hangar) {
		return adminDao.addHangar(hangar);
	}

	@Override
	public List<Pilot> getAllPilots() {
		return adminDao.getAllPilots();
	}

	@Override
	public List<Plane> getAllPlanes() {
		return adminDao.getAllPlanes();
	}

	@Override
	public List<Hangar> getAllHangars() {
		return adminDao.getAllHangars();
	}

	@Override
	public Pilot getPilotById(int pilotId) {
		return adminDao.getPilotById(pilotId);
	}

	@Override
	public Plane getPlaneById(int planeId) {
		return adminDao.getPlaneById(planeId);
	}

	@Override
	public Hangar getHangerById(int hangarId) {
		return adminDao.getHangerById(hangarId);
	}

	@Override
	public boolean addAdmin(Admin admin) {
		return adminDao.addAdmin(admin);
	}

	@Override
	public boolean managerApproval(int managerId) {
		return adminDao.managerApproval(managerId);
	}

}
