package com.project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.dto.KongjungDTO;
import com.project.dto.OrderDTO;
import com.project.mapper.KongjungMapper;



@Service
public class KongjungService {
	  	private KongjungMapper mapper;
	  		
	public KongjungService(KongjungMapper mapper) {
			this.mapper = mapper;
		}


	public List<KongjungDTO> selectAllList(KongjungDTO kongjungDTO) {
		return mapper.selectAllList(kongjungDTO);
	}
	
	public List<KongjungDTO> selectSearch(String search) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search", search);
		return mapper.selectSearch(map);
	}
	
	public List<KongjungDTO> selectAllList1 (KongjungDTO kongjungDTO) {
		return mapper.selectAllList1(kongjungDTO);
	}
	
	public List<KongjungDTO> selectSearch1(String search) {
		
		return mapper.selectSearch1(search);
	}
	
	public void deletekongjung(String processNum) {
		mapper.deletekongjung(processNum);

}
	
	public void deletekongjung1(String recipeNum) {
		mapper.deletekongjung1(recipeNum);

}


	
	//공정정보 등록
			public void KongjungInsert(KongjungDTO dto) {
				 try {
			            // KongjungDTO에서 데이터 추출
					 	String processNum = dto.getProcessNum();
			            String processName = dto.getProcessName();
			            String materialNo = dto.getMaterialNo();

			            mapper.KongjungInsert(processNum, processName, materialNo);
			       

			        } catch (Exception e) {
			            throw new RuntimeException("데이터 삽입 중 오류 발생", e);
			        }
			  }


			public KongjungDTO editKongjung(String p_num) {
				return mapper.editKongjung(p_num);
			}
			
			public KongjungDTO editRecipe(String r_num) {
				return mapper.editRecipe(r_num);
			}

			public void updateRecipe(KongjungDTO dto) {
				try {
					String processNum = dto.getProcessNum();
		            int processTime = dto.getProcessTime();
		            String process1 = dto.getProcess1();
		            String process2 = dto.getProcess2();
		            String process3 = dto.getProcess3();
		            String process4 = dto.getProcess4();
		            String process5 = dto.getProcess5();
		            String process6 = dto.getProcess6();
		            
		            mapper.updateRecipe(processNum, processTime, process1, process2, process3, process4, process5, process6);
				}
				catch (Exception e) {
		            throw new RuntimeException("데이터 삽입 중 오류 발생", e);
		        }
			}

			public void updateKongjung(KongjungDTO dto) {
				try {
					String processNum = dto.getProcessNum();
		            String processName = dto.getProcessName();
		            String materialNo = dto.getMaterialNo();
		            
		            mapper.updateKongjung(processNum, processName, materialNo);
				}
				catch (Exception e) {
		            throw new RuntimeException("데이터 삽입 중 오류 발생", e);
		        }
			}


			

	

}