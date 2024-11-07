package com.brahvim.college_assignments;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	// region Fields.
	// region `static` fields.
	public static final int[] idsNumberedButtonViewsCalculator = { // NOSONAR!

	  R.id.buttonCalculatorNumberOne,
	  R.id.buttonCalculatorNumberTwo,
	  R.id.buttonCalculatorNumberThree,
	  R.id.buttonCalculatorNumberFour,
	  R.id.buttonCalculatorNumberFive,
	  R.id.buttonCalculatorNumberSix,
	  R.id.buttonCalculatorNumberSeven,
	  R.id.buttonCalculatorNumberEight,
	  R.id.buttonCalculatorNumberNine,
	  R.id.buttonCalculatorNumberZero,
	  R.id.buttonCalculatorNumberDoubleZero,

	};

	public static final String[] strTagsNumberedButtonViewsCalculator = { // NOSONAR!

	  "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "00"

	};
	// endregion

	public final Button[] viewsNumberedButtonViewsCalculator = new Button[idsNumberedButtonViewsCalculator.length];

	private TextView textViewCalculatorResult;
	// endregion

	@Override
	protected void onCreate(final Bundle p_savedInstanceState) {
		super.onCreate(p_savedInstanceState);
		super.setContentView(R.layout.layout_main);

		// Field assignments:
		this.textViewCalculatorResult = super.findViewById(R.id.textViewCalculatorResult);

		this.setupButtonsCalculatorControl();
		this.setupButtonsCalculatorNumbered();
		this.setupButtonsCalculatorOperations();
	}

	public void setupButtonsCalculatorControl() {
		super
		  .findViewById(R.id.buttonCalculatorControlClear)
		  .setOnClickListener(p_view -> this.textViewCalculatorResult.setText(R.string.textButtonZeroTableRowTableLayoutCalculatorButtonsActivityMain));

		super
		  .findViewById(R.id.buttonCalculatorControlDelete)
		  .setOnClickListener(p_view -> {
			  final String strInitialValue = this.textViewCalculatorResult.getText().toString();
			  this.textViewCalculatorResult.setText(strInitialValue.substring(strInitialValue.length() - 1));
		  });

		super
		  .findViewById(R.id.buttonCalculatorControlClearEntry)
		  .setOnClickListener(p_view -> this.textViewCalculatorResult.setText(R.string.textButtonZeroTableRowTableLayoutCalculatorButtonsActivityMain));
	}

	public void setupButtonsCalculatorNumbered() {
		for (int i = 0; i < this.viewsNumberedButtonViewsCalculator.length; ++i) {
			final View v
			  = this.viewsNumberedButtonViewsCalculator[i]
			  = super.findViewById(idsNumberedButtonViewsCalculator[i]);

			v.setTag(strTagsNumberedButtonViewsCalculator[i]);

			v.setOnClickListener(p_view -> {

				// `View::getText()` returns a `SpannableString` as a `CharSequence`.
				final String strInitialValue = this.textViewCalculatorResult.getText().toString();
				final String strTag = (String) p_view.getTag();
				String strNewValue = strInitialValue;

				if ("NaN".equals(strInitialValue) || "0".equals(strInitialValue)) { // Branch in frequent callback :(
					strNewValue = "";
				}

				this.textViewCalculatorResult.setText(strNewValue + strTag);
			});
		}
	}

	public void setupButtonsCalculatorOperations() {
		super.findViewById(R.id.buttonCalculatorOperationAdd)
			 .setOnClickListener(p_view ->
								   MainActivity.this.textViewCalculatorResult.setText(
									 MainActivity.this.textViewCalculatorResult.getText().toString() + " + "));

		super.findViewById(R.id.buttonCalculatorOperationDivide)
			 .setOnClickListener(p_view ->
								   MainActivity.this.textViewCalculatorResult.setText(
									 MainActivity.this.textViewCalculatorResult.getText().toString() + " / "));

		super.findViewById(R.id.buttonCalculatorOperationSubtract)
			 .setOnClickListener(p_view ->
								   MainActivity.this.textViewCalculatorResult.setText(
									 MainActivity.this.textViewCalculatorResult.getText().toString() + " - "));

		super.findViewById(R.id.buttonCalculatorOperationMultiply)
			 .setOnClickListener(p_view ->
								   MainActivity.this.textViewCalculatorResult.setText(
									 MainActivity.this.textViewCalculatorResult.getText().toString() + " * "));

		super.findViewById(R.id.buttonCalculatorOperationEquals)
			 .setOnClickListener(p_view -> {
				 String strInitialValue = MainActivity.this.textViewCalculatorResult
				   .getText()
				   .toString()
				   .replaceAll("NaN", "0");

				 final int posSpace = strInitialValue.indexOf(' ');
				 final int posNextNumStart = strInitialValue.indexOf(' ', posSpace + 1);

				 if (posSpace == -1 || posNextNumStart == -1) {
					 return;
				 }

				 final String strOperandOne = strInitialValue.substring(0, posSpace);
				 final String strOperandTwo = strInitialValue.substring(1 + posNextNumStart);

				 final long numOperandOne;
				 final long numOperandTwo;
				 String result = strInitialValue;
				 char op = strInitialValue.charAt(posSpace + 1);

				 try {
					 numOperandOne = Long.parseLong(strOperandOne);
					 numOperandTwo = Long.parseLong(strOperandTwo);
				 } catch (final NumberFormatException nfe) {
					 result = "NaN";
					 MainActivity.this.textViewCalculatorResult.setText(result);
					 return;
				 }

				 switch (op) {

					 case '+': {
						 result = Long.toString(numOperandOne + numOperandTwo);
					 }
					 break;

					 case '/': {
						 if (numOperandOne == 0 || numOperandTwo == 0) {
							 result = "NaN";
						 } else {
							 result = Long.toString(numOperandOne / numOperandTwo);
						 }
					 }
					 break;

					 case '-': {
						 result = Long.toString(numOperandOne - numOperandTwo);
					 }
					 break;

					 case '*': {
						 result = Long.toString(numOperandOne * numOperandTwo);
					 }
					 break;

					 default: {
						 // NOSONAR!
					 }
					 break;

				 }

				 MainActivity.this.textViewCalculatorResult.setText(result);
			 });
	}

}
