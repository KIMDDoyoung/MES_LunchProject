package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.OrderDTO;
import com.project.service.OrderService;

@Controller
public class OrderController {
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//협력업체 조회
	@RequestMapping("/Contractor")
	public ModelAndView Contractor(ModelAndView view) {
		List<OrderDTO> list = orderService.viewAllContractor();
		System.out.println(list);
		view.addObject("list", list);
		view.setViewName("order/Contractor");
		return view;
	}
	
	//협력업체 선택 데이터 삭제
	@RequestMapping("/contractor/delete/{companyNo}")
	@ResponseBody
	public ResponseEntity<String> deleteContractorAndRelatedData(@PathVariable("companyNo") String companyNo) {
		try {
			
			orderService.deleteContractorAndRelatedData(companyNo);
			
			return ResponseEntity.ok("삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"삭제 실패\"}");
		}
	}
	
	//협력업체 등록
	@RequestMapping("/ContractorRegister")
	public String ContractorRegister() {
		return "order/contractorRegister";
	}
	
	//협럭업체 수정
	@RequestMapping("/ContractorEdit")
	public String ContractorEdit() {
		return "order/contractorEdit";
	}
	
	//원부재료 조회
	@RequestMapping("/MaterialInfo")
	public ModelAndView MaterialInfo(ModelAndView view) {
		List<OrderDTO> list = orderService.viewAllMaterial();
		System.out.println(list);
		view.addObject("list", list);
		view.setViewName("order/MaterialInfo");
		return view;
	}
	
	//원부재료 문자열 조회
	@RequestMapping("/material/search")
	public ResponseEntity<List<OrderDTO>> MaterialSearchList(
		    @RequestParam("search") String search
	) {
	    List<OrderDTO> dtoList;

	    dtoList = orderService.searchMaterial(search);

	    return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}
	
	//협력업체 데이터 삭제
	@RequestMapping("/material/delete/{companyNo}")
	@ResponseBody
	public ResponseEntity<String> deleteMaterialAndRelatedData(@PathVariable("companyNo") String companyNo) {
	    try {

	        orderService.deleteMaterialAndRelatedData(companyNo);

	        return ResponseEntity.ok("삭제되었습니다.");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"삭제 실패\"}");
	    }
	}
	
	//원부재료 등록
	@RequestMapping("MaterialRegister")
	public String MaterialRegister() {
		return "order/material_register";
	}
	
	//원부재료 수정
	@RequestMapping("/MaterialEdit")
	public String MaterialEdit() {
		return "order/material_edit";
	}
	
	//발주관리 리스트
	@RequestMapping("/Order")
	public ModelAndView Oder(ModelAndView view) {
		List<OrderDTO> list = orderService.viewAllOrder();
		System.out.println(list);
		view.addObject("list", list);
		view.setViewName("order/Order");
		return view;
	}
	
	//발주관리 발주날짜+문자열 조회
	@RequestMapping("/buy/search")
	public ResponseEntity<List<OrderDTO>> BuySearchList(
	    @RequestParam(name = "startDate", required = false) String startDate,
	    @RequestParam(name = "endDate", required = false) String endDate,
	    @RequestParam("search") String search
	) {
	    List<OrderDTO> dtoList;
	    
	    if (startDate != null && endDate != null) {
	        // startDate와 endDate를 사용하여 검색 수행
	        dtoList = orderService.searchUserByDateRange(startDate, endDate, search);
	    } else {
	        // startDate와 endDate가 제공되지 않으면 단순 키워드 검색 수행
	        dtoList = orderService.searchUser(search);
	    }

	    return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	//발주관리 선택 데이터 삭제
	@RequestMapping("/buy/delete/{companyNo}")
	@ResponseBody
	public ResponseEntity<String> deleteBuyAndRelatedData(@PathVariable("companyNo") String companyNo) {
	    try {

	        orderService.deleteBuyAndRelatedData(companyNo);

	        return ResponseEntity.ok("삭제되었습니다.");
	    } catch (Exception e) {
	    	e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"삭제 실패\"}");
	    }
	}
	
	//발주관리 수정
	@RequestMapping("/OrderRgisterEdit")
	public String OrderRgisterEdit() {
			return "order/order_register_edit";
	}
	
	//발주관리 등록
		@RequestMapping("/OrderRegister")
		public String OrderRegister() {
				return "order/order_register";
		}
		
	//발주관리 등록 form
	@RequestMapping("/order/register/action")
	public String OderRegister(OrderDTO dto) {
		 try {
		      orderService.insertOrderRegister(dto);
		      return "redirect:/Order";
		 } catch (Exception e) {
		      e.printStackTrace();
		      return "/OrderRegister";
		 }
	}
	
}
