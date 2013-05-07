package com.example.monthlyhate;

import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Date;
import android.view.*;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends Activity {
	
	private Button select;
	private EditText duration;
	private DatePicker startDate;
	private String[][] messages = {
		{"FOSTATA", "FANOSA", "FOSHITE"},
        {"Smith", "Jones"}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addBtnListener();
		startMsgService();
	}

	public void addBtnListener()
	{
		select = (Button) findViewById(R.id.select);
		duration = (EditText)findViewById(R.id.duration);
		startDate = (DatePicker) findViewById(R.id.startDate);
		
		select.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences sharedPref = getSharedPreferences("Hate", MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = sharedPref.edit();
				if(dataSet(sharedPref))
				{
					Intent intent = new Intent(MainActivity.this, ShowHate.class);
			        startActivity(intent);
				}
				String durationValue = duration.getText().toString();
				Date date = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
				
		        prefEditor.putString("duration", durationValue);
		        prefEditor.putLong("startdate", date.getTime());
		        prefEditor.commit();
			}
		}); 
	}
	
	private Boolean dataSet(SharedPreferences sharedPref)
	{
		if(sharedPref.getString("duration", "") != null &&
			sharedPref.getLong("startdate", 0) != 0)
		{
			return true;
		}
			return false;
	}
	
	private void showMessage(String msg)
	{	
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}
	
	private void startMsgService() {
		Context context = getBaseContext();
		Intent service = new Intent(getBaseContext(), MsgService.class);
		context.startService(service);
		
//		Calendar cal = null;
//		Intent service = new Intent(getBaseContext(), MsgService.class);
//		PendingIntent pintent = PendingIntent.getService(this, 0, service, 0);
//
//		AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
//		// Start every 30 seconds
//		alarm.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30*1000, pintent); 
	}
}
