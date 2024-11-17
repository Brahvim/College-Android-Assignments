package com.brahvim.college_assignments.front;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.brahvim.college_assignments.R;
import com.brahvim.college_assignments.databinding.FragmentMainBinding;

@SuppressWarnings("deprecation")
public class FragmentMain extends Fragment {

	private Context context;
	private Activity activity;
	private FragmentMainBinding binding;

	@Override
	public View onCreateView(final LayoutInflater p_inflater, final ViewGroup p_parent, final Bundle p_saveState) {
		super.onCreateView(p_inflater, p_parent, p_saveState);

		if (p_parent != null) {
			p_parent.removeAllViews();
		}

		this.activity = super.getActivity();
		this.context = this.activity.getApplicationContext();
		this.binding = FragmentMainBinding.inflate(p_inflater, p_parent, false);

		final String[] items = new String[50];

		for (int i = 0; i < items.length; ++i) {
			items[i] = Integer.toString(i);
		}

		this.binding.listViewList.setAdapter(
		  new ArrayAdapter<>(

			this.context,
			R.layout.list_element,
			items

		  )
											);

		this.binding.buttonAddTask.setOnClickListener((p_buttonAddTask) -> {

		});

		// return super.onCreateView(p_inflater, p_parent, p_saveState);
		return this.binding.getRoot();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		// De-allocate all fields!
		this.activity = null;
		this.binding = null;
		this.context = null;
	}

}
