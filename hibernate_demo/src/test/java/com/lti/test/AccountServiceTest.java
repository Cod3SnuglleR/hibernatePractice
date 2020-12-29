package com.lti.test;



import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.entity.Account;
import com.lti.entity.Activity;
import com.lti.service.AccountService;
import com.lti.exception.*;

public class AccountServiceTest {
	

	@Test
	public void testingOfOpeningAnAccount( ) {
	Account acc = new Account ( ) ;
	acc.setCus_name("Tanmay");
	acc.setBalance(100000);
	acc.setAcnt_typ("Savings");
	
	
	AccountService accServ = new AccountService( );
	int acno=accServ.openAccount(acc);
	System.out.println(acno);//do'nt do this re this is manual testing we want automated
	accServ. openAccount (acc) ;

}
	@Test
	public void testingOfOpeningAnAccountPvTestCase( ) {
	Account acc = new Account ( ) ;
	acc.setCus_name("Tanay");
	acc.setBalance(1000);

	acc.setAcnt_typ("Savings");
	AccountService accServ = new AccountService( );
	accServ. openAccount (acc) ;
}
	@Test(expected=AccountException.class)
	public void testingOfOpeningAnAccountNgTestCase( ) {
	Account acc = new Account ( ) ;
	acc.setCus_name("Taay");
	acc.setBalance(10000);

	acc.setAcnt_typ("Savings");
	AccountService accServ = new AccountService( );
	accServ. openAccount (acc) ;
}
	@Test
	public void testingOfWithdrawingMoney() {
		AccountService accServ=new AccountService();
		int acno = 0;
		double currentBalance=accServ.balanceCheck(acno);
		double amountTowithdraw=1000;
		double expectedBalance=currentBalance-amountTowithdraw;
		accServ.withdraw(acno, amountTowithdraw);
		double actualBalance =accServ.balanceCheck(acno);
		assertTrue(expectedBalance==actualBalance);
	}
	@Test
	public void miniStatementTest() {
		AccountService service=new AccountService();
		List<Activity> activity=service.ministatement(121);
		for(Activity obj:activity) {
			System.out.println(obj.getAccount().getAcnt_no());
			System.out.println(obj.getTr_no());
			System.out.println(obj.getTx_type());
			System.out.println(obj.getTx_amt());
			System.out.println("___________________________________________________");
		}
		@Test
		public void testingOfFetchingAccountDetails() {
			AccountService accServ =new AccountService();
			List<Object[]> list=accServ.accountDetails(111, LocalDate.of(2020,11,21));
			for(Object[] arr:list) {
				System.out.println(arr[0]+" ,"+arr[1]+" ,"+arr[2]);
				System.out.println("-------------------");
			}
		}
	}
}

