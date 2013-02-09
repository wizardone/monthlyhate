package com.example.monthlyhate;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private String[][] messages = {
		{"FOSTATA", "FANOSA", "FOSHITE"},
        {"Smith", "Jones"}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		int randomNum = (int)(Math.random()*messages[0].length); 
		showMessage(messages[0][randomNum]);
	}
	
	private void showMessage(String msg)
	{	
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
	}
}
