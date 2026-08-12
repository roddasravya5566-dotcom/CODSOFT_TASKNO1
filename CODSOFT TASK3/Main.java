import java.util.Scanner;

// Bank Account class
class BankAccount {
    private double balance;

    // Constructor
    BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Please collect your cash.");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}

// ATM class
class ATM {
    private BankAccount account;

    // Connect ATM with Bank Account
    ATM(BankAccount account) {
        this.account = account;
    }

    // Display ATM menu
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== ATM MACHINE =====");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹"
                            + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}

// Main class
public class Main {
    public static void main(String[] args) {

        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);

        // Connect account to ATM
        ATM atm = new ATM(account);

        // Start ATM
        atm.showMenu();
    }
}