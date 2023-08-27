package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemOrderDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * repository for the item order details.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface ItemOrderDetailsRepository extends CrudRepository<ItemOrderDetails, Long> {
}
