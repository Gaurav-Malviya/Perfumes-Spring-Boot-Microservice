package com.perfumesite.perfumems.dto;

import com.perfumesite.perfumems.entity.Subscription;

public class SubscriptionDTO 
{
	int buyerId;
	int productId;
	int samples;
	
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getSamples() {
		return samples;
	}
	public void setSamples(int samples) {
		this.samples = samples;
	}
	
	//Convert entity into dto
	public static SubscriptionDTO toDTO(Subscription entityValue)
	{
		SubscriptionDTO subscriptionDTOBox = new SubscriptionDTO();
		subscriptionDTOBox.setBuyerId(entityValue.getBuyerId());
		subscriptionDTOBox.setProductId(entityValue.getProductId());
		subscriptionDTOBox.setSamples(entityValue.getSamples());
		return subscriptionDTOBox;
	}
	
	//Convert dto into entity
	public Subscription toEntity(SubscriptionDTO dtoValue)
	{
		Subscription subscribeEntityBox = new Subscription();
		subscribeEntityBox.setBuyerId(dtoValue.getBuyerId());
		subscribeEntityBox.setProductId(dtoValue.getProductId());
		subscribeEntityBox.setSamples(dtoValue.getSamples());
		return subscribeEntityBox;
	}
}
