package com.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.dto.Stock_MaterialDTO;
import com.project.dto.Stock_ProductDTO;
import com.project.service.StockService;

@Controller
public class StockController {

	private StockService service;

	public StockController(StockService service) {
		this.service = service;
	}

	@RequestMapping("/stock/material")
	public ModelAndView ViewAllMaterial(ModelAndView view) {
		List<Stock_MaterialDTO> list = service.selectAllMaterial();
		int count = service.countAllMaterial();
		view.addObject("count", count);
		view.addObject("list", list);
		view.setViewName("stock/stock_material");
		return view;
	}

	@RequestMapping("/stock/product")
	public ModelAndView ViewAllProduct(ModelAndView view) {
		List<Stock_ProductDTO> list = service.selectAllProduct();
		int count = service.countAllProduct();
		view.addObject("count", count);
		view.addObject("list", list);
		view.setViewName("stock/stock_product");
		return view;
	}

	@RequestMapping("/stock/material/add")
	public String ViewAddMaterial() {
		return "stock/stock_add_material";
	}

	@RequestMapping("/stock/material/addMaterial")
	public String AddMaterial(ModelAndView view, HttpServletRequest request) {
		String mNum = request.getParameter("m_num");
		String mName = request.getParameter("m_name");
		int mQuantity = Integer.parseInt(request.getParameter("m_quantity"));
		int mBoxQuantity = Integer.parseInt(request.getParameter("m_box_quantity"));
		String mUnit = request.getParameter("m_unit");
		Stock_MaterialDTO dto = new Stock_MaterialDTO(mNum, mName, mQuantity, mBoxQuantity, mUnit, null);
		int result = service.InsertMaterial(dto);
		return "redirect:/stock/material";
	}

	@RequestMapping("/stock/product/add")
	public String ViewAddProduct() {
		return "stock/stock_add_product";
	}

	@RequestMapping("/stock/product/addProduct")
	public String AddProduct(ModelAndView view, HttpServletRequest request) {
		String pNum = request.getParameter("p_num");
		String pName = request.getParameter("p_name");
		int pQuantity = Integer.parseInt(request.getParameter("p_quantity"));
		String recipeNum = request.getParameter("recipe_num");
		Stock_ProductDTO dto = new Stock_ProductDTO(pNum, pName, pQuantity, recipeNum);
		int result = service.InsertProduct(dto);
		return "redirect:/stock/product";
	}

	@RequestMapping("/stock/material/updateView/{m_num}")
	public ModelAndView UpdateMaterialView(@PathVariable("m_num") String m_num, ModelAndView view) {
		Stock_MaterialDTO dto = service.SelectMaterial(m_num);
		view.addObject("material", dto);
		view.setViewName("stock/stock_update_material");
		return view;
	}

	@RequestMapping("/stock/material/update")
	public String UpdateMaterial(ModelAndView view, HttpServletRequest request) {
		String mNum = request.getParameter("m_num");
		String mName = request.getParameter("m_name");
		int mQuantity = Integer.parseInt(request.getParameter("m_quantity"));
		int mBoxQuantity = Integer.parseInt(request.getParameter("m_box_quantity"));
		String mUnit = request.getParameter("m_unit");
		Stock_MaterialDTO dto = new Stock_MaterialDTO(mNum, mName, mQuantity, mBoxQuantity, mUnit, null);
		System.out.println(dto.toString());
		int result = service.UpdateMaterial(dto);
		return "redirect:/stock/material";
	}

	@RequestMapping("/stock/product/updateView/{p_num}")
	public ModelAndView UpdateProductView(@PathVariable("p_num") String p_num, ModelAndView view) {
		Stock_ProductDTO dto = service.SelectProduct(p_num);
		view.addObject("product", dto);
		view.setViewName("stock/stock_update_product");
		return view;
	}

	@RequestMapping("/stock/product/update")
	public String UpdateProduct(ModelAndView view, HttpServletRequest request) {
		String pNum = request.getParameter("p_num");
		String pName = request.getParameter("p_name");
		int pQuantity = Integer.parseInt(request.getParameter("p_quantity"));
		String recipeNum = request.getParameter("recipe_num");
		Stock_ProductDTO dto = new Stock_ProductDTO(pNum, pName, pQuantity, recipeNum);
		int result = service.UpdateProduct(dto);
		return "redirect:/stock/product";
	}

	@RequestMapping("/stock/material/search")
	public ResponseEntity<List<Stock_MaterialDTO>> SearchMaterial(@RequestParam("search") String search) {
		List<Stock_MaterialDTO> list;

		list = service.SearchMaterial(search);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping("/stock/product/search")
	public ResponseEntity<List<Stock_ProductDTO>> SearchProduct(@RequestParam("search") String search) {
		List<Stock_ProductDTO> list;

		list = service.SearchProduct(search);

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@RequestMapping("/stock/material/delete/{mNum}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> DeleteMaterial(@PathVariable("mNum") String mNum) {

		int result = service.DeleteMaterial(mNum);


	    Map<String, String> response = new HashMap<>();
	    response.put("message", "삭제되었습니다.");

	    return ResponseEntity.ok(response);

	}
	@RequestMapping("/stock/product/delete/{pNum}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> DeleteProduct(@PathVariable("pNum") String pNum) {
		
		int result = service.DeleteProduct(pNum);
		
		
		Map<String, String> response = new HashMap<>();
		response.put("message", "삭제되었습니다.");
		
		return ResponseEntity.ok(response);
		
	}
	/*********************************************************************************
	 APP
	 *********************************************************************************/
	
	@RequestMapping("/app/stock/material")
	public ModelAndView ViewAllMaterialApp(ModelAndView view) {
		List<Stock_MaterialDTO> list = service.selectAllMaterial();
		int count = service.countAllMaterial();
		view.addObject("count", count);
		view.addObject("list", list);
		view.setViewName("stock/stock_material_app");
		return view;
	}
	
	@RequestMapping("/app/stock/product")
	public ModelAndView ViewAllProductApp(ModelAndView view) {
		List<Stock_ProductDTO> list = service.selectAllProduct();
		int count = service.countAllProduct();
		view.addObject("count", count);
		view.addObject("list", list);
		view.setViewName("stock/stock_product_app");
		return view;
	}

	
	
}
