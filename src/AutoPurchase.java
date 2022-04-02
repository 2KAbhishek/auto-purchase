class AutoPurchase {
    public final static double MIN_PURCHASE_PRICE = 1000.0;
    public final static int MIN_LOAN_MONTHS = 6;
    public final static double MIN_INTEREST_RATE = 1.0;

    private int autoMileage;
    private String autoMakeModel;
    private double purchasePrice;
    private int loanMonths;
    private double interestRate;

    public AutoPurchase() {
        autoMileage = -1;
        autoMakeModel = "unknown";
        purchasePrice = MIN_PURCHASE_PRICE;
        loanMonths = MIN_LOAN_MONTHS;
        interestRate = MIN_INTEREST_RATE;
    }

    public void setAutoMileage(int autoMileage) {
        this.autoMileage = autoMileage;
    }

    public void setAutoMakeModel(String autoMakeModel) {
        this.autoMakeModel = autoMakeModel;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setLoanMonths(int loanMonths) {
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
}
