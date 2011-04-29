package org.japan.techbooster.sample.BlueTooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class BlueToothSample extends Activity {
    /** Called when the activity is first created. */
	
	public BluetoothAdapter mBtAdapter;
	public int REQUEST_ENABLE_BLUETOOTH = 0;
	public boolean OnOffRet;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        boolean suportRet = supportConfirm();
        if(suportRet == true){
        	//Bluetooth�Ή��[���̏ꍇ�̏���
        	Toast.makeText(this, "BT�T�|�[�g����Ă܂�", Toast.LENGTH_SHORT).show();
            OnOffRet = OnOffConfirm();
        }else{
        	//Bluetooth��Ή��[���̏ꍇ�̏���
        	Toast.makeText(this, "BT��T�|", Toast.LENGTH_SHORT).show();
        	finish();
        }
    }
    
    private boolean supportConfirm(){
        //Bluetooth���T�|�[�g����Ă��邩�ۂ����m���߂�
        BluetoothAdapter Bt = BluetoothAdapter.getDefaultAdapter();
        if(Bt.equals(null)){
        	return false;
        }
        mBtAdapter = Bt;
        return true;
    }
    
    private boolean OnOffConfirm(){
    	//Bluetooth��On�ɂȂ��Ă��邩�ǂ������m���߂�
    	boolean OnOff = mBtAdapter.isEnabled();
    	if(OnOff == true){
    		//Bluetooth��On�ɂ��ꂽ�ꍇ�̏���
    		return true;
    	}else{
	    	//On�łȂ��ꍇ�AOn�ɂ��邽�߂̃_�C�A���O��\������
	    	Intent BtOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	    	startActivityForResult(BtOn, REQUEST_ENABLE_BLUETOOTH);
	    	return false;
    	}
    }
    
    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
    	if(requestCode == REQUEST_ENABLE_BLUETOOTH){
    		if(ResultCode == Activity.RESULT_OK){
    			//Bluetooth��On�ɂ��ꂽ�ꍇ�̏���
    			Toast.makeText(this, "BT��On�ɂȂ�܂���", Toast.LENGTH_SHORT).show();
    		}else{
    			//Bluetooth��On�ɂ���Ȃ������ꍇ�̏���
    			Toast.makeText(this, "BT��On�ɂ��Ă��炦�܂���ł���", Toast.LENGTH_SHORT).show();
            	finish();
    		}
    	}
    }
}