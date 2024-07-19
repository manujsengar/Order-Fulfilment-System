package com.orderfulfilmentapplication.delegate;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.orderfulfilmentapplication.entity.TInventory;
import com.orderfulfilmentapplication.entity.TWareHouse;
import com.orderfulfilmentapplication.model.Response;
import com.orderfulfilmentapplication.service.ProductService;

@Component
public class ProductDelegate {

	@Autowired
	ProductService productService;

	@Cacheable(value = "getProduct", key = "#productId")
	public Response getProduct(BigInteger productId) {
		return productService.getProduct(productId);
	}

	@Cacheable("getTopSellingProducts")
	public List<TInventory> getTopSellingProducts() {
		return productService.getTopSellingProducts();
	}

	@Cacheable(value = "getWareHouseDetails", key = "#id")
	public TWareHouse getWareHouseDetails(BigInteger id) {
		return productService.getWareHouseDetails(id);
	}

	public Response addProducts(List<TInventory> inventory) {
		return productService.addProducts(inventory);
	}

	public Response deleteProduct(BigInteger id) {
		
		return productService.deleteProduct(id);
	}

	public Response dicontinueProduct(TInventory inventory) {
		
		return null;
	}

	public CompletableFuture<ResponseEntity> findAll(List<Integer> id) {
		
		return null;
	}

}
