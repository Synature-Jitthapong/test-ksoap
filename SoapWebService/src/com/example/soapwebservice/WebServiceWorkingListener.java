package com.example.soapwebservice;

public interface WebServiceWorkingListener {
	void onPreExecute();
	void onPostExecute();
	void onError(String msg);
}
