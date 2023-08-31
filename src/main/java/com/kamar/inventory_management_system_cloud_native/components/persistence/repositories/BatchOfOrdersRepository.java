package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.BatchOfOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * the crud repository for the batch of orders.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface BatchOfOrdersRepository extends CrudRepository<BatchOfOrders, Long> {

    BatchOfOrders findBatchOfOrdersByBatchId(long batchId);
}
