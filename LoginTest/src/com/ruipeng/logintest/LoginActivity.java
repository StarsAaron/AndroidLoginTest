package com.ruipeng.logintest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends ActionBarActivity {
	private EditText et_name, et_password;
	private Button bn_login, bn_regist;

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 0x123:
				Toast.makeText(LoginActivity.this, "登录成功！", Toast.LENGTH_SHORT)
						.show();
				break;
			case 0x124:
				Toast.makeText(LoginActivity.this, "用户名或密码不能为零！",
						Toast.LENGTH_SHORT).show();
				break;
			case 0x125:
				Toast.makeText(LoginActivity.this, "登录失败！！", Toast.LENGTH_SHORT)
						.show();
				break;
			}
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
	}

	/**
	 * @初始化
	 */
	private void init() {
		et_name = (EditText) findViewById(R.id.name);
		et_password = (EditText) findViewById(R.id.password);
		bn_login = (Button) findViewById(R.id.login);
		bn_regist = (Button) findViewById(R.id.regist);

		bn_login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String name = et_name.getText().toString();
				String password = et_password.getText().toString();
				if ((!name.equals(""))&&name!= null&&(!password.equals(""))&& password!= null) {
					loginServer();
				} else {
					Toast.makeText(LoginActivity.this, "不能为空！！",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		bn_regist.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent it = new Intent(LoginActivity.this, RegistActivity.class);
				startActivity(it);
			}
		});

	}

	public void loginServer() {
		new loginThread().start();
	}

	private class loginThread extends Thread {
		String Url = "http://10.0.2.2:8080/StudentInfo/LoginServlet?";

		@Override
		public void run() {
			Url += "name=" + et_name.getText().toString() + "&password="
					+ et_password.getText().toString();
			HttpParams httpParameters = new BasicHttpParams();
			// 设置链接超时
			HttpConnectionParams.setConnectionTimeout(httpParameters, 3000);
			// 设置Socket每一秒传输数据超时
			HttpConnectionParams.setSoTimeout(httpParameters, 5000);
			// 构建HttpClient的实例
			HttpClient httpClient = new DefaultHttpClient(httpParameters);
			// 创建GET方法的实例
			HttpGet httpGet = new HttpGet(Url);
			HttpResponse httpResponse;
			try {
				httpResponse = httpClient.execute(httpGet);
				int statusCode = httpResponse.getStatusLine().getStatusCode();
				if (statusCode == HttpStatus.SC_OK) // SC_OK = 200
				{
					String str = EntityUtils.toString(httpResponse.getEntity());
					// 获得返回结果
					if(str.equals("success")){
						handler.sendEmptyMessage(0x123);
					}else if(str.equals("failed")){
						handler.sendEmptyMessage(0x125);
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
		getMenuInflater().inflate(R.menu.login, menu);
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
