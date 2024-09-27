package CalcInterest;

public class CalcInterest {

    // Method to compute loan interest
    public static double computeLoanInterest(double loanAmount, int yearLoan, int loanType) {
        if (loanAmount <= 0 || yearLoan <= 0 || (loanType != 1 && loanType != 2)) {
            return -1; // Error case for invalid input
        }

        double interestRate = 0;

        if (loanType == 1) { // Home loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    interestRate = 8.0;
                } else if (yearLoan <= 10) {
                    interestRate = 6.5;
                } else {
                    interestRate = 5.5;
                }
            } else if (loanAmount < 500000) {
                if (yearLoan <= 10) {
                    interestRate = 6.5;
                } else {
                    interestRate = 5.5;
                }
            } else {
                interestRate = 5.5;
            }
        } else if (loanType == 2) { // Property loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    interestRate = 12.0;
                } else if (yearLoan <= 10) {
                    interestRate = 8.5;
                } else {
                    interestRate = 7.0;
                }
            } else if (loanAmount < 500000) {
                if (yearLoan <= 10) {
                    interestRate = 8.5;
                } else {
                    interestRate = 7.0;
                }
            } else {
                interestRate = 7.0;
            }
        }

        // Calculate total interest
        double totalInterest = loanAmount * interestRate * yearLoan / 100;
        return totalInterest;
    }

    public static void main(String[] args) {
        // Test case execution
        System.out.println("Test Case 1: " + computeLoanInterest(99999, 5, 1)); // Expected 39999.6
        System.out.println("Test Case 2: " + computeLoanInterest(100000, 10, 1)); // Expected 65000.0
        System.out.println("Test Case 3: " + computeLoanInterest(500000, 11, 1)); // Expected 302500.0
    }
}
