package com.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ManagerDao;
import com.model.Manager;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerDao managerDao;

	@Override
	public List<Manager> getAllManagers() {
		return managerDao.getAllManagers();
	}

	@Override
	public boolean allotPilotToPlane(int pilotId, int planeId) {
		return managerDao.allotPilotToPlane(pilotId, planeId);
	}

	@Override
	public boolean allotHangarToPlane(int hangarId, int planeId) {
		return managerDao.allotHangarToPlane(hangarId, planeId);
	}

	@Override
	public boolean addManager(Manager manager) {
		return managerDao.addManager(manager);
	}

}
