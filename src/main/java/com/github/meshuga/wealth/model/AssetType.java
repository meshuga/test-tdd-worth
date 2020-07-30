package com.github.meshuga.wealth.model;

public enum AssetType {
    CHECKING_ACCOUNTS(AssetGroup.CASH, "Checking accounts"),
    SAVINGS_ACCOUNTS(AssetGroup.CASH, "Savings accounts"),
    MONEY_MARKET_ACCOUNTS(AssetGroup.CASH, "Savings accounts"),
    PRINCIPAL_HOME(AssetGroup.USE, "Principal home"),
    VACATION_HOME(AssetGroup.USE, "Vacation home");

    private final AssetGroup group;
    private final String name;

    AssetType(AssetGroup group, String name) {
        this.group = group;
        this.name = name;
    }

    public AssetGroup getGroup() {
        return group;
    }

    public String getName() {
        return name;
    }
}
