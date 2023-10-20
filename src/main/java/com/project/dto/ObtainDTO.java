package com.project.dto;

import org.apache.ibatis.type.Alias;

@Alias("sell")
public class ObtainDTO {
	// sell
	private String sNum;
	private String sPhase;
	private int sAmount;
	private String cNum;
	private int price;
	private String pNum;
	private String dateOrder;
	private String dateStartShip;
	private String dateToArrive;
	private String barcode;
	// company_sell
	private String sName;
	private String address;
	private String cLeader;
	private String cTel;
	private String cPhone;
	private String cFax;
	private String cMail;
	// product
	private String pAmount;
	private String pName;
	private String pSize;
	private int boxCount;
	private String pWeight;
	private String pWeight_1;
	private String unit;
	private String pFinish;
	private int pPrice;
	private String recipeNum;
	//manager
	private String mName;
	private String mContact;
	private String mMail;

	public ObtainDTO() {
	}

	public ObtainDTO(String sNum, String sPhase, int sAmount, String cNum, int price, String pNum, String dateOrder,
			String dateStartShip, String dateToArrive, String barcode, String sName, String address, String cLeader,
			String cTel, String cPhone, String cFax, String cMail, String pAmount, String pName, String pSize,
			int boxCount, String pWeight, String pWeight_1, String unit, String pFinish, int pPrice, String recipeNum,
			String mName, String mContact, String mMail) {
		super();
		this.sNum = sNum;
		this.sPhase = sPhase;
		this.sAmount = sAmount;
		this.cNum = cNum;
		this.price = price;
		this.pNum = pNum;
		this.dateOrder = dateOrder;
		this.dateStartShip = dateStartShip;
		this.dateToArrive = dateToArrive;
		this.barcode = barcode;
		this.sName = sName;
		this.address = address;
		this.cLeader = cLeader;
		this.cTel = cTel;
		this.cPhone = cPhone;
		this.cFax = cFax;
		this.cMail = cMail;
		this.pAmount = pAmount;
		this.pName = pName;
		this.pSize = pSize;
		this.boxCount = boxCount;
		this.pWeight = pWeight;
		this.pWeight_1 = pWeight_1;
		this.unit = unit;
		this.pFinish = pFinish;
		this.pPrice = pPrice;
		this.recipeNum = recipeNum;
		this.mName = mName;
		this.mContact = mContact;
		this.mMail = mMail;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsPhase() {
		return sPhase;
	}

	public void setsPhase(String sPhase) {
		this.sPhase = sPhase;
	}

	public int getsAmount() {
		return sAmount;
	}

	public void setsAmount(int sAmount) {
		this.sAmount = sAmount;
	}

	public String getcNum() {
		return cNum;
	}

	public void setcNum(String cNum) {
		this.cNum = cNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public String getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(String dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getDateStartShip() {
		return dateStartShip;
	}

	public void setDateStartShip(String dateStartShip) {
		this.dateStartShip = dateStartShip;
	}

	public String getDateToArrive() {
		return dateToArrive;
	}

	public void setDateToArrive(String dateToArrive) {
		this.dateToArrive = dateToArrive;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getcLeader() {
		return cLeader;
	}

	public void setcLeader(String cLeader) {
		this.cLeader = cLeader;
	}

	public String getcTel() {
		return cTel;
	}

	public void setcTel(String cTel) {
		this.cTel = cTel;
	}

	public String getcPhone() {
		return cPhone;
	}

	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	public String getcFax() {
		return cFax;
	}

	public void setcFax(String cFax) {
		this.cFax = cFax;
	}

	public String getcMail() {
		return cMail;
	}

	public void setcMail(String cMail) {
		this.cMail = cMail;
	}

	public String getpAmount() {
		return pAmount;
	}

	public void setpAmount(String pAmount) {
		this.pAmount = pAmount;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public int getBoxCount() {
		return boxCount;
	}

	public void setBoxCount(int boxCount) {
		this.boxCount = boxCount;
	}

	public String getpWeight() {
		return pWeight;
	}

	public void setpWeight(String pWeight) {
		this.pWeight = pWeight;
	}

	public String getpWeight_1() {
		return pWeight_1;
	}

	public void setpWeight_1(String pWeight_1) {
		this.pWeight_1 = pWeight_1;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getpFinish() {
		return pFinish;
	}

	public void setpFinish(String pFinish) {
		this.pFinish = pFinish;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	public String getRecipeNum() {
		return recipeNum;
	}

	public void setRecipeNum(String recipeNum) {
		this.recipeNum = recipeNum;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmContact() {
		return mContact;
	}

	public void setmContact(String mContact) {
		this.mContact = mContact;
	}

	public String getmMail() {
		return mMail;
	}

	public void setmMail(String mMail) {
		this.mMail = mMail;
	}

	@Override
	public String toString() {
		return "ObtainDTO [sNum=" + sNum + ", sPhase=" + sPhase + ", sAmount=" + sAmount + ", cNum=" + cNum + ", price="
				+ price + ", pNum=" + pNum + ", dateOrder=" + dateOrder + ", dateStartShip=" + dateStartShip
				+ ", dateToArrive=" + dateToArrive + ", barcode=" + barcode + ", sName=" + sName + ", address="
				+ address + ", cLeader=" + cLeader + ", cTel=" + cTel + ", cPhone=" + cPhone + ", cFax=" + cFax
				+ ", cMail=" + cMail + ", pAmount=" + pAmount + ", pName=" + pName + ", pSize=" + pSize + ", boxCount="
				+ boxCount + ", pWeight=" + pWeight + ", pWeight_1=" + pWeight_1 + ", unit=" + unit + ", pFinish="
				+ pFinish + ", pPrice=" + pPrice + ", recipeNum=" + recipeNum + ", mName=" + mName + ", mContact="
				+ mContact + ", mMail=" + mMail + "]";
	}

	
	
}