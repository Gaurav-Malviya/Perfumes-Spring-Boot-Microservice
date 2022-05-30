package com.perfumesite.perfumems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.perfumesite.perfumems.entity.Perfume;

public interface PerfumeRepository extends JpaRepository<Perfume,Integer>
{

	List<Perfume>findByGender(String gender);

}
