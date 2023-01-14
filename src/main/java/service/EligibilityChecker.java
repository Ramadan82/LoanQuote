package service;

import model.Borrower;

import static util.Constants.*;

public class EligibilityChecker {

    public static boolean isEligible(Borrower borrower) {
        return borrower.getIncome() >= MINIMUM_INCOME
                && borrower.getResidence().equals(RESIDENCE)
                && borrower.getAge() >= MINIMUM_AGE
                && borrower.getAge() <= MAXIMUM_AGE;
    }
}
