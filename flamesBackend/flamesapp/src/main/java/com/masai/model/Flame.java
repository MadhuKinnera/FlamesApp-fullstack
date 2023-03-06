package com.masai.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Flame {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flameId;

	private String girlName;

	private String boyName;
	
	private String relation;

	private LocalDateTime time;

}
