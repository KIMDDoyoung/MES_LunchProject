package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.dto.Stock_MaterialDTO;
import com.project.dto.Stock_ProductDTO;
import com.project.mapper.StockMapper;

@Service
public class StockService {

	private StockMapper mapper;

	public StockService(StockMapper mapper) {
		this.mapper = mapper;
	}

	public List<Stock_MaterialDTO> selectAllMaterial() {
		return mapper.selectAllMaterial();
	}

	public int countAllMaterial() {
		return mapper.countAllMaterial();
	}

	public List<Stock_ProductDTO> selectAllProduct() {
		return mapper.selectAllProduct();
	}

	public int countAllProduct() {
		return mapper.countAllProduct();
	}

	public int InsertMaterial(Stock_MaterialDTO dto) {
		return mapper.InsertMaterial(dto);
	}

	public int InsertProduct(Stock_ProductDTO dto) {
		return mapper.InsertProduct(dto);
	}

	public Stock_MaterialDTO SelectMaterial(String m_num) {
		return mapper.SelectMaterial(m_num);
	}

	public int UpdateMaterial(Stock_MaterialDTO dto) {
		return mapper.UpdateMaterial(dto);
	}

	public Stock_ProductDTO SelectProduct(String p_num) {
		return mapper.SelectProduct(p_num);
	}

	public int UpdateProduct(Stock_ProductDTO dto) {
		return mapper.UpdateProduct(dto);
	}

	public List<Stock_MaterialDTO> SearchMaterial(String search) {
		return mapper.SearchMaterial(search);
	}

	public List<Stock_ProductDTO> SearchProduct(String search) {
		return mapper.SearchProduct(search);
	}

	public int DeleteMaterial(String mNum) {
		return mapper.DeleteMaterial(mNum);
	}

	public int DeleteProduct(String pNum) {
		return mapper.DeleteProduct(pNum);
	}

}
