class AutoPurchaseV2 {
    public final static double MIN_PURCHASE_PRICE = 1000.0;
    public final static int MIN_LOAN_MONTHS = 6;
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

    public AutoPurchaseV2(int autoMileage, String autoMakeModel, double purchasePrice, int loanMonths, double interestRate) {
        this.autoMileage = autoMileage;
        this.autoMakeModel = autoMakeModel;
        this.purchasePrice = purchasePrice;
        this.loanMonths = loanMonths;
        this.interestRate = interestRate;
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
