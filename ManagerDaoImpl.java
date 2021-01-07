package com.dao;

import java.util.List;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Admin;
import com.model.Hangar;
import com.model.Manager;
import com.model.Pilot;
import com.model.Plane;

@Repository("managerDao")
@Transactional
@SuppressWarnings("unchecked")
public class ManagerDaoImpl implements ManagerDao {

	@Autowired
	SessionFactory sessionFactory;

	
	@Override
	public List<Manager> getAllManagers() {
		Session session = sessionFactory.getCurrentSession();
		
		return (List<Manager>) session.createNamedQuery("getAllManagers").getResultList();
	}

	@Override
	public boolean allotPilotToPlane(int pilotId, int planeId) {
		Session session = sessionFactory.getCurrentSession();
		Pilot pilot = session.load(Pilot.class, pilotId);
		Plane plane = session.load(Plane.class, planeId);
		pilot.setPlane(plane);
		plane.setPilot(pilot);
		session.update(pilot);
		session.update(plane);
		return true;
	}

	@Override
	public boolean allotHangarToPlane(int hangarId, int planeId) {
		Session session = sessionFactory.getCurrentSession();
		Hangar hangar = session.load(Hangar.class, hangarId);
		Plane plane = session.load(Plane.class, planeId);
		hangar.setPlane(plane);
		plane.setHangar(hangar);
		session.update(hangar);
		session.update(plane);
		return true;
	}

	@Override
	public boolean addManager(Manager manager) {
		Session session = sessionFactory.getCurrentSession();
		session.save(manager);
			return true;
	}

}
