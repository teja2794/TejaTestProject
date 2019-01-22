package com.test.TestProject.service;

import org.springframework.http.ResponseEntity;

import com.test.TestProject.beans.ProductResponse;


public interface ProductServiceInterface {
	public ResponseEntity<?> getProducts();

}
