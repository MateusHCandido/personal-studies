package interfaces.project01.application;

import interfaces.project01.model.entities.Contract;
import interfaces.project01.model.entities.Installment;
import interfaces.project01.model.service.ContractService;
import interfaces.project01.model.service.OnlinePaymentService;
import interfaces.project01.model.service.PaypalService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/* APPLICATION CASE

A company wants to automate the processing of its contracts. Processing a contract consists of generating
the installments to be paid for that contract, based on the desired number of months.

 The company uses an online payment service to pay the installments. Online payment services typically charge
 monthly interest as well as a per-payment fee. For now, the service contracted by the company is Paypal, which
 applies simple interest of 1% to each installment, plus a payment fee of 2%.

 Make a program to read the data of a contract (contract number, contract date and total contract value).
 Then, the program must read the number of months for the contract to be paid in installments, and then generate
 the records of installments to be paid (date and amount), with the first installment to be paid one month after
 the contract date, the second installment two months after the contract and so on. Show plot data on screen.*/


public class Application01 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Contract contract;
        OnlinePaymentService paymentService = new PaypalService();
        try {
            System.out.println("Enter contract data: ");
            System.out.print("Number: ");
            Integer number = input.nextInt();
            System.out.print("Date (dd/MM/yyyy): ");
            String date = input.next();
            System.out.print("Contract value: ");
            Double contractValue = input.nextDouble();
            contract = new Contract(number, sdf.parse(date), contractValue);
            ContractService contractS = new ContractService(new PaypalService());
            System.out.print("Enter number of installments: ");
            Integer installments = input.nextInt();
            contractS.processContract(contract, installments);
            System.out.println("Installments: ");
            for(Installment installment: contract.getInstallments()){
                System.out.println(installment);
            }

        }catch (InputMismatchException error01){
            System.out.println("error01: There was an error entering the values");
        } catch (ParseException error2){
            System.out.println("error01: There was an error entering dates");
        } catch (IllegalArgumentException error3){
            System.out.println("error01: There was an error creating the contract");
        }

        input.close();
    }
}
