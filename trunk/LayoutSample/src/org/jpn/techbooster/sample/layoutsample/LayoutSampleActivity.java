package org.jpn.techbooster.sample.layoutsample;

import com.kobashin.sample.layout.R;

import android.app.Activity;
import android.os.Bundle;

public class LayoutSampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}