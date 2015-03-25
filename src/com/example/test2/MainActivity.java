package com.example.test2;

import android.support.v7.app.ActionBarActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;



public class MainActivity extends ActionBarActivity {
	int i = 0;
	
	private SensorManager mSensorManager;
	private Sensor mSensor;

		

    @Override
    protected void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
        
    	mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    	mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        
        setContentView(R.layout.activity_main);
        final TextView tview=(TextView)findViewById(R.id.textview);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.lockID);
        
    	Button upButton=(Button)findViewById(R.id.upID);
    	
    	upButton.setOnClickListener(new OnClickListener(){
    	

		@Override
		public void onClick(View v) {
    		
    		
    		i++;
    		
    		String st = String.valueOf(i);
    		tview.setText(st);
			
		}
    	});
    	
    	
    	
    	Button downButton=(Button)findViewById(R.id.downID);
    	
    	downButton.setOnClickListener(new OnClickListener(){
    	

		@Override
		public void onClick(View v) {
    		
    		
    		i--;
    		
    		String st = String.valueOf(i);
    		tview.setText(st);
			
		}
    	});
    	
    	
    	toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
    	    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
    	        if (isChecked) {
    	        	 buttonView.setBackgroundColor(Color.GREEN);
    	        } else {
    	        	buttonView.setBackgroundColor(Color.RED);
    	        }
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
}
