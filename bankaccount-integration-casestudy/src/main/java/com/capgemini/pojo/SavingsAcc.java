package com.capgemini.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.dal.BankAccDAO;


public class SavingsAcc extends BankAcc{
	protected boolean isSalAcc;
	
	

	public SavingsAcc() {
		super();
		
	}



	public SavingsAcc(int accNo, String accName, double accBal, boolean isSalAcc) {
		super(accNo, accName, accBal);
		this.isSalAcc=isSalAcc;
	}





	public void setSalAcc(boolean isSalAcc) {
		this.isSalAcc = isSalAcc;
	}



	public boolean getisSalAcc() {
		return isSalAcc;
	}



	public void setisSalAcc(boolean isSalAcc) {
		this.isSalAcc = isSalAcc;
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
