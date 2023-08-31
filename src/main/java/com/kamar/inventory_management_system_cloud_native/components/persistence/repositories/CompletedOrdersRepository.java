package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.CompletedOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * crud repository for completed orders.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface CompletedOrdersRepository extends CrudRepository<CompletedOrders, Long> {
}
