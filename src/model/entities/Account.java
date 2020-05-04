package model.entities;

import model.enums.Banks;
import model.exceptions.DomainException;

public abstract class Account {

	private final int number;
	private final String holder; 
	protected double balance;
	private final Banks bank;

	public Account() {
		this.number = 0;
		this.holder = null;
		this.bank = null;
	}

	public Account(int number, String holder, double balance, Banks bank) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.bank =  bank;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if((amount+5.0) > balance) throw new DomainException("Withdraw greater than balance");//WithdrawGreaterThenBalance;
		balance -= (amount + 5.0);
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

}
