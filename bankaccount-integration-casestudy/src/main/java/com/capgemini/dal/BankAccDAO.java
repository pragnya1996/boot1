package com.capgemini.dal;

import java.util.List;

import com.capgemini.pojo.BankAcc;

public interface BankAccDAO {
	public void addNewAccount(BankAcc acc);
	public void deleteAccount(int accNo);
	public void updateAccount(BankAcc acc);
	public List<BankAcc> getAllAccount();
	
	public BankAcc getAccount(int accNo);
	
	
	

}
