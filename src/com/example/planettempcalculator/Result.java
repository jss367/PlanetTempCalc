package com.example.planettempcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Result extends Activity{

	EditText mEdit;
	final double sbConstant = 5.67037321E-5;
	final int stringBuilderSize = 16;
	String message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_result);
		
	    mEdit   = (EditText)findViewById(R.id.editText2);
	
	    Bundle extras = getIntent().getExtras();
	    final String userMass = extras.getString("User_mass");
	    final String userDistance = extras.getString("User_distance");
	    final String userBondAlbedo = extras.getString("User_bond_albedo");
	    final String userGreenhouse = extras.getString("User_greenhouse");
	 	    
	    //not sure if this should be part of oncreate...probably not....
	    
	    double mass = Double.parseDouble(userMass);
	    double distance = Double.parseDouble(userDistance);  //distance is in cm
	    distance = distance * 1.496E13;
	    double bondalbedo = Double.parseDouble(userBondAlbedo);
	    double greenhouse = Double.parseDouble(userGreenhouse);
	    double luminosity = Math.pow(mass,3)*3.846E33; //mass must be in solar masses
	    double fourth_power_effective_temperature = (1-bondalbedo)*luminosity/(16*(Math.PI*sbConstant*Math.pow(distance,2)));
	    double effective_temperature = Math.pow(fourth_power_effective_temperature, 0.25); 
	    double fourth_power_ground_temperature = fourth_power_effective_temperature*(1+.438*greenhouse);
	    double fourth_power_surface_temperature = fourth_power_ground_temperature / .9;
	    double surface_temperature = Math.pow(fourth_power_surface_temperature, (1.0/4.0));

	    float st = (float)Math.round(surface_temperature);
	    
	    
	    StringBuilder builder = new StringBuilder(stringBuilderSize);
  
	    
	    if (st < 0){
	    	message = getString(R.string.cold);
	    	builder.append("This is below the freezing point of water on Earth");
	    	if (st < -17.8){
	    		builder.append("\nThe Earth's oceans would freeze (-17.8º C)");
	    	}
	    	if (st < -78.5){
	    		builder.append("\nAll the carbon dioxide in the Earth's atmosphere would freeze (-78.5º C)");
	    	}
	    	if (st < -210){
	    		builder.append("\nAll the nitrogen in the Earth's atmosphere would freeze (-210.0º C)");
	    		    	}
	    	if (st < -218.79){
	    		builder.append("\nAll the oxygen in the Earth's atmosphere would freeze (-218.79º C)");
	    		    	}
	    			}
	    else if (st < 100){
	    	message = getString(R.string.habitable);
	    	builder.append("Under Earth-like atmospheric pressure, water would be in a liquid state");
	    	builder.append("\nMany scientists think the presence of water as a liquid on a planet is critcal for sustanining life");    		    	
	    }
	    else{
	    	message = getString(R.string.hot);
	    	if (st > 100){
	    		builder.append("This is above the boilling point of water on Earth(100º C)");
	    	}
	    	if (st > 282){
	    		builder.append("\nThe Earth's forests would burn up (282º C)");
	    		    	}
	    	if (st > 327.5){
	    		builder.append("\nLead would melt (327.5º C)");
	    		    	}
	    	if (st > 1100){
	    		builder.append("\nThe Earth's rocky crust would melt (1100º C)");
	    		    	}
	    			}	    
	    
	    
String temp = String.valueOf(st);
TextView warmth = (TextView) findViewById(R.id.textView2);
warmth.setText(message);

TextView answer = (TextView) findViewById(R.id.textView1);
answer.setText("The temperature is " + temp + "º C\n" + builder);


	}	
}
