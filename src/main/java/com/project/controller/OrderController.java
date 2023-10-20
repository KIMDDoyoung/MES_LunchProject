package com.project.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	// 협력업체 조회
	@RequestMapping("/Contractor")
	public ModelAndView Contractor(ModelAndView view) {
		List<OrderDTO> list = orderService.viewAllContractor();
		System.out.println(list);
		view.addObject("list", list);
		view.setViewName("order/Contractor");
		return view;
	}

	// 협력업체 선택 데이터 삭제
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

	// 협력업체 등록
	@RequestMapping("/ContractorRegister")
	public String ContractorRegister() {
		return "order/contractorRegister";
	}

	// 협력업체 등록 form
	@RequestMapping("/contractor/register/action")
	public String ContractorRegister(@ModelAttribute OrderDTO dto) {
		try {
			orderService.ContractorRegister(dto);
			return "redirect:/Contractor"; // 등록 후 해당 페이지로 이동
		} catch (Exception e) {
			e.printStackTrace();
			return "ContractorRegister"; // 실패 시 등록 페이지로 유지
		}
	}

	// 협럭업체 수정 페이지 이동
	@RequestMapping("/ContractorEdit")
	public ModelAndView ContractorEdit(String companyNo) {
		System.out.println(companyNo);
		OrderDTO ContractorDetails = orderService.ContractorEdit(companyNo);
		ModelAndView modelAndView = new ModelAndView("order/contractorEdit");
		modelAndView.addObject("ContractorDetails", ContractorDetails);
		return modelAndView;
	}

	// 협력업체 수정하기
	@RequestMapping("/updateContractor")
	public String updateContractor(@ModelAttribute OrderDTO dto) {
		try {
			orderService.updateContractor(dto);
			System.out.println(dto);
			return "redirect:/Contractor";

		} catch (Exception e) {
			e.printStackTrace();
			return "ContractorEdit"; // 실패 시 수정 페이지로 유지
		}

	}

	// 원부재료 조회
	@RequestMapping("/MaterialInfo")
	public ModelAndView MaterialInfo(ModelAndView view) {
		List<OrderDTO> list = orderService.viewAllMaterial();
		System.out.println(list);
		view.addObject("list", list);
		view.setViewName("order/MaterialInfo");
		return view;
	}

	// 원부재료 문자열 조회
	@RequestMapping("/material/search")
	public ResponseEntity<List<OrderDTO>> MaterialSearchList(@RequestParam("search") String search) {
		List<OrderDTO> dtoList;

		dtoList = orderService.searchMaterial(search);

		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	// 원부재료 등록 협력업체 pop 조회
	@ResponseBody
	@RequestMapping("/pop/constractorlist")
	// @RequestParam(name="driverCode",defaultValue = "")→name의 값은 driverCode 값이 없으면
	// ""으로 표시
	public List<OrderDTO> ConstractorList(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "kind", defaultValue = "buyName") String kind) {
		// kind=카테고리값 search=검색값
		System.out.println("search:" + search);
		System.out.println(kind);
		List<OrderDTO> driverlist = orderService.ConstractorList(kind, search);
		System.out.println(driverlist);

		return driverlist;
	}

	// 협력업체 데이터 삭제
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

	// 원부재료 등록
	@RequestMapping("MaterialRegister")
	public String MaterialRegister(Model model) {

		return "order/material_register";
	}

	public class BuyNoCode {
		private static final int BUYNOCODE_LENGTH = 6; // 코드 길이.
		private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 코드에 적용될 문자형태(알파벳+숫자)
		private Set<String> generatedbuyNoCode = new HashSet<>();

		public void setExistingbuyNoCode(Set<String> buyNoCode) {
			generatedbuyNoCode.addAll(buyNoCode);
		}

		public void signup(OrderDTO dto) {

			String buyNoCode = UniquebuyNoCode();
			dto.setBuyNo(buyNoCode);

		}

		private String UniquebuyNoCode() {
			Random random = new Random();
			StringBuilder buyNoCode = new StringBuilder();

			while (true) {
				for (int i = 0; i < BUYNOCODE_LENGTH; i++) {
					int index = random.nextInt(CHARACTERS.length());
					char digit = CHARACTERS.charAt(index);
					buyNoCode.append(digit);
				}

				String generatedCode = buyNoCode.toString();
				if (!generatedbuyNoCode.contains(generatedCode)) {
					generatedbuyNoCode.add(generatedCode);
					return generatedCode;
				}
				System.out.println("생성된 출하코드:" + buyNoCode);
				buyNoCode.setLength(0); // 생성될때 초기화
			}
		}

	}

	// 원부재료 등록 form
	@RequestMapping("/material/register/action")
	public String MaterialRegister(@ModelAttribute OrderDTO dto) {
		try {

			BuyNoCode buyNoGenerator = new BuyNoCode();

			buyNoGenerator.signup(dto);
			System.out.println("발주코드 :" + dto.getBuyNo());

			orderService.registerMaterial(dto);
			return "redirect:/MaterialInfo"; // 등록 후 해당 페이지로 이동
		} catch (Exception e) {
			e.printStackTrace();
			return "MaterialRegister"; // 실패 시 등록 페이지로 유지
		}
	}

	// 원부재료 수정
	@RequestMapping("/MaterialEdit")
	public String MaterialEdit() {
		return "order/material_edit";
	}

	// 발주관리 리스트
	@RequestMapping("/Order")
	public ModelAndView Oder(ModelAndView view) {
		List<OrderDTO> list = orderService.viewAllOrder();
		System.out.println(list);
		view.addObject("list", list);
		view.setViewName("order/Order");
		return view;
	}

	// 발주관리 발주날짜+문자열 조회
	@RequestMapping("/buy/search")
	public ResponseEntity<List<OrderDTO>> BuySearchList(
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate, @RequestParam("search") String search) {
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

	// 발주관리 선택 데이터 삭제
	@RequestMapping("/buy/delete/{buyNo}")
	public ResponseEntity<String> deleteOrdersByNo(@PathVariable("buyNo") String buyNo) {
		try {
			System.out.println(buyNo);
			orderService.deleteOrdersByNo(buyNo);
			return ResponseEntity.ok("주문이 성공적으로 삭제되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("주문 삭제 중 오류가 발생했습니다.");
		}
	}

	// 발주관리 수정 페이지 이동
	@RequestMapping("/editOrder")
	public ModelAndView editOrder(String buyNo, String materialNo) {
		OrderDTO orderDetails = orderService.editOrder(buyNo, materialNo);
		ModelAndView modelAndView = new ModelAndView("order/order_register_edit");
		modelAndView.addObject("orderDetails", orderDetails);
		return modelAndView;
	}

	
	//발주 수정 컨트롤러
	
	 @RequestMapping("/updateOrder") public String updateOrder(@ModelAttribute
	 OrderDTO orderDTO) { orderService.updateOrder(orderDTO); return
	 "redirect:/Order";
	  
	 }
	 

	// 발주관리 등록
	@RequestMapping("/OrderRegister")
	public String OrderRegister() {
		return "order/order_register";
	}

	// 발주관리 등록 form
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