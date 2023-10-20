package com.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.dto.ConsignmentManagementDTO;
import com.project.dto.DriverDTO;

@Mapper
public interface ConsignmentManagementMapper {

	//출하정보 전체리스트
	List<ConsignmentManagementDTO> ConsignmentManagement(int pageNo);
	//수주 조회
	ConsignmentManagementDTO obtainorderSearch(String obtainordersearch);
	//기사리스트 전체조회
	List<DriverDTO> DriverList(Map<String, Object> map);
	//전체 출하현황
	int AllConsignment();
	//출하 대기
	int WaitingCount();
	//출하 중
	int ProdeedingCount();
	//출하 완료
	int CompletedCount();
	//출하 일자 검색
	List<ConsignmentManagementDTO> searchconsignmentdate(Map<String, Object> map);
	//사업자 번호 검색
	List<ConsignmentManagementDTO> searchCnum(Map<String, Object> map);
	//선택항목 삭제
	void deleteconsignment(String shipNum);
	//출하 등록 데이터 전달
	int insertconsignment(ConsignmentManagementDTO dto);
	//페이징
	List<ConsignmentManagementDTO> consignmentManagementPaging(int pageNo);
	
	
	
}
