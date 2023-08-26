package com.kamar.inventory_management_system_cloud_native.components.persistence.repositories;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * a rest repository to manage items.
 * @author kamar baraka.*/


@RepositoryRestResource
public interface StockRepository extends CrudRepository<Stock, String > {

    Stock findStockByItemName(String name);

    Stock findStockByItemCode(String itemCode);

    Stock findStockByItemPrice(BigDecimal price);

    List<Stock> findStocksByItemPrice(BigDecimal price);

    void deleteStockByItemName(String itemName);

}
