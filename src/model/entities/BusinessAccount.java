package model.entities;

import java.util.Date;

import model.enums.Banks;
import model.exceptions.DomainException;

public class BusinessAccount extends Account {

	private double withdrawLimit;

	public BusinessAccount() {
		super();
	}

	public BusinessAccount(int number, String holder, double balance, Banks bank, double withdrawLimit,
			Date memberSince) {
		super(number, holder, balance, bank, memberSince);
		this.withdrawLimit = withdrawLimit;
	}

	public BusinessAccount(BusinessAccount ba) {
		super(ba.getNumber(), ba.getHolder(), ba.getBalance(), ba.getBank(), ba.getMemberSince());
		this.withdrawLimit = ba.withdrawLimit;
	}

	@Override
	public void withdraw(double amount) {
		if (amount > getBalance())
			throw new DomainException("Withdraw greater than balance");
		if (amount > withdrawLimit)
			throw new DomainException("Withdraw limit exceeded");
		balance -= (amount + 5.0);
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
}
