package com.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.dto.OrderDTO;

@Mapper
public interface OrderMapper {

	List<OrderDTO> searchUser(Map<String, Object> map);

	List<OrderDTO> viewAllOrder();

	List<OrderDTO> searchUserByDateRange(Map<String, Object> map);

	void deleteOrdersByCompanyNo(String companyNo);

	void deleteCompanyBuyByCompanyNo(String companyNo);

	void deleteMaterialByCompanyNo(String companyNo);

	List<OrderDTO> viewAllMaterial();

	List<OrderDTO> searchMaterial(Map<String, Object> map);

	void deleteBuy(String companyNo);

	void deleteMaterial(String companyNo);

	void deleteCompanyBuy(String companyNo);

	List<OrderDTO> viewAllContractor();

	void deleteManagerContractor(String companyNo);

	void deleteCompanyBuyContractor(String companyNo);

	void insertIntoBuy(String dateOrder, String dateReceived, String buyNo, String materioalAmount);

	void insertIntoCompany(String buyName, String companyNo);

	void insertIntoMaterial(String materioalName, String materialNo);






}
