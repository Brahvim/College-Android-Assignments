package com.brahvim.college_assignments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brahvim.college_assignments.databinding.FragmentMainBinding;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("deprecation")
public class FragmentMain extends Fragment {

	public static String TAG = App.formTag(FragmentMain.class);

	private Activity host;
	private Context context;
	private String filePath;
	private FragmentMainBinding binding;

	public FragmentMain() {
		// This is required for inflating `Fragment`s, isn't it?
	}

	// region `Fragment`-lifecycle callbacks.
	@Override
	public View onCreateView(final LayoutInflater p_inflater, final ViewGroup p_parentView, final Bundle p_saveState) {
		if (p_parentView != null) {
			p_parentView.removeAllViews();
		}

		this.host = super.getActivity();
		this.context = this.host.getApplicationContext();
		this.binding = FragmentMainBinding.inflate(p_inflater, p_parentView, false);
		this.filePath = super.getString(R.string.nameFileEditorContentTextEditorFragmentMain);

		this.binding.editTextEditor.setText(this.loadFile());
		// this.binding.editTextEditor.setOnEditorActionListener((TextView.OnEditorActionListener) (p_parentEditText, p_action, p_event) -> {
		// 	// if (p_event != null) {
		// 	// 	final int c = p_event.getUnicodeChar();
		// 	//
		// 	// 	if (c == '\n') {
		// 	// 		this.saveFile(p_parentEditText.getText().toString());
		// 	// 		return true;
		// 	// 	}
		// 	// }
		// 	//
		// 	// switch (p_action) {
		// 	//
		// 	// 	default: {
		// 	// 	}
		// 	// 	break;
		// 	//
		// 	// 	case EditorInfo.IME_ACTION_DONE: {
		// 	// 		if (this.saveFile(p_parentEditText.getText().toString())) {
		// 	// 			return true;
		// 	// 		}
		// 	// 	}
		// 	// 	break;
		// 	// }
		//
		// 	return false;
		// });

		// return super.onCreateView(p_inflater, p_parentView, p_saveState);
		return this.binding.getRoot();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		this.saveFile(this.binding.editTextEditor.getText().toString());

		this.binding = null;
		this.context = null;
		this.host = null;
	}
	// endregion

	private String loadFile() {
		try (final FileInputStream stream = this.context.openFileInput(this.filePath)) {

			final byte[] textEncoded = new byte[stream.available()];
			stream.read(textEncoded);
			return new String(textEncoded, StandardCharsets.UTF_8);

		} catch (final IOException e) {
			return "";
		}
	}

	private boolean saveFile(final String p_content) {
		try (final FileOutputStream stream = this.context.openFileOutput(this.filePath, Context.MODE_PRIVATE)) {

			stream.write(p_content.getBytes(StandardCharsets.UTF_8));

		} catch (final IOException e) {
			return false;
		}

		return true;
	}

}
