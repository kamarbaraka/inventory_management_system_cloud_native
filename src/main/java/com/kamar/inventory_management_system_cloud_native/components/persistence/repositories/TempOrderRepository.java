package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.TempOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a repository for the temporary order.
 * @author kamar baraka.*/

@RepositoryRestResource
public interface TempOrderRepository extends CrudRepository<TempOrder, Long> {

    TempOrder findTempOrderByOrderId(long orderId);

    void deleteTempOrderByOrderId(long orderId);
}
