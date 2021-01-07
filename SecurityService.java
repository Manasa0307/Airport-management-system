package com.service;

import com.model.Admin;
import com.model.Manager;

public interface SecurityService {

	public Admin adminAuthenticate(Admin admin);

	public Manager managerAuthenticate(Manager manager);

}
