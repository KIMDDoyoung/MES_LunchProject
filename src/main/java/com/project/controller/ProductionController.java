package com.project.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.ProductionDTO;
import com.project.service.ProductionService;

@Controller
public class ProductionController {
	
		private ProductionService productionService;
				
	public ProductionController(ProductionService productionService) {
			this.productionService = productionService;
		}
	
	@RequestMapping("/PM")
	public ModelAndView ProductionMain(ModelAndView view) {
		List<ProductionDTO> select_list = productionService.selectAll();
		
		view.setViewName("/production/ProductionMain");
		view.addObject("select_list",select_list);
		
		return view;
	}
	@RequestMapping("/pm/search.do")
	public ResponseEntity<String> selectProduction(String search){
		List<ProductionDTO> list = productionService.selectProduction(search);
		return new ResponseEntity(list,HttpStatus.OK);
	}
	@RequestMapping("/date/search.do")
	public ResponseEntity<String> selectDate(String startDate,String endDate){
		List<ProductionDTO> list = productionService.selectDate(startDate,endDate);		
		System.out.println(list);
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	//1. ProductionRegister로 이동하는 메서드 작성
	@RequestMapping("/PMRegister")
	public String registerView() {
		return "/production/ProductionRegister";
	}
	//2. 등록할 정보를 받아서 DB에 등록하는 메서드 작성
	@RequestMapping("/production/register/action")
	public String register(@ModelAttribute ProductionDTO productionDTO, @RequestParam("phase") String phaseValue) {
		
		productionDTO.setPhase(phaseValue);
		System.out.println(phaseValue);
		 // UUID 생성
        UUID productionNumUUID = UUID.randomUUID();
        String productionNum = productionNumUUID.toString(); // UUID를 문자열로 변환
        productionDTO.setProductionNum(productionNum);
        System.out.println(productionNum);
        
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 형식에 맞게 변경
	
		    try {
		        Date dateRegister = dateFormat.parse(productionDTO.getDateRegister());
		        Date dateFinish = dateFormat.parse(productionDTO.getDateFinish());
		        System.out.println(dateRegister);
		        System.out.println(dateFinish);
		        productionDTO.setDateRegister(dateFormat.format(dateRegister)); // 문자열을 다시 설정
		        productionDTO.setDateFinish(dateFormat.format(dateFinish)); // 문자열을 다시 설정
		        

		        // DB에 전달과정
		        productionService.register(productionDTO);

		    } catch (ParseException e) {
		        e.printStackTrace();
		        // 날짜 파싱에 실패한 경우 예외 처리
		       
		    }
	
	   
	    return "redirect:/PM";
	}
	
	@RequestMapping("/pm/delete")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> delete(@RequestBody List<String> pNums) {
	    System.out.println(pNums);
	    int result = productionService.deleteProduction(pNums);
	    Map<String, Object> response = new HashMap<>();
	    response.put("count", result);
	    if (result == 0) {
	        response.put("message", "데이터 삭제 실패");
	    } else {
	        response.put("message", "데이터 삭제 성공");
	    }

	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	//1. ProductionModify로 이동하는 메서드 작성
	@RequestMapping("/PMModify")
	public String modifyView() {
			return "/production/ProductionModify";
	}
		//2. 등록할 정보를 받아서 DB에 등록하는 메서드 작성
	@RequestMapping("/production/modify")
	public String ProductionModify(ProductionDTO productionDTO,@RequestParam("phase") String phaseValue) {
		productionDTO.setPhase(phaseValue);
		System.out.println(phaseValue);
		 // UUID 생성
        UUID productionNumUUID = UUID.randomUUID();
        String productionNum = productionNumUUID.toString(); // UUID를 문자열로 변환
        productionDTO.setProductionNum(productionNum);
        System.out.println(productionNum);
        
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 형식에 맞게 변경
	
		    try {
		        Date dateRegister = dateFormat.parse(productionDTO.getDateRegister());
		        Date dateFinish = dateFormat.parse(productionDTO.getDateFinish());
		        System.out.println(dateRegister);
		        System.out.println(dateFinish);
		        productionDTO.setDateRegister(dateFormat.format(dateRegister)); // 문자열을 다시 설정
		        productionDTO.setDateFinish(dateFormat.format(dateFinish)); // 문자열을 다시 설정
		        

		        // DB에 전달과정
		        productionService.ProductionModify(productionDTO);

		    } catch (ParseException e) {
		        e.printStackTrace();
		        // 날짜 파싱에 실패한 경우 예외 처리
		       
		    }
		return "redirect:/PM";
		
	}
	
	
}

