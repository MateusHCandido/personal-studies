package exceptionHandling.project01.application;

/*Make a program to read data from a bank account and then make a withdrawal from this bank account, showing the new balance.
 A withdrawal cannot take place or if there is no balance on the account,
or if the withdrawal amount is greater than the withdrawal limit for the account.*/

import exceptionHandling.project01.model.entities.Account;
import exceptionHandling.project01.model.exceptions.AccountException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application01 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Account account = new Account();
        Integer number = null;
        String holder = null;
        Double initialBalance = null, withdrawLimit = null;

        System.out.println("Enter account data");
        try {
            System.out.print("Number: ");
            number = input.nextInt();
        }catch (InputMismatchException error01){
            System.out.println("Error01: Only integer numeric values will be accepted");
        }
        input.nextLine();
        try {
            System.out.print("Holder: ");
            holder = input.nextLine();
        }catch (InputMismatchException error02){
            System.out.println("Error02: Only character values will be accepted");
        }
        try {
            System.out.print("Initial balance: ");
            initialBalance = input.nextDouble();
        }catch (InputMismatchException error03){
            System.out.println("Only real values will be accepted");
        }
        input.nextLine();
        try {
            System.out.print("Withdraw limit: ");
            withdrawLimit = input.nextDouble();
        }catch (InputMismatchException error03){
                System.out.println("Only real values will be accepted");
        }
        account = new Account(number, holder, initialBalance, withdrawLimit);

        System.out.println();
        try {
            System.out.print("Enter amount for with withdraw: ");
            account.withdraw(input.nextDouble());
            System.out.print("New balance: " + account.getBalance());
        }catch (AccountException aboveTheLimit){
            System.out.println("Withdraw error: " + aboveTheLimit.getMessage());
        }catch (InputMismatchException error03){
            System.out.println("Only real values will be accepted");
        }



    }
}
