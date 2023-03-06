package com.masai.service;

import com.masai.exception.FlameException;
import com.masai.model.Flame;

public interface FlameService {
	
	public Flame saveFlame(String boyName,String girlName) throws FlameException;

}
