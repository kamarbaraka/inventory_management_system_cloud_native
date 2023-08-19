package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a rest repository to manage items.
 * @author kamar baraka.*/


@RepositoryRestResource
public interface ItemRepository extends CrudRepository<Item, Long> {
}
