package ssc;

import java.util.Scanner;

// Bank Account Class
class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully!");
        }
    }

    public double getBalance() {
        return balance;
    }
}


// ATM Class
class ATM {

    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void start() {

        int choice;

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        do {

            System.out.println("\n--------- ATM MENU ---------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();

                    account.deposit(depositAmount);

                    System.out.println("Current Balance: ₹"
                            + account.getBalance());
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();

                    account.withdraw(withdrawAmount);

                    System.out.println("Current Balance: ₹"
                            + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 4);
    }

    public void checkBalance() {
        System.out.println("Your current balance is: ₹"
                + account.getBalance());
    }
}


// Main Class
public class Atminterface {

    public static void main(String[] args) {

        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);

        // Connect account with ATM
        ATM atm = new ATM(account);

        // Start ATM
        atm.start();
    }
}


