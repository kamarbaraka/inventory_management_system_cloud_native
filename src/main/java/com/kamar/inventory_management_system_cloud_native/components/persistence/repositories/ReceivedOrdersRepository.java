package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ReceivedOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * the crud repository for received orders.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface ReceivedOrdersRepository extends CrudRepository<ReceivedOrders, Long> {

    void deleteReceivedOrdersByOrderId(long orderId);
}
