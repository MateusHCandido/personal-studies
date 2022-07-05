package InheritanceAndPolymorphism.project04.entities;

public class CompanyPerson extends Person{

    private Integer NumberOfEmployees;

    public CompanyPerson(){
        super();
    }

    public CompanyPerson(String name, Double annualIncome, Integer NumberOfEmployees){
        super(name, annualIncome);
        this.NumberOfEmployees = NumberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return NumberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        NumberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double taxCalculation(){
        Double tax = null;
        if(getNumberOfEmployees() > 10){
            tax = (getAnnualIncome() * 0.14d);
        } else{
            tax = (getAnnualIncome() * 0.16d);
        }
        return tax;
    }
}
