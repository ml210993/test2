package com.example.test2;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
import android.hardware.*;
//import android.hardware.SensorManager;



public class MainActivity extends Activity implements SensorEventListener  {
	float mLastX, mLastY,mLastZ;
	int i = 0;
	private boolean mInit;
	private final float NOISE = (float)2.0;
	
	private SensorManager mSensorManager;
	private Sensor mAccelerometer;

		

    @Override
    protected void onCreate(Bundle savedInstanceState) {    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
        
        mInit = false;
    	mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    	mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    	 mSensorManager.registerListener( this, mAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
       
        
        
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
    	
    	
   
    } //beidzas onCreate
    
 
    
    public void onSensorChanged(SensorEvent event){
    	TextView tvX = (TextView)findViewById(R.id.xValue);
    	TextView tvY = (TextView)findViewById(R.id.yValue);
    	TextView tvZ = (TextView)findViewById(R.id.zValue);
//    	
//    	float x = event.values[0];
//    	float y = event.values[1];
//    	float z = event.values[2];
//    	
//    	if (!mInit){
//    		mLastX=x;
//    		mLastY=y;
//    		mLastZ=z;
//    		tvX.setText("0.0");
//    		tvY.setText("0.0");
//    		tvZ.setText("0.0");
//    		mInit = true;
//    	}
//    	
//    	else{
//    		float deltaX = Math.abs(mLastX - x);
//    		float deltaY = Math.abs(mLastX - y);
//    		float deltaZ = Math.abs(mLastX - z);
//    		
//    		if (deltaX < NOISE) deltaX = (float)0.0;
//    		if (deltaY < NOISE) deltaY = (float)0.0;
//    		if (deltaZ < NOISE) deltaZ = (float)0.0;
//    		
//    		mLastX=x;
//    		mLastY=y;
//    		mLastZ=z;
//    		
//    		tvX.setText(Float.toString(deltaX));
//    		tvY.setText(Float.toString(deltaY));
//    		tvZ.setText(Float.toString(deltaZ));
//    		
//    		
//    	}
    	
    	if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
			
			// assign directions
			float x=event.values[0];
			float y=event.values[1];
			float z=event.values[2];
			
			tvX.setText(Float.toString(x));
			tvY.setText(Float.toString(y));
			tvZ.setText(Float.toString(z));
		}
    	
    	
    	
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



	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}
}
