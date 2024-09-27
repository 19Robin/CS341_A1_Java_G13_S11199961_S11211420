package CalcInterestTest;

import CalcInterest.CalcInterest;
import static org.junit.Assert.*;
import org.junit.Test;

public class CalcInterestTest {

    @Test
    public void testComputeLoanInterest_Home_Loan_5Years() {
        assertEquals(40000.0, CalcInterest.computeLoanInterest(100000, 5, 1), 0.001);
    }

    @Test
    public void testComputeLoanInterest_Property_Loan_11Years() {
        assertEquals(385000.0, CalcInterest.computeLoanInterest(500000, 11, 2), 0.001);
    }

    @Test
    public void testInvalidLoanType() {
        assertEquals(-1, CalcInterest.computeLoanInterest(100000, 5, 3), 0.001);
    }
}
