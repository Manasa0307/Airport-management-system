package com.actions;

import java.util.NoSuchElementException;

import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.model.Admin;
import com.model.Hangar;
import com.model.Pilot;
import com.model.Plane;
import com.service.AdminService;
import com.service.ManagerService;
import com.service.SecurityService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
@SessionAttributes("sessionadmin")
public class AdminController {

	@Autowired
	ManagerService managerService;

	@Autowired
	AdminService adminService;

	@Autowired
	SecurityService securityService;

	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("admin", new Admin());
		
		return "adminlogin";
	}

	@RequestMapping(value = "/newadmin")
	public String registerAdmin(@ModelAttribute("admin") Admin admin) {
		return "adminregistration";
	}

	@RequestMapping(value = "/addadmin")
	public String addAdmin(@Valid @ModelAttribute("admin") Admin admin, Model model, BindingResult result) {

		try {
			if (result.hasErrors()) {
				return "adminregistration";
			} else {
				securityService.adminAuthenticate(admin);
				model.addAttribute("userexists", "User exists, try a different name");
				return "adminregistration";
			}
		} catch (NoSuchElementException ex) {
			adminService.addAdmin(admin);
			return "registered";
		}

	}

	@RequestMapping(value = "/authenticate")
	public String adminAuthenticate(@ModelAttribute("admin") Admin admin, Model model) {
		try {
			Admin sessionadmin = securityService.adminAuthenticate(admin);
			model.addAttribute("sessionadmin", sessionadmin);
			model.addAttribute("planes", adminService.getAllPlanes());
			return "viewplanes";
		} catch (NoSuchElementException exp) {
			model.addAttribute("nouser", "No such user, please register");
				return "adminregistration";
		}
	}

	@RequestMapping(value = "/pilot")
	public String pilot(Model model, @ModelAttribute("sessionadmin") Admin admin) {
		model.addAttribute("pilot", new Pilot());
		return "addpilot";
	}

	@RequestMapping(value = "/plane")
	public String plane(Model model, @ModelAttribute("sessionadmin") Admin admin) {
		model.addAttribute("plane", new Plane());
		return "addplane";
	}

	@RequestMapping(value = "/hangar")
	public String hangar(Model model, @ModelAttribute("sessionadmin") Admin admin) {
		model.addAttribute("hangar", new Hangar());
		return "addhangar";
	}

	@RequestMapping(value = "/addpilot")
	public String addPilot(@ModelAttribute("pilot") Pilot pilot, Model model) {
		try {
			adminService.addPilot(pilot);
			model.addAttribute("pilots", adminService.getAllPilots());
			return "viewpilots";
		} catch (PersistenceException ex) {
			model.addAttribute("exists", "Pilot already exists");
			return "addpilot";
		}
	}

	@RequestMapping(value = "/addplane")
	public String addPlane(@ModelAttribute("plane") Plane plane, Model model) {
		try {
			adminService.addPlane(plane);
			model.addAttribute("planes", adminService.getAllPlanes());
				return "viewplanes";
		} catch (PersistenceException ex) {
			model.addAttribute("exists", "Plane already exists");
			return "addplane";
		}
	}

	@RequestMapping(value = "/addhangar")
	public String addHangar(@ModelAttribute("hangar") Hangar hangar, Model model) {
		try {
			adminService.addHangar(hangar);
			model.addAttribute("hangars", adminService.getAllHangars());
			return "viewhangars";
		} catch (PersistenceException ex) {
			model.addAttribute("exists", "Hangar already exists");
			return "addhangar";
		}

	}

	@RequestMapping(value = "/viewhangars")
	public String viewHangars(@ModelAttribute("hangar") Hangar hangar, Model model) {
		model.addAttribute("hangars", adminService.getAllHangars());
		return "viewhangars";
	}

	@RequestMapping(value = "/viewplanes")
	public String viewHangars(@ModelAttribute("plane") Plane plane, Model model) {
		model.addAttribute("planes", adminService.getAllPlanes());
		return "viewplanes";
	}

	@RequestMapping(value = "/viewpilots")
	public String viewPilots(@ModelAttribute("pilot") Pilot pilot, Model model) {
		model.addAttribute("pilots", adminService.getAllPilots());
		return "viewpilots";
	}

	@RequestMapping("/managerentry")
	public String managerentry(@RequestParam("managerId") int managerId, Model model) {
		adminService.managerApproval(managerId);
		model.addAttribute("managers", managerService.getAllManagers());
		return "managerentry";
	}

	@RequestMapping("/getmanagers")
	public String getManagers(Model model) {
		model.addAttribute("managers", managerService.getAllManagers());
			return "managerentry";
	}

}
