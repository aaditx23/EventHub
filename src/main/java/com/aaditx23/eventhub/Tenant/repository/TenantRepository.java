package com.aaditx23.eventhub.Tenant.repository;

import com.aaditx23.eventhub.Tenant.model.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Integer> {

    Tenant getTenantById(int id);
}
