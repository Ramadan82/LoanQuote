package service;

import java.math.BigDecimal;

public class MonthlyLoanCalculator implements LoanCalculator {

    @Override
    public BigDecimal calculateRepayment(BigDecimal loanAmount, int years, double yearlyInterestRate) {
        // Reference: https://www.kasasa.com/blog/how-to-calculate-loan-payments-in-3-easy-steps
        int totalMonths = years * 12;
        double monthlyInterestRate = Math.pow((1D + yearlyInterestRate / 100D), 1D/12) - 1D;

        // D = {[(1 + r)^n] - 1} / [r(1 + r)^n]
        double left = Math.pow(monthlyInterestRate + 1, totalMonths) - 1;
        double right = monthlyInterestRate * Math.pow(monthlyInterestRate + 1, totalMonths);
        BigDecimal discountFactor = BigDecimal.valueOf(left/right);

        return loanAmount.divide(discountFactor, 2, BigDecimal.ROUND_HALF_UP);
    }
}
