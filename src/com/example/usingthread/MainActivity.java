package com.example.usingthread;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	public void ClickButton(View v) 
	{
		Toast.makeText(getApplicationContext(),"SUBMIT", Toast.LENGTH_SHORT).show();
		Thread th=new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				runOnUiThread(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(getApplicationContext(),"saved", Toast.LENGTH_SHORT).show();

					}
				});
			}
		});

		th.start();

	}

	public void ButtonSaved(View v){
		Thread th=new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<=10;i++){

					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					final int j=i;
					runOnUiThread(new Runnable() {

						public void run() {
							ProgressBar p=(ProgressBar)findViewById(R.id.progressBar1);
							p.setProgress(j*10);
						}
					});
				}
			}

		});
		th.start();


	}
}
