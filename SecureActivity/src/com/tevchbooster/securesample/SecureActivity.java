package com.tevchbooster.securesample;



import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.Toast;

public class SecureActivity extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samplesecure);
        
        Button Button00 = (Button)findViewById(R.id.Button_Toast);
        Button00.setOnClickListener(this);
        
        Button Button01 = (Button)findViewById(R.id.Button_NextPage);
        Button01.setOnClickListener(this);
        setTouchFilter(Button01);
      
    }
    
    public void onClick(View v){
	    if(v.getId() == R.id.Button_Toast){
	    	//�U�g�[�X�g����
 	    	Toast toast = Toast.makeText(SecureActivity.this, "���S�ł�", Toast.LENGTH_LONG);
	       	toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
	        // �g�[�X�g�\��
	       	toast.show();
	    }else if(v.getId() == R.id.Button_NextPage){
    		AlertDialog.Builder b = new AlertDialog.Builder(this);
    		b.setTitle("Alert");
    		b.setMessage("�{�^���͉�����܂����B100�~�U�荞��ł��������B");
    		b.show();
    	}
    }
    
    private void setTouchFilter(Button button) {
        button.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                		AlertDialog.Builder b = new AlertDialog.Builder(SecureActivity.this);
                		b.setTitle("Alert");
                		b.setMessage("���̃{�^���͊댯�ł��I");
                		b.show();
                    }
                    return true;
                }
                return false;
            }
        });
    }
}