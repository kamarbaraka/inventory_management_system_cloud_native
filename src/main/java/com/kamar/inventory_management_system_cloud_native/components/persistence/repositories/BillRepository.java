package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Bill;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a repository to manage the bill entity.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface BillRepository extends CrudRepository<Bill, Long> {
}
