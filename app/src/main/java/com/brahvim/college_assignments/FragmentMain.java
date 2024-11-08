package com.brahvim.college_assignments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brahvim.college_assignments.databinding.FragmentMainBinding;

@SuppressWarnings("deprecation")
public class FragmentMain extends Fragment {

	private FragmentMainBinding binding;

	@Override
	public View onCreateView(final LayoutInflater p_inflater, final ViewGroup p_parent, final Bundle p_saveState) {
		super.onCreateView(p_inflater, p_parent, p_saveState);

		if (p_parent != null) {
			p_parent.removeAllViews();
		}

		this.binding = FragmentMainBinding.inflate(p_inflater, p_parent, false);
		// return super.onCreateView(p_inflater, p_parent, p_saveState);
		return this.binding.getRoot();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		// De-allocate all fields!
		this.binding = null;
	}

}
