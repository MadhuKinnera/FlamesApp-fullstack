package com.masai.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FlameException;
import com.masai.model.Flame;
import com.masai.repository.FlameRepo;

@Service
public class FlameServiceImpl implements FlameService {

	private FlameRepo fRepo;

	@Autowired
	public FlameServiceImpl(FlameRepo fRepo) {
		this.fRepo = fRepo;
	}

	@Override
	public Flame saveFlame(String boyName, String girlName) throws FlameException {
		if (boyName.length() < 3 || girlName.length() < 3) {
			throw new FlameException("Invalid Names Found");
		}

		StringBuilder boy = new StringBuilder();
		StringBuilder girl = new StringBuilder();

		for (Character c : boyName.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				continue;
			}

			if (!Character.isLetterOrDigit(c)) {
				throw new FlameException("Invalid Symbols Found");
			}

			boy.append(c);
		}

		for (Character c : girlName.toCharArray()) {
			if (Character.isSpaceChar(c)) {
				continue;
			}

			if (!Character.isLetterOrDigit(c)) {
				throw new FlameException("Invalid Symbols Found");
			}

			girl.append(c);
		}

		String relation = findRelation(boy.toString(), girl.toString());

		Flame flame = new Flame();

		flame.setBoyName(boyName);
		flame.setGirlName(girlName);
		flame.setRelation(relation);
		flame.setTime(LocalDateTime.now());

		return fRepo.save(flame);
	}

	public String findRelation(String boy, String girl) {

		Map<Character, String> map = new HashMap<>();

		map.put('F', "Friends");
		map.put('L', "Lovers");
		map.put('A', "Affectionate");
		map.put('M', "Marriage");
		map.put('E', "Enemies");
		map.put('S', "Sibling");
		
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		
		for(Character c : boy.toCharArray())
			list1.add(c);
		
		for(Character c : girl.toCharArray()) {
			if(list1.contains(c)) {
				//System.out.println(c+" is removed");
				list1.remove(c);
			}else {
				list2.add(c);
			}
		}
//		System.out.println(list1);
//		System.out.println(list2);

		int n = list1.size()+list2.size();

		List<Character> flames = new ArrayList<>();
		
		flames.add('F');
		flames.add('L');
		flames.add('A');
		flames.add('M');
		flames.add('E');
		flames.add('S');

		
		while (flames.size() != 1) {
			int idx = (n%flames.size()) - 1;
			if (idx == -1)
				idx =  flames.size()- 1;
			flames.remove(idx);
		}
		return map.get(flames.get(0));
	}

}
