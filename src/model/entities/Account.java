package model.entities;

import java.util.Date;

import model.enums.Banks;
import model.exceptions.DomainException;

public abstract class Account {

	private final int number;
	private final String holder;
	protected double balance;
	private final Banks bank;
	private final Date memberSince;

	public Account() {
		this.number = 0;
		this.holder = null;
		this.bank = null;
		this.memberSince = null;
	}

	public Account(int number, String holder, double balance, Banks bank, Date memberSince) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.bank = bank;
		this.memberSince = memberSince;
	}

	public Account(Account a) {
		number = a.getNumber();
		holder = a.getHolder();
		balance = a.getBalance();
		bank = a.getBank();
		memberSince = a.getMemberSince();
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposit successful");
	}

	public void withdraw(double amount) {
		if ((amount + 5.0) > balance)
			throw new DomainException("Withdraw greater than balance");// WithdrawGreaterThenBalance;
		balance -= (amount + 5.0);
		System.out.println("Withdraw successful");
	}

	public void transfer(Account dest, double amount) {
		balance -= amount;
		dest.deposit(amount);
		System.out.println("Transfer successful \nInfo:\n Transfering R$" + String.format("%.2f", amount) + " to "
				+ dest.holder + " from " + holder);
	}

	public int getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public double getBalance() {
		return balance;
	}

	public Banks getBank() {
		return bank;
	}

	public Date getMemberSince() {
		return memberSince;
	}

	@Override
	public String toString() {
		return "Account [number= " + number + ", holder= " + holder + ", balance= " + String.format("%.2f", balance)
				+ ", bank= " + bank + ", member since= " + memberSince + "]";
	}

}
