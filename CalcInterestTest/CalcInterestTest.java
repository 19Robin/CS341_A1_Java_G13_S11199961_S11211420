package CalcInterestTest;

import CalcInterest.CalcInterest;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcInterestTest {

    // Test case for Boundary Value Analysis (BVA)
    @Test
    public void testBVAHomeLoanMinBoundary() {
        // Test case for loanAmount = 5000, yearLoan = 5, loanType = 1 (Home Loan)
        assertEquals(2000.0f, CalcInterest.computeLoanInterest(5000, 5, 1), 0.01);
    }

    @Test
    public void testBVAHomeLoanMaxBoundary() {
        // Test case for loanAmount = 100000, yearLoan = 5, loanType = 1 (Home Loan)
        assertEquals(32500.0f, CalcInterest.computeLoanInterest(100000, 5, 1), 0.01);
    }

    @Test
    public void testBVAInvalidLoanAmount() {
        // Test case for invalid loan amount = 4999.99, which is below the minimum
        assertEquals(-1.0f, CalcInterest.computeLoanInterest(4999.99, 5, 1), 0.01);
    }

    @Test
    public void testBVAInvalidLoanYear() {
        // Test case for invalid loan year = 0, which is below the minimum
        assertEquals(-1.0f, CalcInterest.computeLoanInterest(5000, 0, 1), 0.01);
    }

    // Test case for Equivalence Partitioning (EP)
    @Test
    public void testEPValidPropertyLoan() {
        // Test case for a valid property loan: loanAmount = 80000, yearLoan = 5, loanType = 2 (Property Loan)
        assertEquals(48000.0f, CalcInterest.computeLoanInterest(80000, 5, 2), 0.01);
    }

    @Test
    public void testEPInvalidLoanType() {
        // Test case for an invalid loan type = 3 (valid types are 1 for Home Loan and 2 for Property Loan)
        assertEquals(-1.0f, CalcInterest.computeLoanInterest(5000, 5, 3), 0.01);
    }

    @Test
    public void testEPInvalidNegativeLoanAmount() {
        // Test case for an invalid negative loan amount
        assertEquals(-1.0f, CalcInterest.computeLoanInterest(-50000, 5, 1), 0.01);
    }

    @Test
    public void testEPValidLargePropertyLoan() {
        // Test case for a valid large property loan: loanAmount = 600000, yearLoan = 12, loanType = 2
        assertEquals(504000.0f, CalcInterest.computeLoanInterest(600000, 12, 2), 0.01);
    }
}
