package com.perfumesite.perfumems.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.perfumesite.perfumems.dto.PerfumeDTO;
import com.perfumesite.perfumems.entity.Perfume;
import com.perfumesite.perfumems.repository.PerfumeRepository;

@Service
public class PerfumeService
{
	@Autowired
	PerfumeRepository perfumeRepo;
	
	//Upload a new perfume
	public Perfume uploadPerfum(PerfumeDTO perfumeData)
	{
		Perfume perfumeEntity = perfumeData.toEntity(perfumeData);
		perfumeRepo.save(perfumeEntity);
		return perfumeEntity;
	}
	
	//Perfume delete 
	
	//Fetch all perfumes
	public List<PerfumeDTO> getAllPerfumes()
	{
		List<Perfume> allPerfumesEntity = perfumeRepo.findAll();
		List<PerfumeDTO> allPerfumesDTO = new ArrayList<>();
		for(Perfume perfumeEntity: allPerfumesEntity )
		{
			PerfumeDTO perfumeDTO = PerfumeDTO.toDTO(perfumeEntity);
			allPerfumesDTO.add(perfumeDTO);
		}
		return allPerfumesDTO;
	}
	
	//Fetch single perfume based on productId
	public PerfumeDTO getPerfumeById(int perfumeId)
	{
		Optional<Perfume> optionalData = perfumeRepo.findById(perfumeId);
		Perfume perfumeEntity = optionalData.get();
		return PerfumeDTO.toDTO(perfumeEntity);
	}
	
	//Fetch perfume by gender
	public List<PerfumeDTO> getPerfumeByGender(String gender)
	{
		List<PerfumeDTO> allPerfumes= new ArrayList<>();
		List<Perfume> allPerfumeEntity= perfumeRepo.findByGender(gender) ;
		for(Perfume perfumeEntity:allPerfumeEntity)
		{
			PerfumeDTO perfume = PerfumeDTO.toDTO(perfumeEntity);
			allPerfumes.add(perfume);
		}
		return allPerfumes;
	}
	
	//Stock update when seller adds a stock
	public String sellerPerfumeStock(int perfumeId, int stockValue)
	{
		Optional<Perfume> optional = perfumeRepo.findById(perfumeId);
		Perfume perfumeEntity = optional.get();
		if(stockValue<=0)
		{
			return "Please enter a valid amount";
		}
		else
		{
			stockValue=perfumeEntity.getStock()+stockValue;
			perfumeEntity.setStock(stockValue);
			perfumeRepo.save(perfumeEntity);
			return perfumeEntity.getProductName()+" has been restocked to "+perfumeEntity.getStock()+" units.";
		}
	}
	
	//Stock update when buyer purchases a stock
			public String buyerPerfumeStock(int perfumeId, int stockValue)
			{
				Optional<Perfume> optional = perfumeRepo.findById(perfumeId);
				Perfume perfumeEntity = optional.get();
				if (perfumeEntity.getStock().equals(0))
				{
					return perfumeEntity.getProductName()+" is out of stock";
				}
				else if (stockValue<0 || perfumeEntity.getStock()-stockValue<0)
				{
					return "Currently, "+perfumeEntity.getStock()+" "+perfumeEntity.getProductName()+" are available.";
				}
				else
				{
					int temp =stockValue;
					stockValue = perfumeEntity.getStock()-stockValue;
					perfumeEntity.setStock(stockValue);
					perfumeRepo.save(perfumeEntity);
					return "You bought "+temp+" "+perfumeEntity.getProductName()+" and currently "+perfumeEntity.getStock()+" are available.";
				}
			}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
