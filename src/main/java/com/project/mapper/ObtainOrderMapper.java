package com.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.dto.ObtainDTO;
@Mapper
public interface ObtainOrderMapper {

	List<ObtainDTO> obtainAllList();

	List<ObtainDTO> BusinessAllList();

	List<ObtainDTO> ProductionAllList();

	List<ObtainDTO> SearchProduction(Map<String, Object>map);

	//수주
	int countAllObtainOrder();

	int countAllObtainOrder1();

	int countAllObtainOrder2();
	
	int countAllObtainOrder3();
	
	int countAllObtainOrder4();
	
	int countAllObtainOrder5();

	List<ObtainDTO> SearchObtainByDate(Map<String, Object> map);
	
	List<ObtainDTO> SearchObtain(Map<String, Object> map);

	//제품
	int DeleteProduction(List<String> pNum);
	
	int countAllOrderProduct();
	//pNum 중복확인
	String checkpNum(String pNum);

	int InsertProduction(ObtainDTO dto);

	ObtainDTO ModiWriteProduction(String pNum);

	int UpdateProduction(ObtainDTO dto);

	int countAllOrderCompany();

	List<ObtainDTO> SearchBusiness(Map<String, Object> map);

	int InsertBusiness(ObtainDTO dto);

	ObtainDTO ModiWriteBusiness(String cNum);

	int UpdateBusiness(ObtainDTO dto);

	int DeleteBusiness(List<String> cNum);

	List<ObtainDTO> SearchCompanyList(Map<String, Object> map);

	List<ObtainDTO> SearchManagerList(Map<String, Object> map);

	List<ObtainDTO> SearchProductList(Map<String, Object> map);
	
	int InsertObtain(ObtainDTO dto);


}
