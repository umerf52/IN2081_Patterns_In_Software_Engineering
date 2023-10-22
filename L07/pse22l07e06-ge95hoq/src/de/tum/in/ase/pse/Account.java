package de.tum.in.ase.pse;

class Account {
	
	private int balance;

	Account(int amount) {
		balance = amount;
	}
	
	Account() {
		balance = 0;
	}

	public void deposit(int amount) {
		balance += amount;
	}
	
	private boolean canWithdraw(int amount) {
		return balance >= amount;
	}
	
	public void withdraw(int amount) throws BalanceException {
		if (!canWithdraw(amount))
			throw new BalanceException("Overdraw!");
		else {
			balance -= amount;
		}
	}
	
}


