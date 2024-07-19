package com.orderfulfilmentapplication.delegate;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RestController;

import com.orderfulfilmentapplication.controller.ProductController;
import com.orderfulfilmentapplication.entity.TInventory;
import com.orderfulfilmentapplication.entity.TWareHouse;
import com.orderfulfilmentapplication.model.Response;

@RestController
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ProductControllerImpl implements ProductController {

	@Autowired
	ProductDelegate productDelegate;
	private static final Logger log = LoggerFactory.getLogger(OrderControllerImpl.class);

	@Override
	public TInventory getProduct(BigInteger productId) {
		productDelegate.getProduct(productId);
		return null;
	}

	@Override
	public List<TInventory> getTopSellingProducts() {

		return productDelegate.getTopSellingProducts();
	}

	@Override
	public ResponseEntity<?> addProduct(List<TInventory> inventory) {

		Response addProducts = productDelegate.addProducts(inventory);
		return ResponseEntity.ok(addProducts);
	}

	@Override
	public ResponseEntity<?> deleteProduct(BigInteger id) {

		Response addProducts = productDelegate.deleteProduct(id);
		return ResponseEntity.ok(addProducts);
	}

	@Override
	public ResponseEntity<?> dicontinueProduct(TInventory inventory) {

		Response addProducts = productDelegate.dicontinueProduct(inventory);
		return ResponseEntity.ok(addProducts);
	}

	@Override
	public List<TWareHouse> getWareHouseDetails(BigInteger id) {

		TWareHouse wareHouseDetails = productDelegate.getWareHouseDetails(id);
		List<TWareHouse> asList = Arrays.asList(wareHouseDetails);
		return asList;
	}

	@Async("asyncTaskExecutor")
	public CompletableFuture<ResponseEntity> getProductsById(List<Integer> id) {
		return productDelegate.findAll(id).<ResponseEntity>thenApply(ResponseEntity::ok)
				.exceptionally(handleGetUsersFailure);
	}

	private static Function<Throwable, ResponseEntity> handleGetUsersFailure = throwable -> {
		log.error("Unable to retrieve products", throwable);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	};

}
