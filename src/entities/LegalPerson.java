package entities;

public class LegalPerson extends Person{
    private Integer numberOfEmployees;

    public LegalPerson(String name, Double anualIncome, Integer numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public Double calculateTax(){
        if(numberOfEmployees > 10){
            return getAnualIncome() * 14;
        }
        else if(numberOfEmployees <= 10){
            return getAnualIncome() * 16;
        }
        else {
            return 0.0;
        }
    }

    @Override
    public String toString(){
        return getName() + " - $" + String.format("%.2f", calculateTax());
    }
}
