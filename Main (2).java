import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}

class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount account) {
        bankAccount = account;
    }

    public void checkBalance() {
        System.out.println("Your current balance: $" + bankAccount.getBalance());
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
    }

    public void withdraw(double amount) {
        bankAccount.withdraw(amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(bankAccount);

        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Exiting the ATM.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
                        }
                          }
}