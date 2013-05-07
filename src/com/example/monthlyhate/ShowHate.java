package com.example.monthlyhate;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ShowHate extends Activity
{
	private Button reset;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_hate);
		displayHate();
		
		addBtnListener();
	}
	
	public void addBtnListener()
	{
		reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				SharedPreferences sharedPref = getSharedPreferences("Hate", MODE_PRIVATE);
				SharedPreferences.Editor prefEditor = sharedPref.edit();
				prefEditor.remove("duration");
				prefEditor.remove("startdate");
				prefEditor.commit();
				
				Intent intent = new Intent(ShowHate.this, MainActivity.class);
		        startActivity(intent);
			}
		});
	}
	
	private void displayHate()
	{
		SharedPreferences sharedPref = getSharedPreferences("Hate", MODE_PRIVATE);
		
		if(sharedPref.getString("duration", "") != null &&
		   sharedPref.getLong("startdate", 0) != 0)
		{
			//Display information here	
		}
	}
}