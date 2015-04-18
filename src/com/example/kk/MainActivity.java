package com.example.kk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView textView;
	ListView listView;
	EditText editText;

	


	String[] mText = { "q1", "q2", "q3", "q4", "q5", "q6", "q7", "q8", "q9",
			"q10", };
	int[] mImage = { R.drawable.q1, R.drawable.q2, R.drawable.q3,
			R.drawable.q4, R.drawable.q5, R.drawable.q6, R.drawable.q7,
			R.drawable.q8, R.drawable.q9, R.drawable.q10, };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView1);
		MyAdapter myAdapter = new MyAdapter(getApplicationContext(), mText,
				mImage);
		listView.setAdapter(myAdapter);

		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
