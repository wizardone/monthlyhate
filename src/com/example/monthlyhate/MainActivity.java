package com.example.monthlyhate;

import java.util.Calendar;
import android.content.Intent;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private DatePicker dp;
	private Button select;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//addBtnListener();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	
	public void addBtnListener()
	{
		select = (Button) findViewById(R.id.btnChangeDate);
		 
		select.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
			}
 
		});
	}

}
