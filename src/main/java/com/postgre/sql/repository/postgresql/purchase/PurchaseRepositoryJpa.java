package com.postgre.sql.repository.postgresql.purchase;

import com.postgre.sql.model.sql.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepositoryJpa extends JpaRepository<Purchase, Long> {
}
