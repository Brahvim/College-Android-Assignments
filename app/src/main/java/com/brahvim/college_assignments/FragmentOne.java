package com.brahvim.college_assignments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brahvim.college_assignments.databinding.FragmentOneBinding;

@SuppressWarnings("deprecation")
public class FragmentOne extends Fragment {

	public static final String TAG = "App:" + FragmentOne.class.getSimpleName();

	private FragmentOneBinding binding;

	@Override
	public View onCreateView(final LayoutInflater p_inflater, final ViewGroup p_container, final Bundle p_saveState) {
		if (p_container != null) {
			p_container.removeAllViews();
		}

		this.binding = FragmentOneBinding.inflate(p_inflater, p_container, false);
		// return p_inflater.inflate(R.layout.fragment_one, p_container, false);
		return this.binding.getRoot();
	}

	@Override
	public void onViewCreated(final View p_view, @Nullable final Bundle p_saveState) {
		this.binding.buttonSwitchFragmentFragmentOne.setOnClickListener(p_viewOnClick -> {
			super
			  .getFragmentManager()
			  .beginTransaction()
			  .addToBackStack(null)
			  .replace(R.id.fragmentContainerActivityMain, new FragmentTwo())
			  .commit();
		});
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.binding = null;
	}

}
