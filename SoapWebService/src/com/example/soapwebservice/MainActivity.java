package com.example.soapwebservice;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	public static final String SERVICE_URL = "http://1.1.0.20/mposdd/ws_mpos.asmx";
	
	private TextView mTvResult;
	private ProgressDialog mProgress;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTvResult = (TextView) findViewById(R.id.textView1);
    }

    public void onGetDataClicked(final View v){
    	mProgress = new ProgressDialog(this);
    	mProgress.setCancelable(false);
    	new LoadShopMaster(this, mLoadShopMasterListener).execute(SERVICE_URL);
    }
    
    private LoadShopMaster.LoadShopMasterListener mLoadShopMasterListener = 
    		new LoadShopMaster.LoadShopMasterListener() {
				
				@Override
				public void onPreExecute() {
					mProgress.show();
				}
				
				@Override
				public void onPostExecute() {
				}
				
				@Override
				public void onError(String msg) {
					if(mProgress.isShowing())
						mProgress.dismiss();
					try {
						Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				@Override
				public void onPostExecute(ShopMasterData master) {
					if(mProgress.isShowing())
						mProgress.dismiss();
					for(ShopMasterData.Company company : master.getCompanyProfile()){
						mTvResult.append("CompanyID: " + company.getCompanyID() + "\n");
						mTvResult.append("CompanyName: " + company.getCompanyName() + "\n");
						mTvResult.append("CompanyAddr: " + company.getCompanyAddress1() + "\n");
					}
				}
	};
}
