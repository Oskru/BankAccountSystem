import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSystem {

    private static ArrayList<Account> accounts = new ArrayList<>();
    private static int accountCount = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        accounts.add(new SavingsAccount(1000, "SAV-001", 0.02));
        accounts.add(new CheckingAccount(500, "CHK-001", -500));
        accounts.add(new SavingsAccount(2000, "SAV-002", 0.03));

        while (true) {
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Check exchange rate");
            System.out.println("5. Add account");
            System.out.println("6. Exit");
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
                    System.out.print("Enter currency code (e.g EUR, JPY): ");
                    String currency = input.nextLine();
                    try {
                        double rate = ExchangeRateAPI.getExchangeRate(currency);
                        System.out.println("1 USD = " + rate + " " + currency);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    addAccount(input);
                    break;
                case 6:
                    System.out.println("Thank you for using our system.");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
            System.out.println();
        }
    }
    public static Account findAccount(String accountNumber, ArrayList<Account> accounts) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
    private static void addAccount(Scanner input) {
        System.out.print("Enter account type (S for savings, C for checking): ");
        char type = input.nextLine().charAt(0);
        if (type != 'S' && type != 'C') {
            System.out.println("Invalid account type.");
            return;
        }
        System.out.print("Enter account number: ");
        String accountNumber = input.nextLine();
        System.out.print("Enter starting balance: ");
        double balance = input.nextDouble();
        if (type == 'S') {
            System.out.print("Enter interest rate: ");
            double interestRate = input.nextDouble();
            accounts.add(new SavingsAccount(balance, accountNumber, interestRate));
            System.out.println("Savings account created.");
        } else {
            System.out.print("Enter overdraft limit: ");
            double overdraftLimit = input.nextDouble();
            accounts.add(new CheckingAccount(balance, accountNumber, overdraftLimit));
            System.out.println("Checking account created.");
        }
    }
}