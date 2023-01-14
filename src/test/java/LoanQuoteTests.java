import org.junit.jupiter.api.Assertions;
import model.Borrower;
import model.Lender;
import org.junit.jupiter.api.Test;
import service.EligibilityChecker;
import service.MonthlyLoanCalculator;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class LoanQuoteTests {

    // https://moneyfacts.co.uk/loans/loan-calculator/ is used to calculate the expected values
    @Test
    void testMonthlyRepaymentCalculatorWithHighAmount() {
        final Lender lender = new Lender("lender", 5.5);
        MonthlyLoanCalculator calculator = new MonthlyLoanCalculator();
        BigDecimal monthlyRepayments = calculator.calculateRepayment(BigDecimal.valueOf(25000), 3, lender.getInterestRate());
        assertEquals(BigDecimal.valueOf(753.39), monthlyRepayments);
    }

    @Test
    void testMonthlyRepaymentCalculatorWithLowAmount() {
        final Lender lender = new Lender("lender", 7.2);
        MonthlyLoanCalculator calculator = new MonthlyLoanCalculator();
        BigDecimal monthlyRepayments = calculator.calculateRepayment(BigDecimal.valueOf(2500), 3, lender.getInterestRate());
        assertEquals(BigDecimal.valueOf(77.16), monthlyRepayments);
    }

    @Test
    void testBorrowerIsEligible() {
        Borrower borrower = new Borrower(19, "UK", 30_000);
        Assertions.assertTrue(EligibilityChecker.isEligible(borrower));
    }

    @Test
    void testBorrowerIsNotEligible() {
        Borrower borrower = new Borrower(16, "UK", 30_000);
        assertFalse(EligibilityChecker.isEligible(borrower));
    }
}