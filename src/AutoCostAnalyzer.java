import java.util.Scanner;

public class AutoCostAnalyzer {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Multiple year Auto Cost Analyzer");
        System.out.println();

        System.out.println("Number of years for cost comparison?");
        int numYears = keyboard.nextInt();

        AutoPurchaseV2 purchase1 = new AutoPurchaseV2();
        readPurchaseInfo(keyboard, purchase1);

        AutoPurchaseV2 purchase2 = null;
        purchase2 = createAutoPurchaseObject(keyboard);

        System.out.printf(
                "%s gets %d mpg and its purchase price of $%.2f will be financed at %.1f%% APR, to be paid over %d months.\n",
                purchase1.getAutoMakeModel(), purchase1.getAutoMileage(), purchase1.getPurchasePrice(),
                purchase1.getInterestRate(), purchase1.getLoanMonths());

        purchase2.displayPurchaseInfo();
    }

    public static void readPurchaseInfo(Scanner keyboard, AutoPurchaseV2 purchase) {
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

    public static AutoPurchaseV2 createAutoPurchaseObject(Scanner keyboard) {
        AutoPurchaseV2 purchaseV2 = null;

        System.out.println("Gas mileage (miles per gallon)?");
        int autoMileage = keyboard.nextInt();
        System.out.println("Make and model?");
        keyboard.nextLine(); // clear the newline character
        String autoMakeNode = keyboard.nextLine().strip();
        System.out.println("Purchase price?");
        double purchasePrice = keyboard.nextDouble();
        System.out.println("Loan length in months?");
        int numLoanMonths = keyboard.nextInt();
        double interestRate = determineInterestRate(numLoanMonths);

        purchaseV2 = new AutoPurchaseV2(autoMileage, autoMakeNode, purchasePrice, numLoanMonths, interestRate);
        return purchaseV2;
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