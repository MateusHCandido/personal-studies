package InheritanceAndPolymorphism.project04.entities;

public class IndividualPerson extends Person{

    private Double healthSpending;

    public IndividualPerson(){
        super();
    }

    public IndividualPerson (String name, Double annualIncome, Double healthSpending){
        super(name, annualIncome);
        this.healthSpending = healthSpending;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    @Override
    public Double taxCalculation(){
        Double tax = null;
        if(healthSpending>0){
            if(getAnnualIncome() < 20000.00){
                tax = (getAnnualIncome() * 0.15d) - (healthSpending * 0.5d);
            } else{
                tax = (getAnnualIncome() * 0.25d) - (healthSpending * 0.5d);
            }
        }
        return tax;
    }
}
