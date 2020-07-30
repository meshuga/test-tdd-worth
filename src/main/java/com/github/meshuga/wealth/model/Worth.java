package com.github.meshuga.wealth.model;

import java.util.HashMap;
import java.util.Map;

public class Worth {
    private final Map<AssetType, Double> assets = new HashMap<>();

    public Map<AssetType, Double> getAssets() {
        return assets;
    }

}
