import java.util.Scanner;

public class AutoPurchaseDisplay {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        AutoPurchase purchase = new AutoPurchase();
        readPurchaseInfo(keyboard, purchase);
        System.out.println();

        System.out.printf(
                "%s gets %d mpg and its purchase price of $%.2f will be financed at %.1f%% APR, to be paid over %d months.\n",
                purchase.getAutoMakeModel(), purchase.getAutoMileage(), purchase.getPurchasePrice(),
                purchase.getInterestRate(), purchase.getLoanMonths());
    }

    public static void readPurchaseInfo(Scanner keyboard, AutoPurchase purchase) {
        System.out.println("Gas mileage (miles per gallon)?");
        purchase.setAutoMileage(keyboard.nextInt());
        System.out.println("Make and model?");
        keyboard.nextLine(); // clear the newline character
        purchase.setAutoMakeModel(keyboard.nextLine().strip());
        System.out.println("Purchase price?");
        purchase.setPurchasePrice(keyboard.nextDouble());
        System.out.println("Loan length in months?");
        int numLoanMonths = keyboard.nextInt();
        purchase.setLoanMonths(numLoanMonths);
        purchase.setInterestRate(determineInterestRate(numLoanMonths));
    }

    public static double determineInterestRate(int numLoanMonths) {
        double interestRate = 3.8;
        while (numLoanMonths >= 12) {
            numLoanMonths -= 12;
            interestRate += 0.5;
        }
        return interestRate;
    }
}
