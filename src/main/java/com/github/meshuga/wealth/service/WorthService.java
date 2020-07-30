package com.github.meshuga.wealth.service;

import com.github.meshuga.wealth.model.AssetType;
import com.github.meshuga.wealth.model.Worth;

public interface WorthService {

    String printWorth();
    Worth addAsset(AssetType type, double value);
    Worth removeAsset(AssetType type);
}
