package com.ollyhal.budgetProgram;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Pin extends Activity implements OnClickListener {

	// Button
	Button b;
	Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;

	// PinField
	EditText pField;

	// Strings
	String ButtonText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("Testing");
		setContentView(R.layout.pin);
		init();
		System.out.println("Testing");
	}

	private void init() {
		pField = (EditText) findViewById(R.id.pinField);

		num0 = (Button) findViewById(R.id.number0);
		num1 = (Button) findViewById(R.id.number1);
		num2 = (Button) findViewById(R.id.number2);
		num3 = (Button) findViewById(R.id.number3);
		num4 = (Button) findViewById(R.id.number4);
		num5 = (Button) findViewById(R.id.number5);
		num6 = (Button) findViewById(R.id.number6);
		num7 = (Button) findViewById(R.id.number7);
		num8 = (Button) findViewById(R.id.number8);
		num9 = (Button) findViewById(R.id.number9);

		num0.setOnClickListener(this);
		num1.setOnClickListener(this);
		num2.setOnClickListener(this);
		num3.setOnClickListener(this);
		num4.setOnClickListener(this);
		num5.setOnClickListener(this);
		num6.setOnClickListener(this);
		num7.setOnClickListener(this);
		num8.setOnClickListener(this);
		num9.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {

		b = (Button) v;
		ButtonText = b.getText().toString();
		pField.setText(pField.getText() + ButtonText);

	}

}
