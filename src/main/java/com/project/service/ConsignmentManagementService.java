package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.dto.ConsignmentManagementDTO;
import com.project.mapper.ConsignmentManagementMapper;

@Service
public class ConsignmentManagementService {
	private ConsignmentManagementMapper mapper;

	public ConsignmentManagementService(ConsignmentManagementMapper mapper) {
		this.mapper = mapper;
	}

	// 출하정보 전체리스트
	public List<ConsignmentManagementDTO> ConsignmentManagement(int currPage) {
		return mapper.ConsignmentManagement(currPage);
	}

	// 수주 조회
	public ConsignmentManagementDTO obtainorderSearch(String obtainordersearch) {
		return mapper.obtainorderSearch(obtainordersearch);
	}
	//출하 전체 카운트
	public int AllConsignment() {
		return mapper.AllConsignment();
	}
	//출고 대기 전체 카운트
	public int WaitingCount() {
		return mapper.WaitingCount();
	}
	//출하 중 전체 카운트
	public int ProdeedingCount() {
		return mapper.ProdeedingCount();
	}
	//출하 완료 전체 카운트
	public int CompletedCount() {
		return mapper.CompletedCount();
	}
	//출하 일자/수주번호로 검색
	public List<ConsignmentManagementDTO> searchconsignmentdate(String startDate, String endDate, String kind,
			String cnumSearch) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startDate", startDate);
		map.put("endDate", endDate);
		map.put("kind", kind);
		map.put("cnumSearch", cnumSearch);
		return mapper.searchconsignmentdate(map);
	}
	
	//수주번호 검색
	public List<ConsignmentManagementDTO> searchCnum(String kind, String cnumSearch) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("kind", kind);
		map.put("cnumSearch", cnumSearch);
		return mapper.searchCnum(map);
	}

	public void deleteconsignment(String shipNum) {
			mapper.deleteconsignment(shipNum);

	}
	//출하 등록 
	public int insertconsignment(ConsignmentManagementDTO dto) {
		return mapper.insertconsignment(dto);
	}

	public List<ConsignmentManagementDTO> consignmentManagementPaging(int pageNo) {
		return mapper.consignmentManagementPaging(pageNo);
	}

}
