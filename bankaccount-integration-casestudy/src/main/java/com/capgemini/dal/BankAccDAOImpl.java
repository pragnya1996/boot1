package com.capgemini.dal;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.capgemini.pojo.BankAcc;

public class BankAccDAOImpl implements BankAccDAO {

	private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	public void addNewAccount(BankAcc acc) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction(); 
		session.persist(acc);
		 t.commit(); 
		session.close();
		
	}

	public void deleteAccount(int accNo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction t = session.beginTransaction();  
		Query query=session.createQuery("delete from BankAcc where id='"+accNo+"'");  
		query.executeUpdate(); 
		//specifying class name (Emp) not tablename  
		 query=session.createQuery("delete from SavingsAcc where id='"+accNo+"'");  
		query.executeUpdate();
	 query=session.createQuery("delete from CurrentAcc where id='"+accNo+"'");  
		query.executeUpdate();
		 t.commit(); 
		session.close();
		
	}

	public void updateAccount(BankAcc acc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction t = session.beginTransaction(); 
		session.update(acc);
		 t.commit(); 
		session.close();
		
	}

	public List<BankAcc> getAllAccount() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction t = session.beginTransaction();  
		List<BankAcc> accountList = session.createQuery("from BankAcc").list();
		
		 t.commit(); 
		session.close();
		return accountList;
		
	}

	

	public BankAcc getAccount(int accNo) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		Transaction t = session.beginTransaction();  
		String hql = "FROM BankAcc B WHERE B.id ='"+accNo+"'";
		Query query = session.createQuery(hql);
		List results = query.list();
		BankAcc b=null;
		b=(BankAcc)results.get(0);
		 t.commit(); 
		session.close();
		return b;
		
	}
	

}
