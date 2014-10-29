package com.example.planettempcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BondAlbedo extends Activity{

	
	Button mButton;
	EditText mEdit;
	Toast mToast;
	Intent mIntent;
	String userBondAlbedo;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_bond_albedo);
		
		
		mButton = (Button)findViewById(R.id.button1);
	    mEdit   = (EditText)findViewById(R.id.editText2);
	    Bundle extras = getIntent().getExtras();
	    final String userMass = extras.getString("User_mass");
	    final String userDistance = extras.getString("User_distance");

	    mButton.setOnClickListener(new OnClickListener() {
	    	
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				try {
					userBondAlbedo = mEdit.getText().toString();
				} catch (NumberFormatException e) {
					Toast.makeText(getApplicationContext(), "You must enter a value", Toast.LENGTH_LONG).show();
					userBondAlbedo = "0.0"; // your default value
				}
		
				mIntent = new Intent(BondAlbedo.this, Greenhouse.class);
				
				mIntent.putExtra("User_mass", userMass);
				mIntent.putExtra("User_distance", userDistance);
				mIntent.putExtra("User_bond_albedo", userBondAlbedo);
				startActivity(mIntent);
				
	
			}
		});
		
		
	}
	
	
}
