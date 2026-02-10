class BankAccount {
    protected double balance;
    public BankAccount(double balance) {
        this.balance = balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public double getBalance() {
        return balance;
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }
    @Override
    public void withdraw(double amount) {
        if (balance - amount < 100) {
            System.out.println("Withdrawal denied! Minimum balance of 100 must be maintained.");
        } else {
            super.withdraw(amount);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        SavingsAccount account = new SavingsAccount(500);
        account.deposit(200);
        account.withdraw(550);   
        account.withdraw(100);   
        System.out.println("Current balance: " + account.getBalance());
    }
}
