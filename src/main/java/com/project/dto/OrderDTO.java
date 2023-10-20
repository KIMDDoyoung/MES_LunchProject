package com.project.dto;

import org.apache.ibatis.type.Alias;
import java.util.UUID;

@Alias("buy")
public class OrderDTO {
	
	//발주 buy 테이블
	 private String buyNo;
	 private String dateOrder;
	 private String dateReceived;
	 private String materioalAmount;
	 private int mTotalPrice;

	//협력업체 company_buy 테이블
	 private String buyName;
	 private String companyNo;

	 //원부재료 material 테이블
	 private String materioalName;
	 private String materialNo;
	 private int mBOXcount;
	 private String mUnit;

	 //manager 테이블
	 private String managerName;
	 private String managerContact;
	 private String mMail;
	 
	 public OrderDTO() {
		super();
	 }
	




	public OrderDTO(String buyNo, String dateOrder, String dateReceived, String materioalAmount, int mTotalPrice,
			String buyName, String companyNo, String materioalName, String materialNo, int mBOXcount, String mUnit,
			String managerName, String managerContact, String mMail) {
		super();
		this.buyNo = buyNo;
		this.dateOrder = dateOrder;
		this.dateReceived = dateReceived;
		this.materioalAmount = materioalAmount;
		this.mTotalPrice = mTotalPrice;
		this.buyName = buyName;
		this.companyNo = companyNo;
		this.materioalName = materioalName;
		this.materialNo = materialNo;
		this.mBOXcount = mBOXcount;
		this.mUnit = mUnit;
		this.managerName = managerName;
		this.managerContact = managerContact;
		this.mMail = mMail;
	}



	public String getManagerName() {
		return managerName;
	}



	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}


	public String getManagerContact() {
		return managerContact;
	}



	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}



	public String getmMail() {
		return mMail;
	}



	public void setmMail(String mMail) {
		this.mMail = mMail;
	}



	public int getmTotalPrice() {
		return mTotalPrice;
	}


	public void setmTotalPrice(int mTotalPrice) {
		this.mTotalPrice = mTotalPrice;
	}


	public int getmBOXcount() {
		return mBOXcount;
	}



	public void setmBOXcount(int mBOXcount) {
		this.mBOXcount = mBOXcount;
	}


	public String getmUnit() {
		return mUnit;
	}


	public void setmUnit(String mUnit) {
		this.mUnit = mUnit;
	}


	public String getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(String buyNo) {
		this.buyNo = buyNo;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getDateReceived() {
		return dateReceived;
	}

	public void setDateReceived(String dateReceived) {
		this.dateReceived = dateReceived;
	}

	public String getMaterioalAmount() {
		return materioalAmount;
	}

	public void setMaterioalAmount(String materioalAmount) {
		this.materioalAmount = materioalAmount;
	}

	public String getBuyName() {
		return buyName;
	}

	public void setBuyName(String buyName) {
		this.buyName = buyName;
	}

	public String getCompanyNo() {
		return companyNo;
	}

	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}

	public String getMaterioalName() {
		return materioalName;
	}

	public void setMaterioalName(String materioalName) {
		this.materioalName = materioalName;
	}

	public String getMaterialNo() {
		return materialNo;
	}

	public void setMaterialNo(String materialNo) {
		this.materialNo = materialNo;
	}



	@Override
	public String toString() {
		return "OrderDTO [buyNo=" + buyNo + ", dateOrder=" + dateOrder + ", dateReceived=" + dateReceived
				+ ", materioalAmount=" + materioalAmount + ", mTotalPrice=" + mTotalPrice + ", buyName=" + buyName
				+ ", companyNo=" + companyNo + ", materioalName=" + materioalName + ", materialNo=" + materialNo
				+ ", mBOXcount=" + mBOXcount + ", mUnit=" + mUnit + ", managerName=" + managerName + ", managerContact="
				+ managerContact + ", mMail=" + mMail + "]";
	}





	 
}

