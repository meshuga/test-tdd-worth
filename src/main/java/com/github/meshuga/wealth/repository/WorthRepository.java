package com.github.meshuga.wealth.repository;

import com.github.meshuga.wealth.model.Worth;

import java.util.Optional;

public interface WorthRepository {

    Optional<Worth> get();

    Worth save(Worth worth);
}
