package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Flame;

public interface FlameRepo extends JpaRepository<Flame, Integer>{
	

}
