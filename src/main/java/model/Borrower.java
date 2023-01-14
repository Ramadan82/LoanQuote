package model;

public class Borrower {
    private final int age;
    private final String residence;
    private final double income;

    public Borrower(int age, String residence, double income) {
        this.age = age;
        this.residence = residence;
        this.income = income;
    }

    public int getAge() {
        return age;
    }

    public String getResidence() {
        return residence;
    }

    public double getIncome() {
        return income;
    }

    @Override
    public String toString() {
        return "Borrower{" +
                "age=" + age +
                ", residence='" + residence + '\'' +
                ", income=" + income +
                '}';
    }
}
