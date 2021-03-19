package com.ae.adq.maha.interview.repositories;

import com.ae.adq.maha.interview.entities.Inventory;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface InventoryRepository extends CrudRepository<Inventory, String> {
    Optional<Inventory> findByCode(String code);
}
