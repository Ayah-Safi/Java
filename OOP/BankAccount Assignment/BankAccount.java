import java.util.Scanner;
import java.io.StringReader;
import java.util.Random;


public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    // Ninja Bonus 1: Add the following class attribute: account number. The type is up to you, can be a String or a Long or another type.
    private String accountNumber = "";

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
    public BankAccount(){
        accounts++;
        generateAccountNumber();
    }

    // GETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public static int getAccounts(){
        return accounts;
    }
    public static double getTotalMoney(){
        return totalMoney;
    }

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public double deposit(double amountOfMoney) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type 'Checking' to deposit into Checking Account or type 'Saving' to deposit into Saving Account:");
        String accountType = scanner.nextLine();
        if (accountType.equalsIgnoreCase("Checking")) {
            this.checkingBalance += amountOfMoney;
            totalMoney += amountOfMoney; 
            return this.checkingBalance;
        } else if (accountType.equalsIgnoreCase("Saving")) {
            this.savingsBalance += amountOfMoney;
            totalMoney += amountOfMoney; 
            return this.savingsBalance;
        } else {
            System.out.println("Invalid account type entered.");
            return -1; 
        }
    }

    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public double withdraw(double amountOfMoney) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type 'Checking' to withdrow from Checking Account or type 'Saving' to withdrow from Saving Account:");
        String accountType = scanner.nextLine();
        if (accountType.equalsIgnoreCase("Checking")&&(amountOfMoney <=  this.checkingBalance)) {
            this.checkingBalance -= amountOfMoney;
            totalMoney -= amountOfMoney; 
            return this.checkingBalance;
        } else if (accountType.equalsIgnoreCase("Saving")&&(amountOfMoney  <= this.savingsBalance)) {
            this.savingsBalance -= amountOfMoney;
            totalMoney -= amountOfMoney; 
            return this.savingsBalance;
        } else {
            System.out.println("Invalid account type entered or invalid balance");
            return -1; 
        }
    }

    
  
    // getBalance
    // - display total balance for checking and savings of a particular bank account
    public double getBalance(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please type 'Checking' to display Checking Account Balance or type 'Saving' to display Saving Account Balance:");
        String accountType = scanner.nextLine();
        if (accountType.equalsIgnoreCase("Checking")) {
        return this.checkingBalance;
    } else if (accountType.equalsIgnoreCase("Saving")) {
        return this.savingsBalance;
    } else {
        System.out.println("Invalid account type entered");
        return -1; 
    }
        

    }

    // Ninja Bonus 2: Create a private method that returns a random ten digit account number.
    private String generateAccountNumber(){
        int i = 0;
        Random random = new Random();
        while(i < 10){
            int randomNumber = random.nextInt(10);
            this.accountNumber = String.valueOf(randomNumber)+accountNumber;
            i++;
        }
        return this.accountNumber;
    }
}