package com.capgemini.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.dal.BankAccDAO;

public class CurrentAcc extends BankAcc{
	protected double odLimit;

	public CurrentAcc() {
		super();
		
	}
	
	

	public double getOdLimit() {
		return odLimit;
	}



	public void setOdLimit(double odLimit) {
		this.odLimit = odLimit;
	}



	public CurrentAcc(int accNo, String accName, double accBal,double odLimit) {
		super(accNo, accName, accBal);
		this.odLimit=odLimit;
		
	}



	@Override
	public void withdraw(int accNo,double amount) {
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("Context.xml");
		BankAccDAO accDao=(BankAccDAO) applicationContext.getBean("bankAccDAO");
		BankAcc bankAccount=accDao.getAccount(accNo);
		bankAccount.accBal-=amount;
		accDao.updateAccount(bankAccount);
		
	}
	
	
	

}
