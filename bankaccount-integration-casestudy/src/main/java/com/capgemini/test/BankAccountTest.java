package com.capgemini.test;

import java.util.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.capgemini.dal.BankAccDAOImpl;
import com.capgemini.pojo.BankAcc;
import com.capgemini.pojo.CurrentAcc;
import com.capgemini.pojo.SavingsAcc;






public class BankAccountTest {
	
	
	
	

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int SavingsAccChoice=0,typeChoice=0;
		
		String name;
		double accBal;
		while(true)
		{
			System.out.println("Enter 1-add user\n2-retreive all user\n3-Delete account\n4-update account\n9-exit");
			int choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter name and opening Balance");
				name=sc.next();
				accBal=sc.nextDouble();
				System.out.println("Enter 1 for creating a Savings account\nEnter 2 for creating a Current account");
				 typeChoice=sc.nextInt();
				if(typeChoice==1)
				{
					System.out.println("Enter 1-Salaried account\n2-Non-Salaried Account");
					 SavingsAccChoice=sc.nextInt();
				}
				if(typeChoice==2)
				{
					BankAccountTest.addCurrenntAccount(name,accBal);
				}
				else if(typeChoice==1 && SavingsAccChoice==1)
				{
					BankAccountTest.addSavingsSalaried(name,accBal);
				}
				else
				{
					BankAccountTest.addSavingsNonSalaried(name,accBal);
				}
				break;
				
			case 2:
				System.out.println("The List of accounts is:\n\n");
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
				BankAccDAOImpl dao=context.getBean(BankAccDAOImpl.class);
				List<BankAcc> bank=dao.getAllAccount();
				
				for(BankAcc p : bank){
					System.out.println("\n\nBank List::"+p);
				}
				break;
			case 3:
				ClassPathXmlApplicationContext context1 = new ClassPathXmlApplicationContext("context.xml");
				BankAccDAOImpl dao1=context1.getBean(BankAccDAOImpl.class);
				System.out.println("Enter the id to delete:\n\n");
				int ch=sc.nextInt();
				dao1.deleteAccount(ch);
				break;
			case 4:
				System.out.println("Enter your id and name to update");
				int id=sc.nextInt();
				String nameupdate=sc.next();
				ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext("context.xml");
				BankAccDAOImpl dao2=context2.getBean(BankAccDAOImpl.class);
				
				
				
				
				BankAcc bank1=dao2.getAccount(id);
				bank1.setAccName(nameupdate);
				
				dao2.updateAccount(bank1);
				break;
				
				
				
			default:
				return;
			}
		}

		
		}

	public static void addSavingsNonSalaried(String name, double accBal) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SavingsAcc bank=new SavingsAcc();
		bank.setAccName(name);
		bank.setAccBal(accBal);
		bank.setisSalAcc(false);
		BankAccDAOImpl dao=context.getBean(BankAccDAOImpl.class);
		dao.addNewAccount(bank);
		
	}

	public static void addSavingsSalaried(String name, double accBal) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SavingsAcc bank=new SavingsAcc();
		bank.setAccName(name);
		bank.setAccBal(accBal);
		bank.setisSalAcc(true);
		BankAccDAOImpl dao=context.getBean(BankAccDAOImpl.class);
		dao.addNewAccount(bank);
	}
	public static void addCurrenntAccount(String name, double accBal)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		CurrentAcc bank=new CurrentAcc();
		bank.setAccName(name);
		bank.setAccBal(accBal);
		bank.setOdLimit(5000);
		BankAccDAOImpl dao=context.getBean(BankAccDAOImpl.class);
		dao.addNewAccount(bank);
	}	

	}


