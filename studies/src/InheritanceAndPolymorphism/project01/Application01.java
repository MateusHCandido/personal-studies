package InheritanceAndPolymorphism.project01;

import InheritanceAndPolymorphism.project01.entities.Employee;
import InheritanceAndPolymorphism.project01.entities.OutsourcedEmployee;

import java.util.*;

    /*A company has its own and outsourced employees. For each employee, you want to register name, hours worked
     * and hourly rate. Outsourced employees still an additional expense.*/

    /*Employee pay corresponds to the hourly rate multiplied by the hours worked, with outsourced employees
     * still receive a bonus corresponding to 110% of their additional expense.*/

    /*Make a program to read the data of N employees(N provided by the user) and store it in a list. Once you have all the data,
     * show name and payment of each employee where they were typed */

public class Application01 {
    public static void main(String[] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        Employee employee = new OutsourcedEmployee();

        List<Employee> employees = new ArrayList<>();
        System.out.print("Enter the number of employees: ");
        Integer numbEmp = input.nextInt();

        for(int emp = 1; emp< numbEmp+1; emp++){
            System.out.println("Employee #" + emp + " data:");
            System.out.print("Outsourced (y/n)? ");
            char option = input.next().charAt(0);
            switch (option){
                case 'n':
                    System.out.print("Name: ");
                    String name = input.next();
                    System.out.print("Hours: ");
                    Integer hours = input.nextInt();
                    System.out.print("Value per hour: ");
                    Double valuePerHour = input.nextDouble();
                    employee = new Employee(name, hours, valuePerHour);
                    employees.add(employee);
                    break;

                case 'y':
                    System.out.print("Name: ");
                    name = input.next();
                    System.out.print("Hours: ");
                    hours = input.nextInt();
                    System.out.print("Value per hour: ");
                    valuePerHour = input.nextDouble();
                    System.out.print("Additional charge: ");
                    Double additionalCharge = input.nextDouble();
                    employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
                    employees.add(employee);
                    break;

                default:
                    System.out.println("ERROR: Invalid option. Employee evaluation not considered");
                    break;
            }
        }
        System.out.println();
        System.out.println("PAYMENTS");
        for(Employee user: employees){
            System.out.println(user);
        }
    }
}
