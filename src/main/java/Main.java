import model.Borrower;
import model.Lender;
import model.Loan;
import service.EligibilityChecker;
import service.MonthlyLoanCalculator;

import java.math.BigDecimal;

import static util.Constants.DEFAULT_LOAN_AMOUNT;
import static util.Constants.DEFAULT_LOAN_MONTHS;

public class Main {

    public static void main(String[] args) {
        Borrower borrower = new Borrower(34, "UK", 28_000);
        Lender lender = new Lender("Zopa", 3.20);
        BigDecimal loanAmount = BigDecimal.valueOf(DEFAULT_LOAN_AMOUNT);

        MonthlyLoanCalculator monthlyLoanCalculator = new MonthlyLoanCalculator();
        boolean isBorrowerEligible = EligibilityChecker.isEligible(borrower);

        if (isBorrowerEligible) {
            Loan loan = new Loan();
            loan.setTotalLoanAmount(loanAmount);
            BigDecimal monthlyRepayment = monthlyLoanCalculator.calculateRepayment(loan.getTotalLoanAmount(),
                    DEFAULT_LOAN_MONTHS / 12, lender.getInterestRate());

            loan.setMonthlyRepaymentAmount(monthlyRepayment);
            loan.setTotalRepayment(monthlyRepayment.multiply(BigDecimal.valueOf(DEFAULT_LOAN_MONTHS)));

            System.out.println("You can borrow £" + loanAmount + " from " + lender.getName());
            System.out.println("With a monthly repayment of £" + loan.getMonthlyRepaymentAmount());
            System.out.println("That's a total of £" + loan.getTotalRepayment());

        } else {
            System.out.println("Sorry, you are not eligible for this quote");
        }
    }
}
