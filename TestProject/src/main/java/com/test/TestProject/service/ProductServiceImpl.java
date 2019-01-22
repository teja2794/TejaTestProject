package com.test.TestProject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.test.TestProject.beans.ColorSwatch;
import com.test.TestProject.beans.ColorSwatches;
import com.test.TestProject.beans.Product;
import com.test.TestProject.beans.ProductResponse;
import com.test.TestProject.beans.ProductService;
import com.test.TestProject.beans.Products;
import com.test.TestProject.util.ColorUtil;

@Service
public class ProductServiceImpl implements ProductServiceInterface{
final String POUND="\u00A3";
	public ResponseEntity<?> getProducts() {
		List<Products> products = new ArrayList<Products>();
		RestTemplate restTemplate = new RestTemplate();
		ProductService productService = restTemplate.getForObject("https://jl-nonprod-syst.apigee.net/v1/categories/600001506/products?key=2ALHCAAs6ikGRBoy6eTHA58RaG097Fma",ProductService.class);
		
		  ArrayList<Object> list = productService.getProducts();
		 

		for(Object p:list){
			
			Product product=(Product)p;
			Products pr=new Products();
			pr.setProductId(product.getProductId());
			pr.setTitle(product.getTitle());
			ArrayList<ColorSwatches> colorslist = new ArrayList<ColorSwatches>();
			for(Object color:product.getColorSwatches()){
				ColorSwatch c=(ColorSwatch)color;
				ColorSwatches colors=new ColorSwatches();
				colors.setColor(c.getColor());
				colors.setBasicColor(Integer.toHexString(ColorUtil.stringToColor(c.getBasicColor()).getRGB()).substring(2));
				colors.setSkuId(c.getSkuId());
				colorslist.add(colors);
			}
			pr.setColorSwatches(colorslist);
			if(product.getPrice().getNow()!=" "||product.getPrice().getNow()!=null){
			Double price=Double.parseDouble(product.getPrice().getNow());
			String formattedPrice;
			if(price<10){
				formattedPrice=POUND+String.format("%.02f", price);
			}
			else{
				formattedPrice=POUND+String.valueOf(price.intValue());
			}
			pr.setNowPrice(formattedPrice);
			}
			pr.setPriceLabel(null);
			products.add(pr);
			
			
		}
		
		
		return ResponseEntity.ok().body(products);
	}
	

}
