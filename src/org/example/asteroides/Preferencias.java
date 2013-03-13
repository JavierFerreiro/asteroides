package org.example.asteroides;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class Preferencias extends PreferenceActivity {
	@SuppressWarnings("deprecation")
	@Override protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		//addPreferences is deprecated...ummm...investigate
		addPreferencesFromResource(R.xml.preferencias);
	}
}
