package com.ollyhal.budgetProgram;

import android.os.Bundle;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class NewUser extends Activity implements OnClickListener,
		OnCheckedChangeListener {

	// Creating the tab variables
	TabHost th;
	TabSpec ts;

	// Button Variables
	Button baddAccount;

	// CheckBox Variables
	CheckBox cbPin;

	// EditText Variables
	EditText etPin;

	// String Array
	String classes[] = { "LLoyds", "HSBC", "Virgin", "example", "example",
			"example5", "example6" };
	String acType[] = { "Current Account", "Savings" };

	ArrayAdapter<String> adapter;

	// ListBox Variable
	ListView bList;

	// Spinner Variable
	Spinner accountType;

	// Shared Preferences
	static String filename = "savePin";
	SharedPreferences editor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newuser); // Setting the layout
		tabsetup(); // Creating the tabs
		init(); // Initialise Variables
		spsetup(); // Create the Spinner
		lvsetup(); // Creating the ListView
		Listeners(); // Initialise Listeners

	}

	private void spsetup() {
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, acType);
		accountType.setAdapter(adapter);
	}

	private void lvsetup() {
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1,
				classes);
		bList.setAdapter(adapter);
	}

	private void init() {

		baddAccount = (Button) findViewById(R.id.bAddAccount);
		cbPin = (CheckBox) findViewById(R.id.cbPin);
		etPin = (EditText) findViewById(R.id.etPin);
		bList = (ListView) findViewById(R.id.lvBanks);
		accountType = (Spinner) findViewById(R.id.spAccountType);
		editor = getSharedPreferences(filename, 0);
	}

	private void Listeners() {
		baddAccount.setOnClickListener(this);
		cbPin.setOnCheckedChangeListener(this);
	}

	private void tabsetup() {
		th = (TabHost) findViewById(R.id.tabhost);
		th.setup();
		ts = th.newTabSpec("tag1");
		ts.setContent(R.id.tab1);
		ts.setIndicator("Manual");
		th.addTab(ts);
		ts = th.newTabSpec("tag2");
		ts.setContent(R.id.tab2);
		ts.setIndicator("Automatic");
		th.addTab(ts);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.newuser, menu);
		return true;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bAddAccount:
			String doubleData = etPin.getText().toString();
			Editor edit = editor.edit();
			edit.putString("Pin", doubleData);
			edit.commit();
			break;
		}

	}

	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.cbPin:
			etPin.setEnabled(cbPin.isChecked());			
			break;
		}

	}

}
