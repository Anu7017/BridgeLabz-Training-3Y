class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient balance!");
    }

    public void display() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavings() {
        System.out.println("Savings Account Holder: " + accountHolder + ", Account Number: " + accountNumber + ", Interest Rate: " + interestRate + "%");
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("AC12345", "Ankit", 5000.0, 5.5);
        sa.display();
        sa.deposit(2000);
        sa.display();
        sa.withdraw(1000);
        sa.displaySavings();
        System.out.println("Final Balance: " + sa.getBalance());
    }
}
