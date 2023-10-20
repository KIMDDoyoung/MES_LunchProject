package com.project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.dto.KongjungDTO;
import com.project.dto.OrderDTO;

@Mapper		// Mapper라고 선언함
public interface KongjungMapper {
	// 여기서 지정한 메서드의 이름은 쿼리의 이름과 동일해야 함 (selectBoardList)
	
	
		

		List<KongjungDTO> selectAllList(KongjungDTO kongjungDTO);
		
		List<KongjungDTO> selectAllList1(KongjungDTO kongjungDTO);

		List<KongjungDTO> selectSearch(Map<String, Object> map);

		List<KongjungDTO> selectSearch1(String search);

		void deletekongjung(String processNum);

		void KongjungInsert(String processNum, String processName, String materialNo);


		KongjungDTO editKongjung(String p_num);

		void updateKongjung(String processNum, String processName, String materialNo);

		void deletekongjung1(String recipeNum);
		
		void updateRecipe(String recipeNum, int processTime, String process1, String process2, String process3,
				String process4, String process5, String process6);


		KongjungDTO editRecipe(String r_num);




}
