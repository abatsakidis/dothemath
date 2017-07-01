package com.example.youdothemath;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.dothe.math.R;

public class About extends Activity {

	 // Activity tag used by logging APIs
	 private static final String ACT_TAG = "About";

	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		//bgale ton titlo
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		
		setContentView(R.layout.about);
		
		Button back = (Button) findViewById(R.id.back);
		
		back.setOnClickListener(new View.OnClickListener() {
		    @Override
		    public void onClick(View v) {
		        
		    	onBackPressed();
		    	
		    	//Intent intent = new Intent(About.this, SplashActivity.class);
	            //startActivity(intent); 
		        
		    }
		});
	}
	
	
	
	public void onBackPressed()  
	{  
		//super.onBackPressed();   
		Intent mainIntent = new Intent(About.this,MainActivity.class);
		About.this.startActivity(mainIntent);
		About.this.finish();
	  //  return;  
	}  
	
}