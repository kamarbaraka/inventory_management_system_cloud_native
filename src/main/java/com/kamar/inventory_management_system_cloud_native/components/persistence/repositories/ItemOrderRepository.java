package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a rest repository to manage item orders.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface ItemOrderRepository extends CrudRepository<ItemOrder, Long> {

    ItemOrder findItemOrderByOrderId(long orderId);
}
