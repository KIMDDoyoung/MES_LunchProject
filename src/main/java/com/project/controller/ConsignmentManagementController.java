package com.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.project.dto.ConsignmentManagementDTO;
import com.project.dto.DriverDTO;
import com.project.service.ConsignmentManagementService;
import com.project.service.DriverService;
import com.project.vo.PagingVO;

@Controller
public class ConsignmentManagementController {

	private ConsignmentManagementService consignmentManagementService;
	private DriverService driverService;

	public ConsignmentManagementController(ConsignmentManagementService consignmentManagementService,
			DriverService driverService) {
		super();
		this.consignmentManagementService = consignmentManagementService;
		this.driverService = driverService;
	}

	// 출하 현황
	@RequestMapping("/ConsignmentManagement")
	public ModelAndView ConsignmentManagement(@RequestParam(name = "pageNo",defaultValue = "1")int pageNo, ModelAndView view) {
		List<ConsignmentManagementDTO> list = consignmentManagementService.ConsignmentManagement(pageNo);
		int allcount = consignmentManagementService.AllConsignment();
		int waitingcount = consignmentManagementService.WaitingCount();
		int proceedingcount = consignmentManagementService.ProdeedingCount();
		int completedcount = consignmentManagementService.CompletedCount();
		// System.out.println(list);
		// 각 단계 개수표시
		view.addObject("allcount", allcount);
		view.addObject("waitingcount", waitingcount);
		view.addObject("proceedingcount", proceedingcount);
		view.addObject("completedcount", completedcount);
		view.addObject("all_consignmentlist", list);
		// 페이지 VO불러옴
		System.err.println(pageNo);
		PagingVO vo = new PagingVO(allcount, pageNo, 10, 5);
		System.out.println(vo.toString());
		view.addObject("paging",vo);
		
		view.setViewName("consignmentmanagement/productmanagement");
		return view;
	}

	// 날자+수주번호 검색
	@RequestMapping("/ConsignmentManagement/search")
	public ResponseEntity<List<ConsignmentManagementDTO>> searchconsignmentdate(
			@RequestParam(name = "startDate", required = false) String startDate,
			@RequestParam(name = "endDate", required = false) String endDate,
			@RequestParam(name = "kind", defaultValue = "ship_num") String kind,
			@RequestParam(name = "cnumSearch") String cnumSearch) {
		List<ConsignmentManagementDTO> consignmentList;
		// System.out.println(startDate);
		// System.out.println(endDate);
		// System.out.println(cnumSearch);
		// null이 아닌 ""빈문자열로 지정해줘야한다.
		if (startDate != "" && endDate != "") {
			consignmentList = consignmentManagementService.searchconsignmentdate(startDate, endDate, kind, cnumSearch);
		} else {
			consignmentList = consignmentManagementService.searchCnum(kind, cnumSearch);
		}
		// System.out.println(consignmentList);
		return new ResponseEntity<>(consignmentList, HttpStatus.OK);
	}
	// 출하코드 검색시 값 출력(완전 일치)

	// 선택 항목 삭제
	@RequestMapping("/ConsignmentManagement/delete/{shipNum}")
	public ResponseEntity<String> deleteconsignment(@PathVariable("shipNum") String shipNum) {
		System.out.println("1:" + shipNum);
		consignmentManagementService.deleteconsignment(shipNum);
		System.out.println("2:" + shipNum);

		return new ResponseEntity("선택항목을 삭제했습니다.", HttpStatus.OK);
	}

	// 출하등록 - view
	@RequestMapping("/AddProductConsignment")
	public String ProductConsignment() {
		return "consignmentmanagement/addproductconsignment";
	}

	// 출하코드 랜덤생성
	public class ShipNumCode {
		private static final int SHIPNUMCODE_LENGTH = 6; // 코드 길이.
		private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; // 코드에 적용될 문자형태(알파벳+숫자)
		private Set<String> generatedshipNumCode = new HashSet<>();

		public void setExistingshipNumCode(Set<String> shipNumCode) {
			generatedshipNumCode.addAll(shipNumCode);
		}

		public void signup(ConsignmentManagementDTO dto) {

			String shipNumCode = UniqueShipNumCode();
			dto.setShipNum(shipNumCode);

		}

		private String UniqueShipNumCode() {
			Random random = new Random();
			StringBuilder shipNumCode = new StringBuilder();

			while (true) {
				for (int i = 0; i < SHIPNUMCODE_LENGTH; i++) {
					int index = random.nextInt(CHARACTERS.length());
					char digit = CHARACTERS.charAt(index);
					shipNumCode.append(digit);
				}

				String generatedCode = shipNumCode.toString();
				if (!generatedshipNumCode.contains(generatedCode)) {
					generatedshipNumCode.add(generatedCode);
					return generatedCode;
				}
				System.out.println("생성된 출하코드:" + shipNumCode);
				shipNumCode.setLength(0); // 생성될때 초기화
			}
		}

	}

	// 출하등록 데이터 전달
	@RequestMapping(value = "/AddProductConsignment/action", method = RequestMethod.POST)
	public String AddProductConsignment(ConsignmentManagementDTO dto) {

		System.out.println("dto:" + dto);
		// ShipNumCode 객체 생성
		ShipNumCode shipNumGenerator = new ShipNumCode();
		// 생성된 출하 코드 설정
		// 출하코드 생성 및 dto 저장
		shipNumGenerator.signup(dto);
		//
		// DTO에 저장된 shipAmount와 sAmount 값을 가져옴.
		int shipAmount = dto.getShipAmount();
		int sAmount = dto.getsAmount();

		// 조건에 따라 sPhase 값을 설정
		if (shipAmount == sAmount) {
			dto.setsPhase("2");
		} else if (shipAmount < sAmount && shipAmount > 0) {
			dto.setsPhase("1");
		} else if (shipAmount == 0) {
			dto.setsPhase("0");
		}

		System.out.println("출하코드 :" + dto.getShipNum());
		System.out.println("dto2:" + dto);
		// 1건의 결과 값으로 등록되므로 String는 사용 불가 int 사용
		int result = consignmentManagementService.insertconsignment(dto);
		return "redirect:/ConsignmentManagement";
	}

	// 수주리스트 검색해서 innerHtml로 입력바로 받기
	@ResponseBody
	@RequestMapping(value = "/AddProductConsignment/Obtainordersearch", method = RequestMethod.POST)
	public ConsignmentManagementDTO obtainorderSearch(String obtainordersearch) {
		ConsignmentManagementDTO dto = consignmentManagementService.obtainorderSearch(obtainordersearch);
		// System.out.println(dto);
		return dto;
	}

	// 기사연락처 리스트조회 및 검색기능
	@ResponseBody
	@RequestMapping("/AddProductConsignment/driverlist")
	// @RequestParam(name="driverCode",defaultValue = "")→name의 값은 driverCode 값이 없으면
	// ""으로 표시
	public List<DriverDTO> DriverList(@RequestParam(name = "search", defaultValue = "") String search,
			@RequestParam(name = "kind", defaultValue = "d_contact") String kind) {
		// kind=카테고리값 search=검색값
		// System.out.println("search:" + search);
		// System.out.println(kind);
		List<DriverDTO> driverlist = driverService.DriverList(kind, search);
		// System.out.println(driverlist);

		return driverlist;
	}

	// 출고요청
	@RequestMapping("/RequstRelease")
	public String RequstRelease() {
		return "consignmentmanagement/requstrelease";
	}

	// 출하요청
	@RequestMapping("/RequstConsignment")
	public String RequstConsignment() {
		return "consignmentmanagement/requstconsignment";
	}

}
