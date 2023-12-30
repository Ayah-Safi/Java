import java.util.Scanner;
public class BankTest {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        // Create 3 bank accounts
        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();
        BankAccount bankAccount3 = new BankAccount();

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        System.out.println(bankAccount1.deposit(300));
        System.out.println(bankAccount1.deposit(100));
      

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
        System.out.println(bankAccount1.withdraw(200));
        System.out.println(bankAccount1.getBalance());
        scanner.close();
      


        // Static Test (print the number of bank accounts and the totalMoney)
        int numberOfAccounts = BankAccount.getAccounts();
        double totalMoney = BankAccount.getTotalMoney();
        System.out.println("Number of accounts: " + numberOfAccounts);
        System.out.println("Total money: " + totalMoney);

    }
}