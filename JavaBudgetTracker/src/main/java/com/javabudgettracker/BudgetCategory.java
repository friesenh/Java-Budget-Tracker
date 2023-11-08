package com.javabudgettracker;

public enum BudgetCategory {
    DISCRETIONARY("Discretionary"),
    RENT("Rent"),
    GROCERIES_ESSENTIALS("Groceries/Essentials"),
    UTILITIES("Utilities"),
    RENTERS_INSURANCE("Renter's Insurance"),
    HEALTH_MEDICAL("Health/Medical"),
    AUTO_INSURANCE("Auto Insurance"),
    AUTO_MAINTENANCE("Auto Maintenance"),
    GAS("Gas"),
    PHONE_BILL("Phone Bill"),
    STUDENT_LOAN("Student Loan"),
    SUBSCRIPTIONS("Subscriptions"),
    LONG_TERM_SAVINGS("Long Term Savings"),
    SHORT_TERM_SAVINGS("Short Term Savings"),
    EMERGENCY_SAVINGS("Emergency Savings");

    private final String category;

    BudgetCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
