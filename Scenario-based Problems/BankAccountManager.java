class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
            System.out.println("Initial balance cannot be negative. Setting to 0.");
        }
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive!");
        }
    }

    // Withdraw method with overdraft check
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient balance! Withdrawal denied.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive!");
        }
    }

    // Check balance method
    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber + " | Current Balance: " + balance);
    }
}

// Main class for testing
public class BankAccountManager {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000);

        account.checkBalance();
        account.deposit(500);
        account.withdraw(200);
        account.withdraw(2000); // overdraft test
        account.checkBalance();
    }
}
