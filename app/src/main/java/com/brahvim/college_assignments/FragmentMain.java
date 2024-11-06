package com.brahvim.college_assignments;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.brahvim.college_assignments.databinding.FragmentMainBinding;

@SuppressWarnings("deprecation")
public class FragmentMain extends Fragment {

	public static String TAG = App.formTag(FragmentMain.class);

	private Activity host;
	private Context context;
	private FragmentMainBinding binding;

	public FragmentMain() {
		// This is required for inflating `Fragment`s, isn't it?
	}

	// region `Fragment`-lifecycle callbacks.
	@Override
	public View onCreateView(final LayoutInflater p_inflater, final ViewGroup p_parent, final Bundle p_saveState) {
		if (p_parent != null) {
			p_parent.removeAllViews();
		}

		this.host = super.getActivity();
		this.context = this.host.getApplicationContext();
		this.binding = FragmentMainBinding.inflate(p_inflater, p_parent, false);

		// return super.onCreateView(p_inflater, p_parent, p_saveState);
		return this.binding.getRoot();
	}

	@Override
	public void onStart() {
		super.onStart();
		// this.showFileSaveDialog();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		this.binding = null;
		this.context = null;
		this.host = null;
	}
	// endregion

	private void showFileSaveDialog() {
		final EditText textEditorFileName = new EditText(this.context);

		textEditorFileName.setLayoutParams(new LinearLayout.LayoutParams(
		  ViewGroup.LayoutParams.MATCH_PARENT,
		  ViewGroup.LayoutParams.WRAP_CONTENT
		));

		final AlertDialog dialog = new AlertDialog.Builder(this.context)
		  .setTitle("Save File")
		  .setView(textEditorFileName)
		  .setNegativeButton("Cancel", null)
		  .setPositiveButton("Save", (p_dialog, p_clickedElement) -> {

			  final String fileName = textEditorFileName.getText().toString();

			  switch (p_clickedElement) {

				  default: {
				  }
				  break;

				  case DialogInterface.BUTTON_POSITIVE: {
				  }
				  break;
			  }

		  })
		  .create();

		dialog.show();
	}

}
