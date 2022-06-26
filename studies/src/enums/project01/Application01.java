package enums.project01; //ACCOUNTANT OF HOURS WORKED IN THE MONTH AND TOTAL RECEIVABLE

import enums.project01.entities.Department;
import enums.project01.entities.HourContract;
import enums.project01.entities.Worker;
import enums.project01.entities.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Application01 {
   public static void main(String[]args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = input.nextLine();
        System.out.println("----------------------");
        System.out.println("Enter worker data: ");
        System.out.println();
        System.out.print("Name: ");
        String workerName = input.nextLine();
        System.out.print("Level: ");
        String workerLevel = input.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = input.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel),
                baseSalary, new Department(departmentName));
        System.out.println("----------------------");
        System.out.println();
        System.out.print("How many contracts to this worker? ");
        int numberContracts = input.nextInt();
        for(int index = 1; index < numberContracts+1; index++){
            System.out.println("==========================");
            System.out.println("Enter contract #" + index + " data:");
            System.out.println();
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(input.next());
            System.out.print("Value per hour: ");
            double valuePerHour = input.nextDouble();
            System.out.print("Duration (hours): ");
            int hours = input.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.println("==========================");
        System.out.println();
        System.out.print("Enter month and year to calculate income(MM/YYYY): ");
        String monthAndYear = input.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("==========================");
        System.out.println("         RESUME");
        System.out.println();
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.printf("Income for %s: %.2f", monthAndYear, worker.income(year, month));

        input.close();
    }
}
