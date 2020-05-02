package model.entities;

import model.enums.Banks;
import model.exceptions.DomainException;

public abstract class SavingsAccount extends Account{
 
	double interestRate;
	
	public SavingsAccount() {
		super();
	}

	public SavingsAccount(int number, String holder, double balance, Banks bank, double interestRate) {
		super(number,holder,balance,bank);
		this.interestRate = interestRate;
		
	}
	
	@Override
	public void withdraw(double amount) {
		if(amount > balance) throw new DomainException("Withdraw greater than balance");//WithdrawGreaterThenBalance;
		balance -= amount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
}
