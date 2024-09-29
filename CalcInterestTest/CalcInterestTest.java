package CalcInterestTest;

import CalcInterest.CalcInterest;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalcInterestTest {

    // Test for Home loan under normal conditions
    @Test
    public void testHomeLoanBelow100K5Years() {
        assertEquals(4000.0f, CalcInterest.computeLoanInterest(50000, 5, 1), 0.01f);
    }

    @Test
    public void testHomeLoanBetween100KAnd500K10Years() {
        assertEquals(19500.0f, CalcInterest.computeLoanInterest(300000, 8, 1), 0.01f);
    }

    // Test for Property loan under normal conditions
    @Test
    public void testPropertyLoanAbove500K11Years() {
        assertEquals(35000.0f, CalcInterest.computeLoanInterest(500000, 12, 2), 0.01f);
    }

    // Test for Invalid loan type
    @Test
    public void testInvalidLoanType() {
        assertEquals(-1, CalcInterest.computeLoanInterest(50000, 5, 3), 0.01f);
    }

    // Test for edge case
    @Test
    public void testHomeLoanUpperBoundary() {
        assertEquals(32500.0f, CalcInterest.computeLoanInterest(500000, 11, 1), 0.01f);
    }
}
