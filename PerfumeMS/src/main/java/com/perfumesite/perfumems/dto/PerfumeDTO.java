package com.perfumesite.perfumems.dto;

import com.perfumesite.perfumems.entity.Perfume;

public class PerfumeDTO
{
	int productId;
	int sellerId;
	String companyName;
	String productName;
	String description;
	int price;
	int stock;
	String gender;
	float rating;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	
	//Convert entity into dto
	public static PerfumeDTO toDTO(Perfume entityValue)
	{
		PerfumeDTO perfumeDTOBox = new PerfumeDTO();
		perfumeDTOBox.setProductId(entityValue.getProductId());
		perfumeDTOBox.setSellerId(entityValue.getSellerId());
		perfumeDTOBox.setCompanyName(entityValue.getCompanyName());
		perfumeDTOBox.setProductName(entityValue.getProductName());
		perfumeDTOBox.setDescription(entityValue.getDescription());
		perfumeDTOBox.setPrice(entityValue.getPrice());
		perfumeDTOBox.setStock(entityValue.getStock());
		perfumeDTOBox.setGender(entityValue.getGender());
		perfumeDTOBox.setRating(entityValue.getRating());
		return perfumeDTOBox;
	}
	
	//Convert dto into entity
	public Perfume toEntity(PerfumeDTO dtoValue)
	{
		Perfume perfumeEntityBox = new Perfume();
		perfumeEntityBox.setProductId(dtoValue.getProductId());
		perfumeEntityBox.setSellerId(dtoValue.getSellerId());
		perfumeEntityBox.setCompanyName(dtoValue.getCompanyName());
		perfumeEntityBox.setProductName(dtoValue.getProductName());
		perfumeEntityBox.setDescription(dtoValue.getDescription());
		perfumeEntityBox.setPrice(dtoValue.getPrice());
		perfumeEntityBox.setStock(dtoValue.getStock());
		perfumeEntityBox.setGender(dtoValue.getGender());
		perfumeEntityBox.setRating(dtoValue.getRating());
		return perfumeEntityBox;
	}
	
	
	
	
	
	
	
	
	

	
}
