package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a repository to manage the bill entity.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
