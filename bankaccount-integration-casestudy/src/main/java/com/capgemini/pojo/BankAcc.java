package com.capgemini.pojo;

public abstract class BankAcc {
	protected int accNo;
	protected String accName;
	protected double accBal;
	
	BankAcc()
	{
		
	}

	public BankAcc(int accNo, String accName, double accBal) {
		this.accNo = accNo;
		this.accName = accName;
		this.accBal = accBal;
	}
	public abstract void withdraw(int accNo,double amount);
	
	public void deposit(double amount)
	{
		
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public int getAccNo() {
		return accNo;
	}
	
	public void setAccNo(int accNo) {
		this.accNo=accNo;
	}

	public double getAccBal() {
		return accBal;
	}

	@Override
	public String toString() {
		return "BankAcc [accNo=" + accNo + ", accName=" + accName + ", accBal="
				+ accBal + "]";
	}

	public void setAccBal(double accBal2) {
		this.accBal=accBal2;
		
	}
	
	

}
