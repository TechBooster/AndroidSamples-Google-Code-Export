package org.japan.techbooster.sample.toastsample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class ToastSampleActivity extends Activity {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //��������Toast�\���̏���
//        Toast toast = Toast.makeText(this, "Toast example", Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER|Gravity.LEFT, 0, 0);
//        toast.show();
        
        //��s�ŕ\�����Ă݂�
        Toast.makeText(this, "Toast example", Toast.LENGTH_LONG).show();
    }
}