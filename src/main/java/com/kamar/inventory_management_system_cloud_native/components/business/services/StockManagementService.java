package com.kamar.inventory_management_system_cloud_native.components.business.services;

import com.kamar.inventory_management_system_cloud_native.components.persistence.entities.Stock;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.ItemLocationRepository;
import com.kamar.inventory_management_system_cloud_native.components.persistence.repositories.StockRepository;
import com.kamar.inventory_management_system_cloud_native.components.presentation.request_bodies.stock.StockAddRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * the stock management service.
 * @author kamar baraka.*/

@Service
public class StockManagementService {

    /*stock repository dependency*/
    private StockRepository stockRepository;
    private ItemLocationRepository locationRepository;

    /*inject the dependency*/
    @Autowired
    public StockManagementService(StockRepository stockRepository, ItemLocationRepository locationRepository){
        this.stockRepository = stockRepository;
        this.locationRepository = locationRepository;
    }

    /**
     * adds a stock to the database.
     * @param requestBody the stock object to add.
     * @return boolean*/
    public boolean addStock(StockAddRequestBody requestBody){

        Stock stock = new Stock();
        stock.setItemName(requestBody.getName());
        stock.setItemCode(requestBody.getCode());
        stock.setItemPrice(BigDecimal.valueOf(requestBody.getPrice()));
        stock.setItemCount(requestBody.getCount());
        stock.setLocation(requestBody.getLocation());

        /*persist the stock*/
        this.locationRepository.save(requestBody.getLocation());
        this.stockRepository.save(stock);

        return true;
    }


    /**
     * gets a stock by name.
     * @param name the name of the stock.*/
    public Stock getStockByName(String name){

        /*fetch the stock by name*/
        return this.stockRepository.findStockByItemName(name);

    }

    /**
     * gets stock by code.
     * @param code the code of the stock.*/
    public Stock getStockByCode(String code){

        /*fetch and return the stock*/
        return this.stockRepository.findStockByItemCode(code);
    }

    /**
     * gets stock by price.
     * @param price the price of the stock*/
    public List<Stock> getStocksByPrice(double price){

        /*get the big decimal value of price*/
        BigDecimal setPrice = BigDecimal.valueOf(price);

        /*fetch the stocks*/
        return this.stockRepository.findStocksByItemPrice(setPrice);
    }

    @Transactional
    public Stock updateStock(StockAddRequestBody stock){

        Stock persistedStock = this.stockRepository.findStockByItemName(stock.getName());

        if (persistedStock == null)
            return null;

        persistedStock.setItemPrice(BigDecimal.valueOf(stock.getPrice()));
        persistedStock.setItemCount(stock.getCount());
        persistedStock.setItemCode(stock.getCode());
        persistedStock.setLocation(stock.getLocation());

        stockRepository.save(persistedStock);

        return persistedStock;
    }

    public List<Stock> getAllStock(){
        List<Stock> stockList = new ArrayList<>();

        this.stockRepository.findAll().forEach(stockList::add);

        return stockList;
    }

    @Transactional
    public boolean deleteStock(String stockName){

        this.stockRepository.deleteStockByItemName(stockName);

        return true;
    }
}
