package net.npaka.touchex;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

//�^�b�`�C�x���g�̏���
public class TouchEx extends Activity {
    private TouchView   touchView;  //�^�b�`�r���[
    private TickHandler tickHandler;//��������n���h��
    
    //�A�v���̏�����
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        touchView=new TouchView(this);
        setContentView(touchView);
    }

    //�A�v���̍ĊJ
    @Override
   public void onResume() {
        super.onResume();
        tickHandler=new TickHandler();
        tickHandler.sleep(0);
    }    
    
    //�A�v���̈ꎞ��~
//    @Override
//    public void onPause() {
//        super.onPause();
//       tickHandler=null;
//    }    
    
    //��������n���h��
    public class TickHandler extends Handler {
        //�n���h�����b�Z�[�W
        @Override 
        public void handleMessage(Message msg) {
            touchView.invalidate();
            if (tickHandler!=null) tickHandler.sleep(1000);
        }
        
        //�X���[�v
        public void sleep(long delayMills) {
            removeMessages(0);
            sendMessageDelayed(obtainMessage(0),delayMills);
        }
    }
}