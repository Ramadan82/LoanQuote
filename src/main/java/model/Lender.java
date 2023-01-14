package model;

public class Lender {

    private final String name;
    private final double interestRate;

    public Lender(String name, double interestRate) {
        this.name = name;
        this.interestRate = interestRate;
    }

    public String getName() {
        return name;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Lender{" +
                "name='" + name + '\'' +
                ", interestRate=" + interestRate +
                '}';
    }
}
