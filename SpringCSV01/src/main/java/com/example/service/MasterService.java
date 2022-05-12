package com.example.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Master;
import com.example.repository.MasterRepository;

@Service
@Transactional
public class MasterService {
	@Autowired
	MasterRepository masterRepository;
	
	public Map<String, String> masterMap(String categoryCd){
		List<Master> list = masterRepository.masterList(categoryCd);
		Map<String, String> map = new HashMap<>();
		for (Master item : list) {
			map.put(item.getOutputCd(), item.getOutputName());
		}
		return map;
	}
}
