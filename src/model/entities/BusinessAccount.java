package model.entities;

import model.enums.Banks;
import model.exceptions.DomainException;

public class BusinessAccount extends Account{
	
	double withdrawLimit;
	
	public BusinessAccount() {
		super();
	}

	public BusinessAccount(int number, String holder, double balance, Banks bank, double withdrawLimit) {
		super(number,holder,balance,bank);
		this.withdrawLimit = withdrawLimit;
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount > balance) throw new DomainException("Withdraw greater than balance");//WithdrawGreaterThenBalance;
		if(amount > withdrawLimit) throw new DomainException("Withdraw limit exceeded");//WithdrawLimitExceeded;
		balance -= amount;
	}
	
	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
}
