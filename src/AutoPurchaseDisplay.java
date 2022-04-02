public class AutoPurchaseDisplay {
    public static void main(String[] args) {
        System.out.println("AutoPurchaseDisplay.main()");
    }

    public double determineInterestRate(int numLoanMonths) {
        double interestRate = 3.8;
        while (numLoanMonths > 12) {
            numLoanMonths -= 12;
            interestRate += 0.5;
        }
        return interestRate;
    }
}
