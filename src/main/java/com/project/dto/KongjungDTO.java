package com.project.dto;

import org.apache.ibatis.type.Alias;

@Alias("process")
public class KongjungDTO {
   
	 /* 공정관리 */
	   private String processNum;
	   private String processName;
	   private String recipeNum;
	   private int processTime;
	   private String process1;
	   private String process2;
	   private String process3;
	   private String process4;
	   private String process5;
	   private String process6;
	   private String materialNo;
	   
	   
	public KongjungDTO() {
	}


	public KongjungDTO(String processNum, String processName, String recipeNum, int processTime, String process1,
			String process2, String process3, String process4, String process5, String process6, String materialNo) {
		super();
		this.processNum = processNum;
		this.processName = processName;
		this.recipeNum = recipeNum;
		this.processTime = processTime;
		this.process1 = process1;
		this.process2 = process2;
		this.process3 = process3;
		this.process4 = process4;
		this.process5 = process5;
		this.process6 = process6;
		this.materialNo = materialNo;
	}


	public String getProcessNum() {
		return processNum;
	}


	public void setProcessNum(String processNum) {
		this.processNum = processNum;
	}


	public String getProcessName() {
		return processName;
	}


	public void setProcessName(String processName) {
		this.processName = processName;
	}


	public String getRecipeNum() {
		return recipeNum;
	}


	public void setRecipeNum(String recipeNum) {
		this.recipeNum = recipeNum;
	}


	public int getProcessTime() {
		return processTime;
	}


	public void setProcessTime(int processTime) {
		this.processTime = processTime;
	}


	public String getProcess1() {
		return process1;
	}


	public void setProcess1(String process1) {
		this.process1 = process1;
	}


	public String getProcess2() {
		return process2;
	}


	public void setProcess2(String process2) {
		this.process2 = process2;
	}


	public String getProcess3() {
		return process3;
	}


	public void setProcess3(String process3) {
		this.process3 = process3;
	}


	public String getProcess4() {
		return process4;
	}


	public void setProcess4(String process4) {
		this.process4 = process4;
	}


	public String getProcess5() {
		return process5;
	}


	public void setProcess5(String process5) {
		this.process5 = process5;
	}


	public String getProcess6() {
		return process6;
	}


	public void setProcess6(String process6) {
		this.process6 = process6;
	}


	public String getMaterialNo() {
		return materialNo;
	}


	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}


	@Override
	public String toString() {
		return "KongjungDTO [processNum=" + processNum + ", processName=" + processName + ", recipeNum=" + recipeNum
				+ ", processTime=" + processTime + ", process1=" + process1 + ", process2=" + process2 + ", process3="
				+ process3 + ", process4=" + process4 + ", process5=" + process5 + ", process6=" + process6
				+ ", materialNo=" + materialNo + "]";
	}
	
	

	   
	   
	
	
	   
	
	} 