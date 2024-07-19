package com.orderfulfilmentapplication.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderfulfilmentapplication.entity.TInventory;
import com.orderfulfilmentapplication.entity.TWareHouse;
import com.orderfulfilmentapplication.model.Response;
import com.orderfulfilmentapplication.repository.InventoryRepository;
import com.orderfulfilmentapplication.repository.PaymentRepository;
import com.orderfulfilmentapplication.repository.WareHouseRepository;

@Service
public class ProductService {
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	WareHouseRepository wareHouseRepository;
	@Autowired
	InventoryRepository inventoryRepository;

	public Response getProduct(BigInteger productId) {
		Response response = new Response();
		Optional<TInventory> findById = inventoryRepository.findById(productId);
		if (findById.isPresent()) {
			response.setInventory(findById.get());
			return response;
		}
		response.setMessage("No Such product exists with product id : " + productId.toString());
		return response;
	}

	public List<TInventory> getTopSellingProducts() {
		List<TInventory> findTopProducts = inventoryRepository.findTopProducts();
		return findTopProducts;
	}

	public TWareHouse getWareHouseDetails(BigInteger id) {
		Optional<TWareHouse> findById = wareHouseRepository.findById(id);
		if (findById.isPresent())
			return findById.get();
		return new TWareHouse();
	}

	public Response addProducts(List<TInventory> inventory) {
		Response response = new Response();
		List<TInventory> saveAll = inventoryRepository.saveAll(inventory);
		return response;
	}

	public Response deleteProduct(BigInteger id) {
		Response response = new Response();
		if (id != null) {
			Optional<TInventory> findById = inventoryRepository.findById(id);
			if (findById.isPresent()) {
				inventoryRepository.deleteById(id);
				response.setMessage("Product deleted");
			} else {
				response.setMessage("not such product exists");
			}
		}

		return response;
	}

	public Response dicontinueProduct(TInventory inventory) {

		return null;
	}
}
