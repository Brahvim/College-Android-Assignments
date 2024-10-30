package com.brahvim.college_assignments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brahvim.college_assignments.databinding.FragmentTwoBinding;

@SuppressWarnings("deprecation")
public class FragmentTwo extends Fragment {

	public static final String TAG = "App:" + FragmentTwo.class.getSimpleName();

	private FragmentTwoBinding binding;

	@Override
	public View onCreateView(final LayoutInflater p_inflater, final ViewGroup p_container, final Bundle p_saveState) {
		if (p_container != null) {
			p_container.removeAllViews();
		}

		this.binding = FragmentTwoBinding.inflate(p_inflater, p_container, false);
		// return p_inflater.inflate(R.layout.fragment_two, p_container, false);
		return this.binding.getRoot();
	}

	@Override
	public void onViewCreated(final View p_view, final Bundle p_saveState) {
		this.binding.buttonSwitchFragmentFragmentTwo.setOnClickListener(p_viewOnClick -> {
			super
			  .getFragmentManager()
			  .beginTransaction()
			  .addToBackStack(null)
			  .replace(R.id.fragmentContainerActivityMain, new FragmentOne())
			  .commit();
		});
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.binding = null;
	}

}
