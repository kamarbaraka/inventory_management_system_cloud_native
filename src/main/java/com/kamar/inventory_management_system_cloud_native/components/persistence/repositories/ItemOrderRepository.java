package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a rest repository to manage item orders.
 * @author kamar baraka.*/

@RepositoryRestResource
@RequestMapping(value = {"/admin/order"})
public interface ItemOrderRepository extends CrudRepository<ItemOrder, Long> {
}
