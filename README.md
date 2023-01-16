# Bank Account System

## Description

This is a simple Java console application project that simulates a basic bank account system, where a user can create different types of accounts (e.g savings, checking) and perform basic transactions (e.g deposit, withdraw). The project demonstrates the use of polymorphism, inheritance, interfaces, abstract classes, and casting. It also allows the user to check exchange rates of different currencies using an external API.

## How to use

1. Clone or download the project to your local machine.
2. Open the project in your preferred Java IDE.
3. Run the `BankAccountSystem` class.
4. Follow the prompts to create and manage accounts.
5. Use the "Check exchange rate" option to check the exchange rate of a currency (please note, that it's calculated with USD by default).

## Classes

1. `Account` (abstract class)

   - This class represents the basic properties and methods of a bank account, such as balance and account number.
   - It also defines an abstract `withdraw` method that will be overridden in the child classes.

2. `SavingsAccount` (class)

   - This class inherits from the `Account` class and adds an interest rate property.
   - It overrides the `withdraw` method to check for sufficient balance before allowing a withdrawal.

3. `CheckingAccount` (class)

   - This class inherits from the `Account` class and adds an overdraft limit property.
   - It overrides the `withdraw` method to check for sufficient balance (including the overdraft limit) before allowing a withdrawal.

4. `ExchangeRateAPI` (class)

   - This class uses the `java.net` package to make a GET request to an exchange rates API, in this case `https://open.er-api.com/` and parses the response to extract the exchange rate for the desired currency.

5. `BankAccountSystem` (main class)
   - This class contains the main method and the user interface for the project.
   - It creates and stores instances of the `Account`, `SavingsAccount`, and `CheckingAccount` classes in an array.
   - It also provides methods for the user to perform basic transactions (e.g deposit, withdraw) and check exchange rates on the accounts.
   - Allows to add new savings and checking accounts

## Requirements

- Java 8 or later
- Any Java IDE that supports Java 8 or later
- Internet connection to access the exchange rates API

## Note

This is a sample project and should be used for educational purposes only. It is not meant to be used in a production environment.
