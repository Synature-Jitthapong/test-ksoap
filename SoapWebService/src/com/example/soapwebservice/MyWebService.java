package com.example.soapwebservice;

import com.example.ksoap2webservicelibs.Ksoap2WebServiceBase;

import android.content.Context;

public abstract class MyWebService extends Ksoap2WebServiceBase{

	public static final String NAME_SPACE = "http://tempuri.org/";
	public static final String METHOD_LOAD_SHOP_MASTER = "WSmPOS_JSON_LoadShopMasterData";
	
	public static final int TIME_OUT = 10 * 1000; // 30ms.
	
	public MyWebService(Context c, String method) {
		super(c, NAME_SPACE, method, TIME_OUT);
	}

}
