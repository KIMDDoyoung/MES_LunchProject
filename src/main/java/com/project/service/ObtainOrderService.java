package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.dto.ObtainDTO;
import com.project.mapper.ObtainOrderMapper;
@Service
public class ObtainOrderService {
	private ObtainOrderMapper obtainmapper;
	
	public ObtainOrderService(ObtainOrderMapper obtainmapper) {
		this.obtainmapper = obtainmapper;
	}

	public List<ObtainDTO> obtainAllList() {
		return obtainmapper.obtainAllList();
	}

	public List<ObtainDTO> BusinessAllList() {
		return obtainmapper.BusinessAllList();
	}

	public List<ObtainDTO> ProductionAllList() {
		return obtainmapper.ProductionAllList();
	}
	public List<ObtainDTO> SearchProduction(String kind, String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		return obtainmapper.SearchProduction(map);
	}

	public int countAllObtainOrder() {
		return obtainmapper.countAllObtainOrder();
	}

	public int countAllObtainOrder1() {
		return obtainmapper.countAllObtainOrder1();
	}
	public int countAllObtainOrder2() {
		return obtainmapper.countAllObtainOrder2();
	}
	public int countAllObtainOrder3() {
		return obtainmapper.countAllObtainOrder3();
	}
	public int countAllObtainOrder4() {
		return obtainmapper.countAllObtainOrder4();
	}
	public int countAllObtainOrder5() {
		return obtainmapper.countAllObtainOrder5();
	}

	public int DeleteProduction(List<String> pNum) {
		return obtainmapper.DeleteProduction(pNum);
	}

	public List<ObtainDTO> SearchObtainByDate(String startDate, String endDate, String startDate1, String endDate1, String kind, String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("startDate1", startDate1);
		map.put("endDate1", endDate1);
		map.put("kind", kind);
		map.put("search", search);
		return obtainmapper.SearchObtainByDate(map);
	}

	public List<ObtainDTO> SearchObtain(String kind, String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		return obtainmapper.SearchObtain(map);
	}

	public int countAllOrderProduct() {
		return obtainmapper.countAllOrderProduct();
	}

	public boolean checkpNum(String pNum) {
		String dto = obtainmapper.checkpNum(pNum);
		return dto != null;
	}

	public int InsertProduction(ObtainDTO dto) {
		return obtainmapper.InsertProduction(dto);
	}

	public ObtainDTO ModiWriteProduction(String pNum) {
		return obtainmapper.ModiWriteProduction(pNum);
	}

	public int UpdateProduction(ObtainDTO dto) {
		return obtainmapper.UpdateProduction(dto);
	}

	//고객 카운트
	public int countAllOrderCompany() {
		return obtainmapper.countAllOrderCompany();
	}

	public List<ObtainDTO> SearchBusiness(String kind, String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("search", search);
		return obtainmapper.SearchBusiness(map);
	}

	public int InsertBusiness(ObtainDTO dto) {
		return obtainmapper.InsertBusiness(dto);
	}

	public ObtainDTO ModiWriteBusiness(String cNum) {
		return obtainmapper.ModiWriteBusiness(cNum);
	}

	public int UpdateBusiness(ObtainDTO dto) {
		return obtainmapper.UpdateBusiness(dto);
	}

	public int DeleteBusiness(List<String> cNum) {
		return obtainmapper.DeleteBusiness(cNum);
	}
	//고객업체 서치
	public List<ObtainDTO> SearchCompanyList(String cNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cNum", cNum);
		return obtainmapper.SearchCompanyList(map);
	}
	//담당자 서치
	public List<ObtainDTO> SearchManagerList(String mName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mName", mName);
		return obtainmapper.SearchManagerList(map);
	}
	//제품서치
	public List<ObtainDTO> SearchProductList(String pNum) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pNum", pNum);
		return obtainmapper.SearchProductList(map);
	}

	public int InsertObtain(ObtainDTO dto) {
		return obtainmapper.InsertObtain(dto);
	}

	
}
