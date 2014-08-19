package com.example.soapwebservice;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import android.content.Context;
import android.text.TextUtils;

public class LoadShopMaster extends MyWebService{

	private LoadShopMasterListener mListener;
	
	public LoadShopMaster(Context c, LoadShopMasterListener listener) {
		super(c, METHOD_LOAD_SHOP_MASTER);
		mListener = listener;
	}

	
	@Override
	protected void onPreExecute() {
		mListener.onPreExecute();
	}

	@Override
	protected void onPostExecute(String json) {
		if(!TextUtils.isEmpty(json)){
			try {
				Gson gson = new Gson();
				ShopMasterData master = (ShopMasterData) gson.fromJson(json, ShopMasterData.class);
				mListener.onPostExecute(master);
			} catch (JsonSyntaxException e) {
				mListener.onError(json);
			}
		}
	}

	public static interface LoadShopMasterListener extends WebServiceWorkingListener{
		void onPostExecute(ShopMasterData master);
	}
}
