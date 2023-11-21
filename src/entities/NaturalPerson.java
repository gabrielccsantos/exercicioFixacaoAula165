package entities;

public abstract class NaturalPerson extends Person{
    private Double spentOnHealth;

    public NaturalPerson(String name, Double anualIncome, Double spentOnHealth) {
        super(name, anualIncome);
        this.spentOnHealth = spentOnHealth;
    }

    public Double getSpentOnHealth() {
        return spentOnHealth;
    }

    public void setSpentOnHealth(Double spentOnHealth) {
        this.spentOnHealth = spentOnHealth;
    }

    @Override
    public Double calculateTax(){
        if(getAnualIncome() < 20.000){
            return (getAnualIncome() * 0.15) - (getSpentOnHealth() * 0.5);
        }else if(getAnualIncome() >= 20.000){
            return (getAnualIncome() * 0.25) - (getSpentOnHealth() * 0.5);
        }
        else{
            return 0.0;
        }
    }

    public String toString(){
        return getName() + " - $" + String.format("%.2f", calculateTax());
    }
}
