package com.perfumesite.perfumems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.perfumesite.perfumems.dto.PerfumeDTO;
import com.perfumesite.perfumems.entity.Perfume;
import com.perfumesite.perfumems.service.PerfumeService;

@RestController
public class PerfumeController 
{
	@Autowired
	PerfumeService perfumeService;
	
	//Upload a perfume
	@PostMapping(value="/perfumes", consumes= MediaType.APPLICATION_JSON_VALUE)
	public String uploadPerfume(@RequestBody PerfumeDTO perfume ) 
	{
		Perfume perfuneEntity = perfumeService.uploadPerfum(perfume);
		return "Uploaded "+perfuneEntity.getProductName()+" to the database successfully.";
	}
	
	//Fetch all products
	@GetMapping(value="/perfumes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PerfumeDTO> getAllPerfumes()
	{
		return perfumeService.getAllPerfumes();
	}
	
	//Fetch perfume by productId
	@GetMapping(value="/perfumes/{perfumeId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public PerfumeDTO findById(@PathVariable int perfumeId)
	{
		return perfumeService.getPerfumeById(perfumeId);
	}
	
	//Fetch perfumes by gender
	@GetMapping(value="/perfumes/categories/{category}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PerfumeDTO> getAllPerfumeByGender(@PathVariable String category)
	{
		return perfumeService.getPerfumeByGender(category);
	}
	
	@PutMapping(value="seller/{productId}/{stock}")
	public String sellerPerfumeStock(@PathVariable int productId, @PathVariable int stock)
	{
		return perfumeService.sellerPerfumeStock(productId, stock);
	}
	
	@PutMapping(value="buyer/{productId}/{stock}")
	public String buyerPerfumeStock(@PathVariable int productId, @PathVariable int stock)
	{
		return perfumeService.buyerPerfumeStock(productId, stock);
	}
}
