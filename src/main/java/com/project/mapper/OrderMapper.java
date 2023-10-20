package com.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.dto.OrderDTO;

@Mapper
public interface OrderMapper {

	List<OrderDTO> searchUser(Map<String, Object> map);

	List<OrderDTO> viewAllOrder();

	List<OrderDTO> searchUserByDateRange(Map<String, Object> map);

	void deleteOrdersByNo(String buyNo);

	List<OrderDTO> viewAllMaterial();

	List<OrderDTO> searchMaterial(Map<String, Object> map);

	void deleteBuy(String companyNo);

	void deleteMaterial(String companyNo);

	void deleteCompanyBuy(String companyNo);

	List<OrderDTO> viewAllContractor();

	void deleteManagerContractor(String companyNo);

	void deleteCompanyBuyContractor(String companyNo);

	void insertIntoCompany(String buyName, String companyNo);

	void insertIntoMaterial(String materioalName, String materialNo, String companyNo);

	void insertIntoBuy(String dateOrder, String dateReceived, String buyNo, String materioalAmount, String materialNo, String companyNo);
	
	OrderDTO editOrder(Map<String, Object> map);

	void updateOrder(String buyNo, String buyName, String materialNo, String materioalName, String dateOrder,
			String dateReceived, String materioalAmount, String companyNo);

	void MaterialinsertIntoMaterial(String materialNo, String materioalName,  String mUnit, int mBOXcount,
			String companyNo);

	void ContractorinsertIntoCompany(String companyNo, String buyName);

	void ContractorinsertIntoManager(String managerName, String managerContact, String mMail,
			String companyNo);

	void OrderupdateMaterial(@Param("materialNo") String materialNo, @Param("materioalName")
			String materioalName, String companyNo);

	void OrderupdateBuy(@Param("buyNo") String buyNo, @Param("dateOrder") String dateOrder, 
			@Param("dateReceived") String dateReceived, @Param("materioalAmount") String materioalAmount, @Param("materialNo") String materialNo, @Param("companyNo") String companyNo);

	OrderDTO ContractorEdit(Map<String, Object> map);

	void updateContractorCompany(String buyName);

	void updateConstractorManager(String managerName, String managerContact, String mMail);

	List<OrderDTO> ConstractorList(Map<String, Object> map);


	/* void MaterialinsertIntoBuyNNo(String buyNo); */
	


}
