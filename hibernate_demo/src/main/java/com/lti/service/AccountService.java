package com.lti.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.lti.dao.AccountDao;
import com.lti.entity.Account;
import com.lti.entity.Activity;
import com.lti.exception.AccountException;

public class AccountService {
	public int openAccount(Account acc) throws AccountException  {
		if (acc.getBalance() >= 1000) {
			AccountDao dao = new AccountDao();
			Account newAcc=(Account)dao.save(acc);
			return newAcc.getAcnt_no();
		}
		else {
			throw new AccountException("Insufficient Funds*Dont pass Minimum Requirements*");
		}
	}

	public void withdraw(int acc_no, double amount) {
		AccountDao dao =new AccountDao();
		Account acc=(Account) dao.fetch(Account.class,acc_no);
		if(acc.getBalance()>amount) {
			Activity activity= new Activity();
			activity.setTx_amt(amount);
			activity.setTx_type("Withdrawl");
			activity.setTx_occ(LocalDateTime.now());
			activity.setAccount(acc);
			acc.setBalance(acc.getBalance()-amount);
			
			
			
			dao.save(acc);
			dao.save(activity);
			
		}
		else {
			throw new AccountException("Insufficient Balance");
		}
		

	}

	public void deposit(int acc_no, double amount) {AccountDao dao =new AccountDao();
	Account acc=(Account) dao.fetch(Account.class,acc_no);
	if(acc.getBalance()>amount) {
		Activity activity= new Activity();
		activity.setTx_amt(amount);
		activity.setTx_type("Deposit");
		activity.setTx_occ(LocalDateTime.now());
		activity.setAccount(acc);
		acc.setBalance(acc.getBalance()+amount);
		
		
		
		dao.save(acc);
		dao.save(activity);
		
	}
		

	}

	public void transfer(int fromAcc_no, int toAcc_no, double amount) {
		//deposit (toAcno, amount) ;
		AccountDao dao = new AccountDao();
		Account fromAccount = (Account)dao.fetch(Account.class,fromAcc_no);
		Account toAccount = (Account)dao.fetch(Account.class,toAcc_no);
		//if condition missing right now

		Activity fromAccountActivity = new Activity( );
		fromAccountActivity.setTx_amt(amount);;
		fromAccountActivity.setTx_type("Fund Transfer"); ;
		fromAccountActivity.setTx_occ(LocalDateTime.now()); ;
		fromAccountActivity . setAccount (fromAccount) ;

		Activity toAccountActivity = new Activity( ) ;
		toAccountActivity.setTx_amt(amount);
		toAccountActivity.setTx_type("Fund Recieved");;
		toAccountActivity.setTx_occ(LocalDateTime.now());
		toAccountActivity.setAccount (toAccount) ;
		
		fromAccount.setBalance(fromAccount.getBalance( )-amount ) ;
		toAccount.setBalance(fromAccount.getBalance( )+ amount);
		dao.save(fromAccount);
		dao.save(fromAccountActivity);
		dao.save(toAccount);
		dao.save(toAccountActivity);

	}

	

	public double balanceCheck(int acc_no) {
		AccountDao dao = new AccountDao();
			Account acc =(Account) dao.fetch(Account.class,acc_no);
		return acc.getBalance();
	}

	public List<Activity> ministatement(int acc_no) {
		AccountDao dao=new AccountDao();
		return dao.fetchMiniStatement(acc_no);
	}
	public List<Object[]> accountDetails(int acno,LocalDate date){
		AccountDao dao=new AccountDao();
		return dao.fetchAccountDetails(acno, date);
	}
	

}
	
