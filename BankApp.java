import java.util.Scanner;

class Account {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    Account (String cname, String cid) {
        customerName = cname;
        customerId = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }
    void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Not enough funds");
        } else if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction was made");
        }
    }
        void calculateInterest(int years) {
            double interestRate = 0.0185;
            double newBalance = (balance * interestRate * years) + balance;
            System.out.println("The current interest rate is " + (100 * interestRate) + "%");
            System.out.println("After" + years + " years, you balance will be: " + newBalance);
    }
    void showMenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerId);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = sc.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch(option) {

                case 'A':
                    System.out.println("------------------------");
                    System.out.println("Balance = $" + balance);
                    System.out.println("------------------------");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = sc.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                case 'D':
                    System.out.println();
                    getPreviousTransaction();
                    System.out.println();
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter how many years of accured interest: ");
                    int years = sc.nextInt();
                    calculateInterest(years);
                    break;
                case 'F':
                    System.out.println();
                    break;
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F");
                }
            } while (option != 'F');
                System.out.println("Thank you for using this application!");            
    }
}


public class BankApp {
    public static void main(String[] args) {
        Account User1 = new Account("George Washington", "A0001");
        User1.showMenu();

        Account User2 = new Account("LeBron James", "A0023");
        User2.showMenu();

        Account User3 = new Account("Lionel Messi", "A0010");
        User3.showMenu();

        Account User4 = new Account("Rohit Sharma", "A0045");
        User4.showMenu();
    }
}
