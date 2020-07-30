package com.github.meshuga.wealth.repository;

import com.github.meshuga.wealth.model.Worth;

import java.util.Optional;

public class WorthRepositoryImpl implements WorthRepository {

    private Worth worth;

    @Override
    public Optional<Worth> get() {
        return Optional.ofNullable(worth);
    }

    @Override
    public Worth save(Worth worth) {
        this.worth = worth;
        return worth;
    }
}
