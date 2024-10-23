package com.brahvim.college_assignments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class ActivityMain extends Activity {

	@Override

	protected void onCreate(final Bundle p_saveState) {
		super.onCreate(p_saveState);
		super.setContentView(R.layout.layout_activity_main);

		this.injectFragmentIntoFragmentContainer(new FragmentOneActivityMain());
	}

	@SuppressWarnings("deprecation")
	public void injectFragmentIntoFragmentContainer(final Fragment p_fragment) {
		super.getFragmentManager()
			 .beginTransaction()
			 .add(R.id.fragmentContainerActivityMain, p_fragment)
			 .commit();
	}

}
