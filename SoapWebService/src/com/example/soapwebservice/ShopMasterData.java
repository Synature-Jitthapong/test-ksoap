package com.example.soapwebservice;

import java.util.ArrayList;
import java.util.List;

public class ShopMasterData {
	// {CompanyProfile[{},{},{}...],...}
	private List<Company> CompanyProfile = new ArrayList<Company>();
	
	public List<Company> getCompanyProfile() {
		return CompanyProfile;
	}

	public static class Company{
		private int CompanyID;
		private String CompanyName;
		private String CompanyAddress1;
		public int getCompanyID() {
			return CompanyID;
		}
		public void setCompanyID(int companyID) {
			CompanyID = companyID;
		}
		public String getCompanyName() {
			return CompanyName;
		}
		public void setCompanyName(String companyName) {
			CompanyName = companyName;
		}
		public String getCompanyAddress1() {
			return CompanyAddress1;
		}
		public void setCompanyAddress1(String companyAddress1) {
			CompanyAddress1 = companyAddress1;
		}
	}
}
