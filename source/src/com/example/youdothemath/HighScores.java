package com.example.youdothemath;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import com.dothe.math.R;

/**
 * This is demo code to accompany the Mobiletuts+ tutorial series:
 * - Android SDK: Create an Arithmetic Game
 * 
 * Sue Smith
 * July 2013
 *
 */

public class HighScores extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_high);

		//get text view
		TextView scoreView = (TextView)findViewById(R.id.high_scores_list);
		//get shared prefs
		SharedPreferences scorePrefs = getSharedPreferences(PlayGame.GAME_PREFS, 0);
		//get scores
		String[] savedScores = scorePrefs.getString("highScores", "").split("\\|");
		//build string
		StringBuilder scoreBuild = new StringBuilder("");
		for(String score : savedScores){
			scoreBuild.append(score+"\n");
		}
		//display scores
		scoreView.setText(scoreBuild.toString());
	}
	
	public void onBackPressed()  
	{  
		//super.onBackPressed();   
		Intent mainIntent = new Intent(HighScores.this,MainActivity.class);
		HighScores.this.startActivity(mainIntent);
		HighScores.this.finish();
	  //  return;  
	}  

}
