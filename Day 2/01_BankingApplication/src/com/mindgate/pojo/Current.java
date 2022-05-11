package com.mindgate.pojo;

public class Current extends Account {
	private double overdraftBalance;

	public Current() {
		System.out.println("Default Consturctor of Current");
	}

	public Current(int accountNumber, String name, double balance, double overdraftBalance) {
		super(accountNumber, name, balance);
		this.overdraftBalance = overdraftBalance;
	}

	public double getOverdraftBalance() {
		return overdraftBalance;
	}

	public void setOverdraftBalance(double overdraftBalance) {
		this.overdraftBalance = overdraftBalance;
	}
	
	@Override
	public boolean withdraw(double amount) {
		if(amount <= getBalance()) {
			setBalance(getBalance()-amount);
			return true;
		}
		if(amount > getBalance() && getBalance() < 0) {
			setBalance(getBalance() - amount);
		}
			int temp = (int) getBalance();
			setBalance(0);
//			if(getBalance() < 0) {
//				setBalance(getBalance()); 
//			int temp = (int) getBalance();
//			setBalance(temp);
			if(getBalance() == 0) {
			setOverdraftBalance(getOverdraftBalance() + temp);
			return true;
			}
		return false;
	}
	
	
	@Override
	public boolean deposit(double amount) {
		return false;
	}
	
	
	@Override
	public String toString() {
		return "Current [overdraftBalance=" + overdraftBalance + ", toString()=" + super.toString() + "]";
	}
	
	
}
