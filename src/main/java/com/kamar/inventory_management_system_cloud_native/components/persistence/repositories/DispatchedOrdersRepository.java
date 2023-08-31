package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.DispatchedOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * the crud repository for dispatched orders.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface DispatchedOrdersRepository extends CrudRepository<DispatchedOrders, Long> {
}
