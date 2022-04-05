import java.util.Scanner;

public class AutoCostAnalyzer {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Multiple year Auto Cost Analyzer");
        System.out.println();

        System.out.println("Number of years for cost comparison?");
        int numYears = keyboard.nextInt();

        System.out.println("\nValues for first auto purchase:");
        AutoPurchaseV2 purchase1 = new AutoPurchaseV2();
        readPurchaseInfo(keyboard, purchase1);

        System.out.println("\nValues for first auto purchase:");
        AutoPurchaseV2 purchase2 = null;
        purchase2 = createAutoPurchaseObject(keyboard);

        purchase1.displayPurchaseInfo();
        double purchase1Cost = purchase1.computeMultipleYearCost(purchase1.computeMonthlyPayment(), numYears);
        System.out.printf("The %d year cost of ownership is $%.2f\n", numYears, purchase1Cost);

        purchase2.displayPurchaseInfo();
        double purchase2Cost = purchase2.computeMultipleYearCost(purchase2.computeMonthlyPayment(), numYears);
        System.out.printf("The %d year cost of ownership is $%.2f\n", numYears,purchase2Cost);

        if (purchase1.isEqualTo(purchase2)) {
            System.out.println("\nSame autos with same loan terms, so cannot compare\n");
        } else {
            if (purchase1Cost < purchase2Cost) {
                System.out.printf("\n%s has a lower %d year cost than %s\n", purchase1.getAutoMakeModel(), numYears,
                        purchase2.getAutoMakeModel());
            } else if (purchase1Cost > purchase2Cost) {
                System.out.printf("\n%s has a lower %d year cost than %s\n", purchase2.getAutoMakeModel(), numYears,
                        purchase1.getAutoMakeModel());
            } else {
                System.out.printf("\nBoth autos have the same %d year cost\n", numYears);
            }
        }

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
