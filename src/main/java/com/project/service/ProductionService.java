package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.ProductionDTO;
import com.project.mapper.ProductionMapper;

@Service
public class ProductionService {
	
	private ProductionMapper productionMapper;

	public ProductionService(ProductionMapper productionMapper) {
		this.productionMapper = productionMapper;
	}
	
	public List<ProductionDTO> selectAll() {
		return productionMapper.selectAll();
	}

	public List<ProductionDTO> selectProduction(String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		return productionMapper.selectProduction(map);
	}
	
	public List<ProductionDTO> selectDate(String startDate, String endDate) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);     
		return productionMapper.selectDate(map);
	}
	
	 public void register(ProductionDTO productionDTO) {
	        try {
	            productionMapper.insertProduction(productionDTO);
	            productionMapper.insertProduct(productionDTO);
	            productionMapper.insertSell(productionDTO);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // 오류 처리 로직 추가
	        }
	    }

	public int deleteProduction(List<String> pNum) {
		return productionMapper.deleteProduction(pNum);
	}

	public void ProductionModify(ProductionDTO productionDTO) {
		try {
            productionMapper.productionModify(productionDTO);
            productionMapper.productModify(productionDTO);
            productionMapper.sellModify(productionDTO);
        } catch (Exception e) {
            e.printStackTrace();
            // 오류 처리 로직 추가
        }
	}


	

	
	
	
}
