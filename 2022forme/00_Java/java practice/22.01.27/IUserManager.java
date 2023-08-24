package com.ssafy.hw10.step2;

import java.util.ArrayList;

public interface IUserManager {
	void add(User user);
	ArrayList<User> getList();
	ArrayList<User> getUsers();
	ArrayList<VipUser> getVipUsers();
	ArrayList<User> searchByName(String name);
	double getAgeAvg();
	void saveData();
	void loadData();
	
}
