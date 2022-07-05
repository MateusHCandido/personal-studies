package InheritanceAndPolymorphism.project04;
    /*Make a program to read the data of N taxpayers (N provided by the user), which can be an individual or a legal entity,
    and then show the value of the tax paid by each one, as well as the total tax collected.

    Individual data are: name, annual income and health expenses. The legal entity data are: name, annual income and number of employees. T
    he rules for tax calculations are as follows:

    INDIVIDUAL: person whose income was below 20000.00 pay 15% tax. People with income from 20000.00 onwards pay 25% tax. I
    f the person had health care expenses, 50% of these expenses are deducted from the tax.

    Example: a person whose income was 50000.00 and had 2000.00 in health expenses, the tax is: (50000 * 25%) - (2000 * 50%) = 11500.00

    LEGAL ENTITY: Legal entities pay 16% tax. However, if the company has more than 10 employees, it pays 14% tax.

    Example: a company whose income was 400000.00 and has 25 employees, the tax is: 400000 * 14% = 56000.00*/


import InheritanceAndPolymorphism.project04.entities.CompanyPerson;
import InheritanceAndPolymorphism.project04.entities.IndividualPerson;
import InheritanceAndPolymorphism.project04.entities.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Application04 {
    public static void main(String [] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        Integer payers = input.nextInt();

        for(int index = 1; index < payers+1; index ++){
            System.out.println("------------------------------");
            System.out.println("Tax payers #" + index + " data:");
            System.out.print("Individual or company (I/C)? ");
            char typePerson = input.next().charAt(0);
            System.out.print("Name: ");
            String name = input.next();
            System.out.print("Annual income: ");
            Double annualIncome = input.nextDouble();
            switch (typePerson){
                case 'I':
                    System.out.print("Health expenditures: ");
                    Double healthSpending = input.nextDouble();
                    personList.add(new IndividualPerson(name, annualIncome, healthSpending));
                    break;

                case 'C':
                    System.out.print("Number of employees: ");
                    Integer numbOfEmployees = input.nextInt();
                    personList.add( new CompanyPerson(name, annualIncome, numbOfEmployees));
                    break;

                default:
                    System.out.println("Invalid selected option. Disregarded action");
                    break;
            }
            System.out.println("Register finished");
            System.out.println("------------------------------");
        }
        Double totalTaxes = 0d;
        System.out.println("TAXES PAID");
        for(Person persons: personList){
            System.out.printf("%.2f%n",persons.taxCalculation());
            totalTaxes += persons.taxCalculation();
        }
        System.out.println();
        System.out.println("TOTAL TAXES");
        System.out.print(totalTaxes);

    }
}
