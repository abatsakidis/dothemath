package com.example.youdothemath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.dothe.math.R;

/**
 * This is demo code to accompany the Mobiletuts+ tutorial series:
 * - Android SDK: Create an Arithmetic Game
 * 
 * Sue Smith
 * July 2013
 *
 */

public class HowToPlay extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_how);
	}
	
	
	public void onBackPressed()  
	{  
		//super.onBackPressed();   
		Intent mainIntent = new Intent(HowToPlay.this,MainActivity.class);
		HowToPlay.this.startActivity(mainIntent);
		HowToPlay.this.finish();
	  //  return;  
	}  

}
