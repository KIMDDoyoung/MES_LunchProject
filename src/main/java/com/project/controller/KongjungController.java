package com.project.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.KongjungDTO;
import com.project.dto.OrderDTO;
import com.project.dto.Stock_MaterialDTO;
import com.project.service.KongjungService;

@Controller
public class KongjungController {
	
	private KongjungService kongjungService;
				
	public KongjungController(KongjungService kongjungService) {
			this.kongjungService = kongjungService;
		}
	@RequestMapping("/kongjung_info")     
	public ModelAndView allList(KongjungDTO kongjungDTO , ModelAndView view)  {
		List<KongjungDTO> List = kongjungService.selectAllList(kongjungDTO);    //  임시 KongjungService의 seletAllList List로 담음
		view.addObject("kongjungList",List);	
		view.setViewName("kongjung/kongjung_info");
		
	return view;                      
	}
	@RequestMapping("/search.do")
	public ResponseEntity<String> selectSearch(String search){
		List<KongjungDTO> list = kongjungService.selectSearch(search);
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	@RequestMapping("/kongjung_info/delete/{processNum}")
	public ResponseEntity<String> deletekongjung(@PathVariable("processNum") String processNum) {
		System.out.println("1:" + processNum);
		kongjungService.deletekongjung(processNum);
		System.out.println("2:" + processNum);

		return new ResponseEntity("선택항목을 삭제했습니다.", HttpStatus.OK);
	}

	
	@RequestMapping("/kongjung_insert")
	public String KongjungTest1() {
		return "/kongjung/kongjung_insert";
	}
	
	// 공정 정보 form
	@RequestMapping("/kongjung_insert/action")
	public String KongjungInsert(@ModelAttribute KongjungDTO dto) {
	    try {
	    	kongjungService.KongjungInsert(dto);
	        return "redirect:/kongjung_insert"; // 등록 후 해당 페이지로 이동
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "/kongjung/kongjung_insert"; // 실패 시 등록 페이지로 유지
	    }
	}
	
	@RequestMapping("/kongjung/kongupdate/{p_num}")
		public ModelAndView UpdateKongjungView(@PathVariable("p_num") String p_num, ModelAndView view) {
		KongjungDTO dto = kongjungService.editKongjung(p_num);
			view.addObject("kongupdate", dto);
			view.setViewName("kongjung/kongjung_update");
			System.out.println(dto.toString());
			return view;
	}
	
	@RequestMapping("/kongjung/recipeupdate/{r_num}")
	public ModelAndView UpdateRecipeView(@PathVariable("r_num") String r_num, ModelAndView view) {
	KongjungDTO dto = kongjungService.editRecipe(r_num);
		view.addObject("recipeupdate", dto);
		view.setViewName("kongjung/recipe_update");
		System.out.println(dto.toString());
		return view;
}
	
	@PostMapping("/kongjung_update/action")
	public String updateKongjungAction(@ModelAttribute KongjungDTO dto) {
	    try {
	 //       kongjungService.updateKongjung(dto);
	        return "redirect:/kongjung_info"; // 업데이트 후 공정 정보 페이지로 이동
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "/kongjung/kongjung_update"; // 실패 시 업데이트 페이지로 유지
	    }
	}
	
	// 공정정보 수정하기
		@RequestMapping("/kongjung_update")
		public String updateKongjung(@ModelAttribute KongjungDTO dto) {
			try {
				kongjungService.updateKongjung(dto);
				System.out.println(dto);
				return "redirect:/kongjung_info";

			} catch (Exception e) {
				e.printStackTrace();
				return "kongjung_update"; // 실패 시 수정 페이지로 유지
			}

		}

	
	@RequestMapping("/recipe_info")     
	public ModelAndView allList1(KongjungDTO kongjungDTO , ModelAndView view)  {
		List<KongjungDTO> List = kongjungService.selectAllList1(kongjungDTO);    //  임시 KongjungService의 seletAllList List로 담음
		view.addObject("recipeList",List);	
		view.setViewName("kongjung/recipe_info");
		
	return view;                      
	}
	
	
	@RequestMapping("/recipe_info/delete/{recipeNum}")
	public ResponseEntity<String> deletekongjung1(@PathVariable("recipeNum") String recipeNum) {
		System.out.println("1:" + recipeNum);
		kongjungService.deletekongjung(recipeNum);
		System.out.println("2:" + recipeNum);

		return new ResponseEntity("선택항목을 삭제했습니다.", HttpStatus.OK);
	}
	
	@RequestMapping("/search1.do")
	public ResponseEntity<String> selectSearch1(String search){
		List<KongjungDTO> list = kongjungService.selectSearch1(search);
		return new ResponseEntity(list,HttpStatus.OK);
	}
	@RequestMapping("/recipe_insert")
	public String RecipeTest1() { 
		return "/kongjung/recipe_insert";
	}
	@RequestMapping("/recipe_update")
	public String RecipeTest2() {
		return "/kongjung/recipe_update";
	}

}