package com.nasatrainedmonkeys.sharecontact.activity;

import com.nasatrainedmonkeys.sharecontact.R;

import android.content.Intent;
import android.os.Bundle;
import roboguice.activity.RoboSplashActivity;

public class SplashActivity extends RoboSplashActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
	}

	@Override
	protected void startNextActivity() {
		startActivity(new Intent(this, MainActivity.class));
	}

}
