package com.github.meshuga.wealth.controller;

import com.github.meshuga.wealth.service.WorthService;
import com.github.meshuga.wealth.model.AssetType;

public class WorthController {

    private WorthService worthService;

    public WorthController(WorthService worthService) {
        this.worthService = worthService;
    }

    public void printWorth() {
        var worthOutput = worthService.printWorth();

        System.out.println(worthOutput);
    }

    public void addAsset(AssetType assetType, double value) {
        worthService.addAsset(assetType, value);
    }

    public void removeAsset(AssetType assetType) {
        worthService.removeAsset(assetType);
    }
}
