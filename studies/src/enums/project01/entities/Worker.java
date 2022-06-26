package enums.project01.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(){}
    /*
    * instantiating the attributes without the list, as it would be a "has-many" composition and would not participate.
    * Then you must start it in the scope of the attributes*/
    public Worker(String name, WorkerLevel level, Double baseSalary, Department department){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    //Subroutine responsible for associating a contract from the list
    public void addContract(HourContract contract){
        contracts.add(contract);
    }


    //Subroutine responsible for detaching a contract from the list
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }


    public double income(int year, int month){
        double calculateSalary = baseSalary;
        Calendar cal = Calendar.getInstance();
        for(HourContract contract: contracts){
            cal.setTime(contract.getDate());
            int contract_year = cal.get(Calendar.YEAR);
            int contract_month = cal.get(Calendar.MONTH) + 1; //Adding +1 because the calendar month starts with a value of 0
            if (year == contract_year && month == contract_month){
                calculateSalary += contract.totalValue();
            }
        }
        return calculateSalary;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }


}
