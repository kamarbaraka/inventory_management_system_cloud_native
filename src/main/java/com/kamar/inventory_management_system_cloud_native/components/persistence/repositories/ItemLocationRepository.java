package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.ItemLocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a rest repository to manage item locations.
 * @author kamar baraka.*/

@RepositoryRestResource
@RequestMapping(value = {"/admin/location"})
public interface ItemLocationRepository extends CrudRepository<ItemLocation, Long> {
}
