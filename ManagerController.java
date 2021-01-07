package com.actions;

import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dao.AdminDao;
import com.model.Manager;
import com.service.AdminService;
import com.service.ManagerService;
import com.service.SecurityService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/manager")
@SessionAttributes("sessionmanager")
public class ManagerController {

	@Autowired
	AdminService adminService;

	@Autowired
	ManagerService managerService;

	@Autowired
	SecurityService securityService;

	@Autowired
	AdminDao adminDao;

	
	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("manager", new Manager());
			return "managerlogin";
	}

	@RequestMapping(value = "/newmanager")
	public String registerManager(@ModelAttribute("manager") Manager manager) {
		return "managerregistration";
	}

	@RequestMapping(value = "/addmanager")
	public String addAdmin(@Valid @ModelAttribute("manager") Manager manager, Model model, BindingResult result) {
		try {
			if (result.hasErrors()) {
				return "managerregistration";
			} else {
				securityService.managerAuthenticate(manager);
				model.addAttribute("userexists", "User exists, try a different name");
				return "managerregistration";
			}
		} catch (NoSuchElementException exp) {
			managerService.addManager(manager);
				return "registered";
		}
	}

	@RequestMapping(value = "/authenticate")
	public String adminAuthenticate(@ModelAttribute("manager") Manager manager, Model model) {
		try {
			Manager sessionmanager = securityService.managerAuthenticate(manager);
			sessionmanager.getApprovalStatus().equals("Approved");
			model.addAttribute("sessionmanager", sessionmanager);
			model.addAttribute("planes", adminDao.getAllPlanes());
				return "allotplanes";
		} catch (NoSuchElementException exp) {
			model.addAttribute("nouser", "No such user, please register");
			return "managerregistration";
		} catch (NullPointerException exp) {
			model.addAttribute("accessdenied", "Manager yet to be approved");
			return "managerlogin";
		}
	}

	@RequestMapping(value = "/pilot")
	public String fetchHangar(Model model, @RequestParam("planeId") int planeId) {
		model.addAttribute("pilots", adminService.getAllPilots());
		model.addAttribute("planeId", planeId);
		return "allotpilots";
	}

	@RequestMapping(value = "/hangar")
	public String hangar(Model model, @RequestParam("planeId") int planeId) {
		model.addAttribute("hangars", adminService.getAllHangars());
		model.addAttribute("planeId", planeId);
		return "allothangars";
	}

	@RequestMapping(value = "/allotpilot")
	public String allotPilot(@RequestParam("planeId") int planeId, @RequestParam("pilotId") int pilotId, Model model) {
		managerService.allotPilotToPlane(pilotId, planeId);
		model.addAttribute("planes", adminDao.getAllPlanes());
			return "allotplanes";
	}

	@RequestMapping(value = "/allothangar")
	public String allotHangar(@RequestParam("planeId") int planeId, @RequestParam("hangarId") int hangarId,
			Model model) {
		managerService.allotHangarToPlane(hangarId, planeId);
		model.addAttribute("planes", adminDao.getAllPlanes());
		return "allotplanes";
	}

	@RequestMapping(value = "/allotplane")
	public String allotPlane(Model model) {
		model.addAttribute("planes", adminDao.getAllPlanes());
		return "allotplanes";
	}

}
