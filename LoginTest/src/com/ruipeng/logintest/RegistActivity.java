package com.ruipeng.logintest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends ActionBarActivity {
	EditText rg_name,rg_password,rg_password2;
	Button regist ;
	

	Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x123:
				Toast.makeText(RegistActivity.this, "注册成功！", Toast.LENGTH_SHORT)
						.show();
				finish();
				break;
			case 0x124:
				Toast.makeText(RegistActivity.this, "用户名已经存在！",
						Toast.LENGTH_SHORT).show();
				break;
			case 0x125:
				Toast.makeText(RegistActivity.this, "注册失败！！", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist);
		init();
	}

	private void init() {
		rg_name = (EditText)findViewById(R.id.rg_name);
		rg_password = (EditText)findViewById(R.id.rg_password);
		rg_password2 = (EditText)findViewById(R.id.rg_password2);
		regist = (Button)findViewById(R.id.regist);
		
		regist.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String name = rg_name.getText().toString();
				String passw = rg_password.getText().toString();
				String passw2 = rg_password2.getText().toString();
				if((!name.equals(""))&&name!=null&&(!passw.equals(""))&&passw!=null&&(!passw2.equals(""))&&passw2!=null){
					if(passw.equals(passw2)){
						new registThread().start();
					}else{
						Toast.makeText(RegistActivity.this, "两次密码不一致！",Toast.LENGTH_SHORT).show();
					}
				}else{
					Toast.makeText(RegistActivity.this, "不能为空！！",Toast.LENGTH_SHORT).show();
				}
			}
		});
	}

	public class registThread extends Thread{
		String Url = "http://10.0.2.2:8080/StudentInfo/RegistServlet";
		@Override
		public void run() {
			HttpParams httpParameters = new BasicHttpParams();
			// 设置链接超时
			HttpConnectionParams.setConnectionTimeout(httpParameters, 3000);
			// 设置Socket每一秒传输数据超时
			HttpConnectionParams.setSoTimeout(httpParameters, 5000);
			// 构建HttpClient的实例
			HttpClient httpClient = new DefaultHttpClient(httpParameters);
			// 创建POST方法的实例
			HttpPost httpPost = new HttpPost(Url);
			List<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
			BasicNameValuePair bnvp = new BasicNameValuePair("name",rg_name.getText().toString());
			BasicNameValuePair bnvp2 = new BasicNameValuePair("password",rg_password.getText().toString());
			list.add(bnvp);
			list.add(bnvp2);
			try {
				httpPost.setEntity(new UrlEncodedFormEntity(list, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			HttpResponse httpResponse;
			try {
				httpResponse = httpClient.execute(httpPost);
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if (statusCode == HttpStatus.SC_OK) // SC_OK = 200
				{
					String str = EntityUtils.toString(httpResponse.getEntity());
					// 获得返回结果
					if(str.equals("success")){
						handler.sendEmptyMessage(0x123);
					}else if(str.equals("failed")){
						handler.sendEmptyMessage(0x125);
					}else if(str.equals("exited")){
						handler.sendEmptyMessage(0x124);
					}
				} else {
					handler.sendEmptyMessage(0x125);
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.regist, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
