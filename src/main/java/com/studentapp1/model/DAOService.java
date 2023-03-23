package com.studentapp1.model;

public interface DAOService {
	public void connectionDB();
	public boolean verifyCredentials(String email,String password);
	
	public void saveReg(String name,String city,String email,String mobile);
	

}
