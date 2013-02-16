package com.example.monthlyhate;

import android.os.Bundle;
import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.*;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Date;
import android.view.*;
import android.widget.Toast;


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
		int randomNum = (int)(Math.random()*messages[0].length); 
		showMessage(messages[0][randomNum]);
	}

	public void addBtnListener()
	{
		select = (Button) findViewById(R.id.select);
		duration = (EditText)findViewById(R.id.duration);
		startDate = (DatePicker) findViewById(R.id.startDate);
		
		select.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String durationValue = duration.getText().toString();
				Date date = new Date(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth());
				
				SharedPreferences sharedPref = getSharedPreferences("FileName",MODE_PRIVATE);
		        SharedPreferences.Editor prefEditor = sharedPref.edit();
		        prefEditor.putString("duration", durationValue);
		        prefEditor.putLong("startdate", date.getTime());
		        showMessage("Saved");
		        prefEditor.commit();
			}
 
		}); 
	}
	
	private void showMessage(String msg)
	{	
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}
}
