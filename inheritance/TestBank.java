class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Critical method should not be overridden
    public final void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    // Cannot override displayBalance() because it is final
    // public void displayBalance() { ... } // ❌ Compilation error
}

public class TestBank {
    public static void main(String[] args) {
        SavingsAccount acc = new SavingsAccount(1000);
        acc.displayBalance(); // Works fine
        acc.deposit(500);
        acc.displayBalance();
    }
}
