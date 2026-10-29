import java.util.Scanner;

public class BankingSystem {

    static Scanner sc = new Scanner(System.in);

    static String name = "";
    static int accountNumber = 1001;
    static double balance = 0;
    static boolean accountCreated = false;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\nBanking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    showDetails();
                    break;

                case 6:
                    System.out.println("Thank you for using Banking System!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 6);

        sc.close();
    }

    static void createAccount() {

        if (accountCreated) {
            System.out.println("Account already exists.");
            return;
        }

        sc.nextLine();

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter initial deposit: ");
        double amount = sc.nextDouble();

        if (amount < 0) {
            System.out.println("Invalid amount.");
            return;
        }

        balance = amount;
        accountCreated = true;

        System.out.println("Account created successfully!");
        System.out.println("Your account number is: " + accountNumber);
    }

    static void depositMoney() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Money deposited successfully.");
            System.out.println("Current balance: Rs. " + balance);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    static void withdrawMoney() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Enter a valid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Withdrawal successful.");
            System.out.println("Remaining balance: Rs. " + balance);
        }
    }

    static void checkBalance() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.println("Your balance is: Rs. " + balance);
    }

    static void showDetails() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.println("\nAccount Details");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: Rs. " + balance);
    }
}