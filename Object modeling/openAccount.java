import java.util.ArrayList;

class Account {
    private int accountNumber;
    private double balance;
    private Bank bank;

    public Account(int accountNumber, Bank bank) {
        this.accountNumber = accountNumber;
        this.bank = bank;
        this.balance = 0.0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public Bank getBank() {
        return bank;
    }
}

class Customer {
    private String name;
    private ArrayList<Account> accounts = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewBalance() {
        for (Account acc : accounts) {
            System.out.println("Account " + acc.getAccountNumber() + " at " + acc.getBank().getName() + " Balance: " + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}

class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>();
    private int nextAccountNumber = 1001;

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void openAccount(Customer customer) {
        Account newAccount = new Account(nextAccountNumber++, this);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer);
        }
        System.out.println("Account " + newAccount.getAccountNumber() + " opened for " + customer.getName() + " at " + name);
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank1 = new Bank("State Bank");
        Bank bank2 = new Bank("HDFC Bank");

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        bank1.openAccount(c1);
        bank1.openAccount(c2);
        bank2.openAccount(c1);

        c1.viewBalance();
        c2.viewBalance();
    }
}
