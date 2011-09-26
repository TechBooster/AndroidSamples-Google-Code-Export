package jp.org.techbooster.sample.SelfListenerSample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelfListenerSampleActivity extends Activity implements OnClickListener, SampleListenerInterface{
    
    private SampleNotify sn = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText et = (EditText) findViewById(R.id.editText1);
        // �ʒm�p�N���X�̃C���X�^���X��
        sn = new SampleNotify(et);
        // �ʒm�p�N���X�ɒʒm��̃C���X�^���X��t��
        sn.setListener(this);
        
        Button btn = (Button) findViewById(R.id.button1);
        
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // �ʒm�p�N���X�̃��\�b�h�����s
        sn.checkText();
    }

    @Override
    public void noInputText() {
        Toast.makeText(this, "�e�L�X�g��ł�", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void inputText() {
        Toast.makeText(this, "�e�L�X�g���͂���Ă܂�", Toast.LENGTH_SHORT).show();
    }
}