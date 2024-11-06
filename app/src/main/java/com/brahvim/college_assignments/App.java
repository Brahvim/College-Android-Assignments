package com.brahvim.college_assignments;

import android.app.Application;

public class App extends Application {

	public static String formTag(final Class<?> p_class) {
		return "App:" + p_class.getSimpleName();
	}

}
