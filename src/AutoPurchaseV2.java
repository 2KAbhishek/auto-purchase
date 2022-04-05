class AutoPurchaseV2 {
    public final static double MIN_PURCHASE_PRICE = 1000.0;
    public final static int MIN_LOAN_MONTHS = 6;
    public final static int MAX_LOAN_MONTHS = 120;
    public final static double MIN_INTEREST_RATE = 1.0;

    private int autoMileage;
    private String autoMakeModel;
    private double purchasePrice;
    private int loanMonths;
    private double interestRate;

    public AutoPurchaseV2() {
        autoMileage = -1;
        autoMakeModel = "unknown";
        purchasePrice = MIN_PURCHASE_PRICE;
        loanMonths = MIN_LOAN_MONTHS;
        interestRate = MIN_INTEREST_RATE;
    }

    public AutoPurchaseV2(int autoMileage, String autoMakeModel, double purchasePrice, int loanMonths,
            double interestRate) {
        setAutoMileage(autoMileage);
        setAutoMakeModel(autoMakeModel);
        setPurchasePrice(purchasePrice);
        setLoanMonths(loanMonths);
        setInterestRate(interestRate);
    }

    public void setAutoMileage(int autoMileage) {
        this.autoMileage = autoMileage;
    }

    public void setAutoMakeModel(String autoMakeModel) {
        this.autoMakeModel = autoMakeModel;
    }

    public void setPurchasePrice(double purchasePrice) {
        if (purchasePrice < MIN_PURCHASE_PRICE) {
            purchasePrice = MIN_PURCHASE_PRICE;
            System.out.println(
                    "Entered purchase price value is too low for a loan, so it was set to the minimum allowable value of "
                            + MIN_PURCHASE_PRICE);
        }
        this.purchasePrice = purchasePrice;
    }

    public void setLoanMonths(int loanMonths) {
        if (loanMonths < MIN_LOAN_MONTHS) {
            loanMonths = MIN_LOAN_MONTHS;
            System.out.println(
                    "Entered number of loan months is too low, so it was set to the minimum allowable value of "
                            + MIN_LOAN_MONTHS + " months");
        } else if (loanMonths > MAX_LOAN_MONTHS) {
            loanMonths = MAX_LOAN_MONTHS;
            System.out.println(
                    "Entered number of loan months value is too high, so it was set to the maximum allowable value of "
                            + MAX_LOAN_MONTHS);
        }
        this.loanMonths = loanMonths;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getAutoMileage() {
        return autoMileage;
    }

    public String getAutoMakeModel() {
        return autoMakeModel;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public int getLoanMonths() {
        return loanMonths;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void displayPurchaseInfo() {
        System.out.printf(
                "\n%s gets %d mpg and its purchase price of $%.2f will be financed at %.1f%% APR, to be paid over %d months.\n",
                autoMakeModel, autoMileage, purchasePrice, interestRate, loanMonths);
        System.out.printf("The monthly payment is $%.2f", computeMonthlyPayment());
    }

    public double computeMonthlyPayment() {
        double monthlyInterestRate = (interestRate / 100) / 12;
        double factor = Math.pow(1 + monthlyInterestRate, loanMonths);

        double monthlyPayment = (purchasePrice * monthlyInterestRate * factor) / (factor - 1);
        return monthlyPayment;
    }

    public double computeMultipleYearCost(double monthlyPayment, int numYears) {
        int milesPerYear = 12000;
        double gasCostPerMile = 3.25;
        double gasRequired = (milesPerYear / autoMileage) * numYears;
        double totalGasCost = gasRequired * gasCostPerMile;

        int interestMonths = Math.min(numYears * 12, loanMonths);
        double loanPayment = monthlyPayment * interestMonths;

        return totalGasCost + loanPayment;
    }

    public boolean isEqualTo(AutoPurchaseV2 other) {
        return (this.autoMileage == other.autoMileage) && (this.autoMakeModel.equals(other.autoMakeModel))
                && (this.purchasePrice == other.purchasePrice) && (this.loanMonths == other.loanMonths)
                && (this.interestRate == other.interestRate);
    }
}
