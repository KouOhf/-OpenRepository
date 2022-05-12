package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.domain.Master;

public interface MasterRepository extends JpaRepository<Master, Integer> {
	@Query("SELECT u FROM Master u WHERE u.categoryCd = :categoryCd")
	List<Master> masterList(@Param("categoryCd") String categoryCd);

}
