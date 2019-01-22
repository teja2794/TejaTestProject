package com.test.TestProject.facade;

import org.springframework.http.ResponseEntity;

import com.test.TestProject.beans.ProductResponse;

public interface ProductServiceFacade {
	
	public ResponseEntity<?> getProducts();


}
