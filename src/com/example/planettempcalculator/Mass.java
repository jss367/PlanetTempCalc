package com.example.planettempcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Mass extends ActionBarActivity implements OnItemSelectedListener{

	Button mButton;
	EditText mEdit;
	Toast mToast; //this one is working too!
	Intent mIntent;
	String userMass;
	
	/*
	private boolean mIsBound = false;
	private MusicService mServ;
	private ServiceConnection Scon =new ServiceConnection(){

		public void onServiceConnected(ComponentName name, IBinder
	     binder) {
		mServ = ((MusicService.ServiceBinderbinder).getService());
		}

		public void onServiceDisconnected(ComponentName name) {
			mServ = null;
		}
		};

		void doBindService(){
	 		bindService(new Intent(this,MusicService.class),
					Scon,Context.BIND_AUTO_CREATE);
			mIsBound = true;
		}

		void doUnbindService()
		{
			if(mIsBound)
			{
				unbindService(Scon);
	      		mIsBound = false;
			}
		}
	*/
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
//this is the music - you need this!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		//startService(new Intent(this, MyService.class));

		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.units_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
		
//		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
			
//			String unit = parent.getItemAtPosition(pos) ;
			
//		}
		
		    mButton = (Button)findViewById(R.id.button1);
		    mEdit   = (EditText)findViewById(R.id.editText);	    
		    mButton.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {

				
/*				throws testUserInput{
						Double userDistance = Double.parseDouble(mEdit.getText().toString());
						if (userDistance = "null"){
							throw new testUserInput("You must enter a number");
						}
						
						mIntent = new Intent(Mass.this, Distance.class);
						mIntent.putExtra("User_mass", userDistance);
						startActivity(mIntent);
					}
	*/				
		
					try {
						userMass = mEdit.getText().toString();
					} catch (NumberFormatException e) {
						Toast.makeText(getApplicationContext(), "You must enter a value", Toast.LENGTH_LONG).show();
					    userMass = "0.0"; // your default value
					}
					//if mass isn't in solar masses convert it to a double and adjust for whatever unit was used
					
					mIntent = new Intent(Mass.this, Distance.class);
					mIntent.putExtra("User_mass", userMass);
					startActivity(mIntent);			
				}
			});

		}

	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}

}
