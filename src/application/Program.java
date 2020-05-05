package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.entities.Account;
import model.entities.BusinessAccount;
import model.entities.SavingsAccount;
import model.enums.Banks;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		ArrayList<Account> account = new ArrayList<>();

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date d1 = sdf.parse("04/05/2020");
			Date d2 = sdf.parse("04/05/2016");

			account.add(new SavingsAccount(0100, "João", 1000.0, Banks.BRASIL, 100.0, d1));
			account.add(new SavingsAccount((SavingsAccount) account.get(0)));
			account.add(new BusinessAccount(0101, "Maria", 2000.0, Banks.BRADESCO, 200.0, d2));
			account.add(new BusinessAccount((BusinessAccount) account.get(2)));

			account.get(0).withdraw(500);
			account.get(2).withdraw(100);
			account.get(2).transfer(account.get(0), 300);

			for (Account a : account)
				System.out.println(a.toString());

		} catch (ParseException e) {
			System.out.println("Invalid date format");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		} finally {
			account = null;
		}

	}

}
