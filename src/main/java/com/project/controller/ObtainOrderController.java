package com.project.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.ObtainDTO;
import com.project.service.ObtainOrderService;

@Controller
public class ObtainOrderController {
	private ObtainOrderService obtainService;

	public ObtainOrderController(ObtainOrderService obtainService) {
		this.obtainService = obtainService;
	}

	// 수주조회
	@RequestMapping("/ObtainOrder")
	public ModelAndView obtainOrderList(ModelAndView view) {
		List<ObtainDTO> list = obtainService.obtainAllList();
		int countAllObtainOrder = obtainService.countAllObtainOrder();
		int countAllObtainOrder1 = obtainService.countAllObtainOrder1();
		int countAllObtainOrder2 = obtainService.countAllObtainOrder2();
		int countAllObtainOrder3 = obtainService.countAllObtainOrder3();
		int countAllObtainOrder4 = obtainService.countAllObtainOrder4();
		int countAllObtainOrder5 = obtainService.countAllObtainOrder5();
		view.addObject("countAllObtainOrder", countAllObtainOrder);
		view.addObject("countAllObtainOrder1", countAllObtainOrder1);
		view.addObject("countAllObtainOrder2", countAllObtainOrder2);
		view.addObject("countAllObtainOrder3", countAllObtainOrder3);
		view.addObject("countAllObtainOrder4", countAllObtainOrder4);
		view.addObject("countAllObtainOrder5", countAllObtainOrder5);
		view.addObject("list", list);
		view.setViewName("obtainorder/obtain_order");
		return view;
	}

	@RequestMapping("/obtain/search")
	public ResponseEntity<List<ObtainDTO>> SearchObtainList(
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate,
			@RequestParam(name = "startDate1", required = false) String startDate1,
			@RequestParam(name = "endDate1", required = false) String endDate1, String search, String kind) {
		List<ObtainDTO> list;
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(search);
		System.out.println(kind);
		if (startDate != "" && endDate != "" && startDate1 != "" && endDate1 != "") {
			list = obtainService.SearchObtainByDate(startDate, endDate, startDate1, endDate1, kind, search);
		} else {
			list = obtainService.SearchObtain(kind, search);
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@RequestMapping("/add/companylist")
	public ResponseEntity<List<ObtainDTO>> SearchCompanyList(@RequestParam("cNum") String cNum){
		System.out.println(cNum);
		List<ObtainDTO> list = obtainService.SearchCompanyList(cNum);
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@RequestMapping("/add/managerlist")
	public ResponseEntity<List<ObtainDTO>> SearchManagerList(@RequestParam("mName") String mName){
		System.out.println(mName);
		List<ObtainDTO> list = obtainService.SearchManagerList(mName);
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@RequestMapping("/add/productlist")
	public ResponseEntity<List<ObtainDTO>> SearchProductList(@RequestParam("pNum") String pNum){
		System.out.println(pNum);
		List<ObtainDTO> list = obtainService.SearchProductList(pNum);
		System.out.println(list);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@RequestMapping("/obtain/upload")
	public String InsertObtain(ObtainDTO dto) {
		int result = obtainService.InsertObtain(dto);
		return "redirect:/ObtainOrderInfo";
	}
	

	// 수주등록
	@RequestMapping("/ObtainOrderUpload")
	public String ObtainOrderUpload() {
		return "obtainorder/obtain_order_upload";
	}

	// 수주수정
	@RequestMapping("/ObtainOrderModi")
	public String ObtainOrderModi() {
		return "obtainorder/obtain_order_modi";
	}

	// 제품조회
	@RequestMapping("/ProductionInfo")
	public ModelAndView ProductionList(ModelAndView view) {
		List<ObtainDTO> list = obtainService.ProductionAllList();
		int countAllOrderProduct = obtainService.countAllOrderProduct();
		view.addObject("countAllOrderProduct", countAllOrderProduct);
		view.addObject("list", list);
		view.setViewName("obtainorder/production_info");
		return view;
	}

	@RequestMapping("/production/search")
	public ResponseEntity<String> SearchProduction(String kind, String search) {
		System.out.println(kind);
		System.out.println(search);
		List<ObtainDTO> list = obtainService.SearchProduction(kind, search);
		System.out.println(list);
		return new ResponseEntity(list, HttpStatus.OK);
	}

	// 제품등록
	@RequestMapping("/ProductionInfoUpload")
	public String ProductionInfoUpload() {
		return "obtainorder/production_info_upload";
	}

	@RequestMapping("/confirm/pNum")
	@ResponseBody
	public int checkId(@RequestParam("pNum") String pNum) throws Exception {
		boolean userNumValid = obtainService.checkpNum(pNum);
		System.out.println(userNumValid);
		if (!userNumValid) {
			return 0; // 현재 아이디가 일치하지 않음
		}
		return 1; // 아이디 조회 성공

	}

	@RequestMapping("/production/upload")
	public String InsertProduction(ObtainDTO dto) {
		int result = obtainService.InsertProduction(dto);
		System.out.println(dto);
		return "redirect:/ProductionInfo";
	}

	// 제품수정
	@RequestMapping("/ProductionInfoModi")
	public ModelAndView ModiWriteProduction(String pNum) {
		ObtainDTO dto = obtainService.ModiWriteProduction(pNum);
		ModelAndView view = new ModelAndView("obtainorder/production_info_modi");
		view.addObject("sell", dto);
		return view;
	}

	@RequestMapping("/business/search")
	public ResponseEntity<String> SearchBusiness(String kind, String search) {
		System.out.println(kind);
		System.out.println(search);
		List<ObtainDTO> list = obtainService.SearchBusiness(kind, search);
		System.out.println(list);
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@RequestMapping("/production/update")
	public String UpdateProduction(ObtainDTO dto) {
		obtainService.UpdateProduction(dto);
		return "redirect:/ProductionInfo";
	}

	@RequestMapping("/production/delete")
	public ResponseEntity<String> DeleteProdution(@RequestParam("pNum[]") List<String> pNum) {
		System.out.println(pNum);
		int result = obtainService.DeleteProduction(pNum);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("count", result);
		if (result == 0)
			map.put("message", "데이터 삭제 실패");
		else
			map.put("message", "데이터 삭제 성공");

		return new ResponseEntity(map, HttpStatus.OK);
	}

	// 고객업체 조회
	@RequestMapping("/BusinessInfo")
	public ModelAndView BusinessList(ModelAndView view) {
		List<ObtainDTO> list = obtainService.BusinessAllList();
		int countAllOrderCompany = obtainService.countAllOrderCompany();
		view.addObject("countAllOrderCompany", countAllOrderCompany);
		view.addObject("list", list);
		view.setViewName("obtainorder/business_info");
		return view;
	}

	// 고객업체 등록
	@RequestMapping("/BusinessInfoUpload")
	public String BusinessInfoUpload() {
		return "obtainorder/business_info_upload";
	}

	// 고객업체 수정
	@RequestMapping("/BusinessInfoModi")
	public ModelAndView ModiWriteBusiness(String cNum) {
		ObtainDTO dto = obtainService.ModiWriteBusiness(cNum);
		ModelAndView view = new ModelAndView("obtainorder/business_info_modi");
		view.addObject("sell", dto);
		System.out.println(dto);
		return view;
	}

	@RequestMapping("/business/upload")
	public String InsertBusiness(ObtainDTO dto) {
		int result = obtainService.InsertBusiness(dto);
		return "redirect:/BusinessInfo";
	}
	@RequestMapping("/business/update")
	public String UpdateBusiness(ObtainDTO dto) {
		obtainService.UpdateBusiness(dto);
		return "redirect:/BusinessInfo";
	}
	@RequestMapping("/business/delete")
	public ResponseEntity<String> DeleteBusiness(@RequestParam("cNum[]") List<String> cNum){
		int result = obtainService.DeleteBusiness(cNum);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("count", result);
		if (result == 0)
			map.put("message", "데이터 삭제 실패");
		else
			map.put("message", "데이터 삭제 성공");

		return new ResponseEntity(map, HttpStatus.OK);
	}

}
