import java.util.Scanner;

public class AutoPurchaseDisplay {
    public static void main(String[] args) {
        System.out.println("AutoPurchaseDisplay.main()");
    }

    public void readPurchaseInfo(Scanner keyboard, AutoPurchase purchase) {
        System.out.println("Gas mileage (miles per gallon)?");
        purchase.setAutoMileage(keyboard.nextInt());
        System.out.println("Make and model?");
        purchase.setAutoMakeModel(keyboard.next());
        System.out.println("Purchase price?");
        purchase.setPurchasePrice(keyboard.nextDouble());
        System.out.println("Loan length in months:");
        int numLoanMonths = keyboard.nextInt();
        purchase.setLoanMonths(numLoanMonths);
        purchase.setInterestRate(numLoanMonths);
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
