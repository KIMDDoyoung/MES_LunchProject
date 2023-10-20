package com.project.dto;

import org.apache.ibatis.type.Alias;
@Alias("production")
public class ProductionDTO {
	private String pNum;
	private String productionNum;
	private String productName;
	private String cNum;
	private String dateRegister;
	private String dateFinish;
	private	int amount;
	private	int price;
	private String boxCount;
	private String phase;
	private String recipe_num;
	
	public ProductionDTO() {
	}

	public ProductionDTO(String pNum, String productionNum, String productName, String cNum, String dateRegister,
			String dateFinish, int amount, int price, String boxCount, String phase, String recipe_num) {
		super();
		this.pNum = pNum;
		this.productionNum = productionNum;
		this.productName = productName;
		this.cNum = cNum;
		this.dateRegister = dateRegister;
		this.dateFinish = dateFinish;
		this.amount = amount;
		this.price = price;
		this.boxCount = boxCount;
		this.phase = phase;
		this.recipe_num = recipe_num;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getProductionNum() {
		return productionNum;
	}

	public void setProductionNum(String productionNum) {
		this.productionNum = productionNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getcNum() {
		return cNum;
	}

	public void setcNum(String cNum) {
		this.cNum = cNum;
	}

	public String getDateRegister() {
		return dateRegister;
	}

	public void setDateRegister(String dateRegister) {
		this.dateRegister = dateRegister;
	}

	public String getDateFinish() {
		return dateFinish;
	}

	public void setDateFinish(String dateFinish) {
		this.dateFinish = dateFinish;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getBoxCount() {
		return boxCount;
	}

	public void setBoxCount(String boxCount) {
		this.boxCount = boxCount;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getRecipe_num() {
		return recipe_num;
	}

	public void setRecipe_num(String recipe_num) {
		this.recipe_num = recipe_num;
	}

	@Override
	public String toString() {
		return "ProductionDTO [pNum=" + pNum + ", productionNum=" + productionNum + ", productName=" + productName
				+ ", cNum=" + cNum + ", dateRegister=" + dateRegister + ", dateFinish=" + dateFinish + ", amount="
				+ amount + ", price=" + price + ", boxCount=" + boxCount + ", phase=" + phase + ", recipe_num="
				+ recipe_num + "]";
	}


		
}