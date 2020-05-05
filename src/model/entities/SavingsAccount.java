package model.entities;

import java.util.Date;

import model.enums.Banks;
import model.exceptions.DomainException;

public class SavingsAccount extends Account {

	double interestRate;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(int number, String holder, double balance, Banks bank, double interestRate,
			Date memberSince) {
		super(number, holder, balance, bank, memberSince);
		this.interestRate = interestRate;

	}

	public SavingsAccount(SavingsAccount sa) {
		super(sa.getNumber(), sa.getHolder(), sa.getBalance(), sa.getBank(), sa.getMemberSince());
		this.interestRate = sa.getInterestRate();
	}

	@Override
	public void withdraw(double amount) {
		if (amount > balance)
			throw new DomainException("Withdraw greater than balance");
		balance -= amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
