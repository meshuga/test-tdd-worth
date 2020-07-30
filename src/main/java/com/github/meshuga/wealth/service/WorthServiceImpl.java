package com.github.meshuga.wealth.service;

import com.github.meshuga.wealth.model.AssetType;
import com.github.meshuga.wealth.model.Worth;
import com.github.meshuga.wealth.repository.WorthRepository;

import java.util.Map;

public class WorthServiceImpl implements WorthService {

    private final WorthRepository repository;

    public WorthServiceImpl(WorthRepository repository) {
        this.repository = repository;
    }

    public String printWorth() {
        var sb = new StringBuilder();

        var totalWorth = repository.get().stream()
                .flatMap(worthItem -> worthItem.getAssets().entrySet().stream())
                .peek(entry -> sb.append(String.format("Asset: %s, value: %(,.2f\n", entry.getKey().getName(), entry.getValue())))
                .map(Map.Entry::getValue)
                .reduce(0.0, Double::sum);

        sb.append(String.format("Net worth: %(,.2f", totalWorth));
        return sb.toString();
    }

    @Override
    public Worth addAsset(AssetType type, double value) {
        var worth = repository.get()
                .orElse(new Worth());
        worth.getAssets().put(type, value);
        return repository.save(worth);
    }

    @Override
    public Worth removeAsset(AssetType type) {
        var worth = repository.get()
                .orElse(new Worth());
        worth.getAssets().remove(type);
        return repository.save(worth);
    }
}
