import java.util.Scanner;

public class BankAccountSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Account[] accounts = new Account[3];
        accounts[0] = new SavingsAccount(1000, "SAV-001", 0.02);
        accounts[1] = new CheckingAccount(500, "CHK-001", -500);
        accounts[2] = new SavingsAccount(2000, "SAV-002", 0.03);

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = input.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();
                    Account account = findAccount(accountNumber, accounts);
                    if (account == null) {
                        System.out.println("Invalid account number.");
                    } else {
                        account.deposit(amount);
                        System.out.println("Deposit successful.");
                    }
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = input.nextLine();
                    System.out.print("Enter amount: ");
                    amount = input.nextDouble();
                    account = findAccount(accountNumber, accounts);
                    if (account == null) {
                        System.out.println("Invalid account number.");
                    } else if (account instanceof SavingsAccount) {
                        SavingsAccount savingsAccount = (SavingsAccount) account;
                        if (savingsAccount.withdraw(amount)) {
                            System.out.println("Withdraw successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else if (account instanceof CheckingAccount) {
                        CheckingAccount checkingAccount = (CheckingAccount) account;
                        if (checkingAccount.withdraw(amount)) {
                            System.out.println("Withdraw successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = input.nextLine();
                    account = findAccount(accountNumber, accounts);
                    if (account == null) {
                        System.out.println("Invalid account number.");
                    } else {
                        System.out.println("Balance: " + account.getBalance());
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using our system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        }
    }
    public static Account findAccount(String accountNumber, Account[] accounts) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}