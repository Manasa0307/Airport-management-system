package com.main;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.model.Admin;
import com.model.Hangar;
import com.model.Manager;
import com.model.Pilot;
import com.model.Plane;

@Transactional
public class Main {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure("com/config/hibernate.cfg.xml");
				
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Admin admin = new Admin();
		admin.setAdminFirstName("manasa");
		admin.setAdminLastName("boya");
		admin.setAdminAge(20);
		admin.setAdminContactNumber(123);
		admin.setAdminGender("female");
		admin.setAdminPassword("Manasa@123");
		session.save(admin);
		Manager manager = new Manager();
		manager.setManagerFirstName("manasa");
		manager.setManagerLastName("boya");
		manager.setManagerGender("female");
		manager.setManagerAge(20);
		manager.setManagerContactNumber(456);
		manager.setManagerPassword("Manasa@123");
		session.save(manager);
		Plane plane = new Plane();
		plane.setPlaneName("Boeing");
		Hangar hangar = new Hangar();
		hangar.setPlane(plane);
		hangar.setHangarLocation("1A");
		Pilot pilot = new Pilot();
		pilot.setPilotName("Manasa");
		pilot.setPilotLocation("Anantapur");
		pilot.setPlane(plane);
		session.save(plane);
		session.save(pilot);
		session.save(hangar);
	}

}
