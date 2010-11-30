package com.nasatrainedmonkeys.sharecontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button mScanButton;
	private Button mShareButton;
	private TextView mScanResult;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		getWidgets();
	}

	private void getWidgets() {
		mScanButton = (Button) findViewById(R.id.main_scan_barcode);
		mScanButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 IntentIntegrator.initiateScan(MainActivity.this);
			}
		});

		mShareButton = (Button) findViewById(R.id.main_share);
		mShareButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.main_share_subject));
                i.putExtra(Intent.EXTRA_TEXT, mScanResult.getText());
                startActivity(Intent.createChooser(i, getString(R.string.main_share_button)));
			}
		});

		mScanResult = (TextView) findViewById(R.id.main_text_result);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (IntentIntegrator.REQUEST_CODE == requestCode) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				mScanResult.setText(contents);
			} else if (resultCode == RESULT_CANCELED) {
				Toast.makeText(this,
						getString(R.string.main_errors_scan_error),
						Toast.LENGTH_SHORT).show();
			}
		}
	}

}