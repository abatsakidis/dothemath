package com.example.youdothemath;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

import com.dothe.math.R;

/**
 * This is demo code to accompany the Mobiletuts+ tutorial series:
 * - Android SDK: Create an Arithmetic Game
 * 
 * Sue Smith
 * July 2013
 *
 */
public class MainActivity extends Activity implements OnClickListener {

	//ui items
	//private Button playBtn, helpBtn, highBtn;
	private ImageButton playBtn, helpBtn, highBtn, about;
	//level names
	String[] levelNames = {"Εύκολο", "Μεσαίο", "Δύσκολο"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//retrieve references
		playBtn = (ImageButton)findViewById(R.id.play_btn);
		helpBtn = (ImageButton)findViewById(R.id.help_btn);
		highBtn = (ImageButton)findViewById(R.id.high_btn);
		about = (ImageButton)findViewById(R.id.about);
		
		//listen for clicks
		playBtn.setOnClickListener(this);
		helpBtn.setOnClickListener(this);
		highBtn.setOnClickListener(this);
		about.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		if(view.getId()==R.id.play_btn){
			//play button
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Επίπεδο?")
			.setSingleChoiceItems(levelNames, 0, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					//start gameplay
					startPlay(which);
				} 
			});
			AlertDialog ad = builder.create();
			ad.show();
		}
		else if(view.getId()==R.id.help_btn){
			//how to play button
			Intent helpIntent = new Intent(this, HowToPlay.class);
			this.startActivity(helpIntent);
		}
		else if(view.getId()==R.id.high_btn){
			//high scores button
			Intent highIntent = new Intent(this, HighScores.class);
			this.startActivity(highIntent);
		}else if(view.getId()==R.id.about){
			//high scores button
			Intent highIntent = new Intent(this, About.class);
			this.startActivity(highIntent);
		}
	}

	private void startPlay(int chosenLevel){
		//start gameplay
		Intent playIntent = new Intent(this, PlayGame.class);
		playIntent.putExtra("level", chosenLevel);
		this.startActivity(playIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
 public void onBackPressed() {
		 
		 Intent intent = new Intent(Intent.ACTION_MAIN);
			intent.addCategory(Intent.CATEGORY_HOME);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
			finish();
			System.exit(0);
  	 }
}
