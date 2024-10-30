package com.brahvim.college_assignments;

import android.app.Activity;
import android.os.Bundle;

public class ActivityMain extends Activity {

	@Override
	@SuppressWarnings("deprecation")
	protected void onCreate(final Bundle p_saveState) {
		super.onCreate(p_saveState);
		super.setContentView(R.layout.activity_main);

		if (p_saveState == null) { // Runs only the first time the `Activity` is started.
			super.getFragmentManager()
				 .beginTransaction()
				 .add(R.id.fragmentContainerActivityMain, new FragmentOne())
				 .commit();
		}
	}

}
