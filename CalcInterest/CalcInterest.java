package CalcInterest;

import java.util.ArrayList;
import java.util.List;

public class CalcInterest {

    // Method to calculate loan interest
    public static float computeLoanInterest(double loanAmount, int yearLoan, int loanType) {
        // Check for invalid input values
        if (loanAmount < 5000 || yearLoan < 1 || (loanType != 1 && loanType != 2)) {
            return -1; // Return -1 for invalid inputs
        }

        float interestRate;

        // Interest rate calculations based on loan type and amounts
        if (loanType == 1) { // Home Loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    interestRate = 0.08f; // 8%
                } else if (yearLoan <= 10) {
                    interestRate = 0.065f; // 6.5%
                } else {
                    interestRate = 0.055f; // 5.5%
                }
            } else if (loanAmount < 500000) {
                if (yearLoan <= 10) {
                    interestRate = 0.065f; // 6.5%
                } else {
                    interestRate = 0.055f; // 5.5%
                }
            } else { // loanAmount >= 500000
                if (yearLoan >= 11) {
                    interestRate = 0.055f; // 5.5%
                } else {
                    return -1; // Invalid for this condition
                }
            }
        } else { // Property Loan
            if (loanAmount < 100000) {
                if (yearLoan <= 5) {
                    interestRate = 0.12f; // 12%
                } else if (yearLoan < 10) {
                    interestRate = 0.085f; // 8.5%
                } else {
                    interestRate = 0.07f; // 7%
                }
            } else if (loanAmount < 500000) {
                if (yearLoan < 10) {
                    interestRate = 0.085f; // 8.5%
                } else {
                    interestRate = 0.07f; // 7%
                }
            } else { // loanAmount >= 500000
                if (yearLoan >= 11) {
                    interestRate = 0.07f; // 7%
                } else {
                    return -1; // Invalid for this condition
                }
            }
        }

        // Calculate interest using the formula: Interest = Principal * Rate * Time
        return (float) (loanAmount * interestRate * yearLoan); // Return only the interest amount
    }

    public static void main(String[] args) {
        List<String> bvaResults = new ArrayList<>();
        List<String> epResults = new ArrayList<>();

        // Test Cases from Boundary Value Analysis (BVA)
        bvaResults.add(runTestCase(5000, 5, 1, 2000.0f));        // TC001
        bvaResults.add(runTestCase(100000, 5, 1, 32500.0f));     // TC002
        bvaResults.add(runTestCase(4999.99, 5, 1, -1.0f));       // TC003
        bvaResults.add(runTestCase(99999, 10, 1, 64999.35f));    // TC004
        bvaResults.add(runTestCase(100000, 10, 1, 65000.0f));    // TC005
        bvaResults.add(runTestCase(499999, 10, 1, 324999.35f));  // TC006
        bvaResults.add(runTestCase(500000, 11, 1, 302500.0f));   // TC007
        bvaResults.add(runTestCase(5000, 5, 2, 3000.0f));        // TC008
        bvaResults.add(runTestCase(99999, 5, 2, 59999.4f));      // TC009
        bvaResults.add(runTestCase(100000, 9, 2, 76500.0f));     // TC010
        bvaResults.add(runTestCase(499999, 9, 2, 382499.235f));  // TC011
        bvaResults.add(runTestCase(500000, 11, 2, 385000.0f));   // TC012
        bvaResults.add(runTestCase(5000, 11, 1, 3025.0f));       // TC013
        bvaResults.add(runTestCase(5000, 0, 1, -1.0f));          // TC014
        bvaResults.add(runTestCase(5000, 5, 0, -1.0f));          // TC015
        bvaResults.add(runTestCase(5000, 5, 3, -1.0f));          // TC016

        // Test Cases from Equivalence Partitioning (EP)
        epResults.add(runTestCase(80000, 5, 1, 32000.0f));      // TC001 EP
        epResults.add(runTestCase(200000, 7, 2, 119000.0f));    // TC002 EP
        epResults.add(runTestCase(600000, 12, 1, 396000.0f));   // TC003 EP
        epResults.add(runTestCase(600000, 11, 2, 462000.0f));   // TC004 EP
        epResults.add(runTestCase(4000, 5, 1, -1.0f));          // TC005 EP
        epResults.add(runTestCase(6000, 1, 2, 720.0f));         // TC006 EP
        epResults.add(runTestCase(50000, 11, 1, 30250.0f));     // TC007 EP
        epResults.add(runTestCase(300000, 5, 2, 127500.0f));    // TC008 EP
        epResults.add(runTestCase(-50000, 5, 2, -1.0f));        // TC009 EP
        epResults.add(runTestCase(100000, 0, 1, -1.0f));        // TC010 EP
        epResults.add(runTestCase(50000, -1, 1, -1.0f));        // TC011 EP
        epResults.add(runTestCase(100000, 7, 0, -1.0f));        // TC012 EP
        epResults.add(runTestCase(100000, 7, 3, -1.0f));        // TC013 EP

        // Print results in table format
        System.out.println("=== Boundary Value Analysis (BVA) Results ===");
        printResults(bvaResults, "BVA");

        System.out.println("\n=== Equivalence Partitioning (EP) Results ===");
        printResults(epResults, "EP");
    }

    // A method to run a test case and return results as a string
    private static String runTestCase(double loanAmount, int yearLoan, int loanType, float expected) {
        float actual = computeLoanInterest(loanAmount, yearLoan, loanType);
        String result = (Math.abs(actual - expected) < 0.01) ? "PASSED" : "FAILED"; // Adjusted for float comparison
        return loanAmount + ", " + yearLoan + ", " + loanType + ", " + expected + ", " + actual + ", " + result;
    }

    // Method to print the results
    private static void printResults(List<String> results, String testType) {
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-12s | %-8s | %-4s | %-10s | %-10s | %-6s |\n", "Test Case ID", "Loan Amount", "Loan Year", "Loan Type", "Expected", "Actual", "Result");
        System.out.println("------------------------------------------------------------------------------------------");
        for (int i = 0; i < results.size(); i++) {
            String[] parts = results.get(i).split(",");
            System.out.printf("| %-10s   | %-12s | %-8s  | %-4s      | %-10s | %-10s | %-6s |\n",
                    (testType.equals("BVA") ? "TC" + String.format("%03d", i + 1) : "TC" + String.format("%03d EP", i + 1)),
                    parts[0].trim(),
                    parts[1].trim(),
                    parts[2].trim(),
                    parts[3].trim(),
                    parts[4].trim(),
                    parts[5].trim());
        }
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
