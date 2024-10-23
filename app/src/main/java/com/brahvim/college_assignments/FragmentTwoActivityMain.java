package com.brahvim.college_assignments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

@SuppressWarnings("deprecation")
public class FragmentTwoActivityMain extends Fragment {

	@Override
	public void onCreate(final Bundle p_saveState) {
		super.onCreate(p_saveState);
	}

	@Override
	public View onCreateView(
	  final LayoutInflater p_inflater,
	  final ViewGroup p_container,
	  final Bundle p_saveState
							) {
		return p_inflater.inflate(R.layout.layout_fragment_two, p_container, false);
	}

}
