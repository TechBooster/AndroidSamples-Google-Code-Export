package jp.org.techbooster.sample.SelfListenerSample;

import android.widget.EditText;

public class SampleNotify {
    
    private EditText et = null;
    private SampleListenerInterface listener = null;
    
    public SampleNotify(EditText et) {
        this.et = et;
    }
    
    /**
     * EditText�Ƀe�L�X�g�����͂���Ă��邩�ǂ����𔻒肷��
     */
    public void checkText(){
        if(this.listener != null){
            if(this.et.getText().toString().equals("")){
                // �e�L�X�g�����͂���Ă��Ȃ��ꍇ�̒ʒm���s��
                listener.noInputText();
            }else{
                // �e�L�X�g�����͂���Ă���ꍇ�̒ʒm���s��
                listener.inputText();
            }
        }
    }
    
    /**
     * ���X�i�[��ǉ�����
     * @param listener
     */
    public void setListener(SampleListenerInterface listener){
        this.listener = listener;
    }
    
    /**
     * ���X�i�[���폜����
     */
    public void removeListener(){
        this.listener = null;
    }
}
