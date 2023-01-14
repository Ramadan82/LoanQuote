package service;

import java.math.BigDecimal;

public interface LoanCalculator {
    BigDecimal calculateRepayment(BigDecimal loanAmount, int years, double yearlyInterestRate);
}
