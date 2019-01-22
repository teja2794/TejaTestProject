package com.test.TestProject.beans;

public class ColorSwatch {
	private String color;
	 private String basicColor;
	 private String colorSwatchUrl;
	 private String imageUrl;
	 private boolean isAvailable;
	 private String skuId;


	 // Getter Methods 

	 public String getColor() {
	  return color;
	 }

	 public String getBasicColor() {
	  return basicColor;
	 }

	 public String getColorSwatchUrl() {
	  return colorSwatchUrl;
	 }

	 public String getImageUrl() {
	  return imageUrl;
	 }

	 public boolean getIsAvailable() {
	  return isAvailable;
	 }

	 public String getSkuId() {
	  return skuId;
	 }

	 // Setter Methods 

	 public void setColor(String color) {
	  this.color = color;
	 }

	 public void setBasicColor(String basicColor) {
	  this.basicColor = basicColor;
	 }

	 public void setColorSwatchUrl(String colorSwatchUrl) {
	  this.colorSwatchUrl = colorSwatchUrl;
	 }

	 public void setImageUrl(String imageUrl) {
	  this.imageUrl = imageUrl;
	 }

	 public void setIsAvailable(boolean isAvailable) {
	  this.isAvailable = isAvailable;
	 }

	 public void setSkuId(String skuId) {
	  this.skuId = skuId;
	 }
}
