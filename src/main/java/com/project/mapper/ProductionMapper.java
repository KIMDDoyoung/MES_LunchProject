package com.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.project.dto.ProductionDTO;

@Mapper
public interface ProductionMapper {

	List<ProductionDTO> selectAll();
	
	List<ProductionDTO> selectProduction(Map<String, Object> map);

	List<ProductionDTO> selectDate(Map<String, Object> map);

	void insertProduction(ProductionDTO productionDTO);

	void insertProduct(ProductionDTO productionDTO);

	void insertSell(ProductionDTO productionDTO);

	int deleteProduction(List<String> pNum);

	void productionModify(ProductionDTO productionDTO);

	void productModify(ProductionDTO productionDTO);

	void sellModify(ProductionDTO productionDTO);

	


	






}
