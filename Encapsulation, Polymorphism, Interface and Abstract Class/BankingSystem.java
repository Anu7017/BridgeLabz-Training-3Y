import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account No: " + accountNumber + ", Holder: " + holderName + ", Balance: " + balance);
    }
}

// Interface
interface Loanable {
    void applyForLoan(double amount);
    String calculateLoanEligibility();
}

// SavingsAccount Class
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * interestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Savings Account Loan Applied: " + amount);
    }

    @Override
    public String calculateLoanEligibility() {
        return getBalance() >= 5000 ? "Eligible for loan" : "Not eligible for loan";
    }
}

// CurrentAccount Class
class CurrentAccount extends BankAccount implements Loanable {
    private double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public double calculateInterest() {
        return getBalance() * 0.01; // very low interest
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println("Current Account Loan Applied: " + amount);
    }

    @Override
    public String calculateLoanEligibility() {
        return getBalance() + overdraftLimit >= 10000 ? "Eligible for loan" : "Not eligible for loan";
    }
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        SavingsAccount sa = new SavingsAccount("SA1001", "Alice", 10000, 0.04);
        CurrentAccount ca = new CurrentAccount("CA2001", "Bob", 3000, 5000);

        accounts.add(sa);
        accounts.add(ca);

        for (BankAccount acc : accounts) {
            acc.displayDetails();
            System.out.println("Interest: " + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(20000);
                System.out.println("Loan Status: " + loanAcc.calculateLoanEligibility());
            }

            acc.deposit(2000);
            acc.withdraw(1500);

            System.
