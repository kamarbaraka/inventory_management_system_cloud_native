package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a rest repository to manage payments.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
