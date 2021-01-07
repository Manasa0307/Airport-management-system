package com.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.actions.AdminController;
import com.model.Admin;
import com.model.Hangar;
import com.model.Manager;
import com.model.Pilot;
import com.model.Plane;

@Repository("adminDao")
@Transactional
@SuppressWarnings("unchecked")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ManagerDao managerDao;

	
	@Override
	public List<Admin> getAllAdmins() {
		Session session = sessionFactory.getCurrentSession();
			return (List<Admin>) session.createNamedQuery("getAllAdmins").getResultList();
	}

	@Override
	public boolean addPilot(Pilot pilot) {
		Session session = sessionFactory.getCurrentSession();
		session.save(pilot);
			return true;
	}

	@Override
	public boolean addPlane(Plane plane) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(plane);
		return true;
	}

	@Override
	public boolean addHangar(Hangar hangar) {
		Session session = sessionFactory.getCurrentSession();
		session.save(hangar);
		return true;
	}

	@Override
	public List<Pilot> getAllPilots() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Pilot>) session.createNamedQuery("getAllPilots").getResultList();
	}

	@Override
	public List<Plane> getAllPlanes() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Plane>) session.createNamedQuery("getAllPlanes").getResultList();
	}

	@Override
	public List<Hangar> getAllHangars() {
		Session session = sessionFactory.getCurrentSession();
		return (List<Hangar>) session.createNamedQuery("getAllHangars").getResultList();
	}

	@Override
	public Pilot getPilotById(int pilotId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNamedQuery("getPilotById");
		return (Pilot) query.setParameter("id", pilotId).getSingleResult();

	}

	@Override
	public Plane getPlaneById(int planeId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNamedQuery("getPlaneById");
		return (Plane) query.setParameter("id", planeId).getSingleResult();
	}

	@Override
	public Hangar getHangerById(int hangarId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createNamedQuery("getHangarById");
		return (Hangar) query.setParameter("id", hangarId).getSingleResult();

	}

	@Override
	public boolean addAdmin(Admin admin) {
		Session session = sessionFactory.getCurrentSession();
		session.save(admin);
		return true;
	}

	@Override
	public boolean managerApproval(int managerId) {
		Session session = sessionFactory.getCurrentSession();
		Manager manager = session.load(Manager.class, managerId);
		manager.setApprovalStatus("Approved");
		session.update(manager);
		return true;
	}

}
