package com.example.monthlyhate;

import android.annotation.SuppressLint;
//import android.app.AlertDialog;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

public class MsgService extends Service {

	private Handler handler;
	
	private String[][] messages = {
			{"FOSTATA", "FANOSA", "FOSHITE"},
	        {"Smith", "Jones"}
		};
	
	@SuppressLint("HandlerLeak")
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(getApplicationContext(), "Service started", Toast.LENGTH_LONG).show();
		  
		handler = new Handler() {
			@Override
		    public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				
				showMessage(messages[0][(int)(Math.random()*messages[0].length)]);
		    }
	
		};
		 
		new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				while(true)
				{
					try {
						Thread.sleep(10000);
						handler.sendEmptyMessage(0);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		        }
			}
		}).start();
		  
		//TODO do something useful
		return Service.START_NOT_STICKY;
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		//TODO for communication return IBinder implementation
		return null;
	}
	
	private void showMessage(String msg)
	{	
//		AlertDialog.Builder builder = new AlertDialog.Builder(this);
//		builder.setTitle("Title");
//		builder.setMessage("Message");
//		builder.setPositiveButton("OK", null);
//		builder.show();
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}
} 