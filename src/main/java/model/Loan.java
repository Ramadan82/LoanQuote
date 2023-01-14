package model;

import java.math.BigDecimal;

public class Loan {
    private BigDecimal totalLoanAmount;
    private BigDecimal totalRepayment;
    private BigDecimal monthlyRepaymentAmount;

    public BigDecimal getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public BigDecimal getTotalRepayment() {
        return totalRepayment;
    }

    public BigDecimal getMonthlyRepaymentAmount() {
        return monthlyRepaymentAmount;
    }

    public void setTotalLoanAmount(BigDecimal totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public void setTotalRepayment(BigDecimal totalRepayment) {
        this.totalRepayment = totalRepayment;
    }

    public void setMonthlyRepaymentAmount(BigDecimal monthlyRepaymentAmount) {
        this.monthlyRepaymentAmount = monthlyRepaymentAmount;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "totalLoanAmount=" + totalLoanAmount +
                ", totalRepayment=" + totalRepayment +
                ", monthlyRepaymentAmount=" + monthlyRepaymentAmount +
                '}';
    }
}
