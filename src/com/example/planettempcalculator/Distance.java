package com.example.planettempcalculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Distance extends Activity{

	
	Button mButton;
	EditText mEdit;
	Toast mToast;
	Intent mIntent;
	String userDistance;
//	Double userMass;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_distance);
		
		
		mButton = (Button)findViewById(R.id.button1);
	    mEdit   = (EditText)findViewById(R.id.editText2);
	    
	    Bundle extras = getIntent().getExtras();
	    final String userMass = extras.getString("User_mass");
	    

	    mButton.setOnClickListener(new OnClickListener() {
	    	
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				try {
					userDistance = mEdit.getText().toString();
				} catch (NumberFormatException e) {
					Toast.makeText(getApplicationContext(), "You must enter a value", Toast.LENGTH_LONG).show();
					userDistance = "0.0"; // your default value
				}//convert the distance to cm if they entered it in anything but that
				mIntent = new Intent(Distance.this, BondAlbedo.class);
				mIntent.putExtra("User_mass", userMass);
				mIntent.putExtra("User_distance", userDistance);
				startActivity(mIntent);
			}
		});
		
		
	}
	
	
}
