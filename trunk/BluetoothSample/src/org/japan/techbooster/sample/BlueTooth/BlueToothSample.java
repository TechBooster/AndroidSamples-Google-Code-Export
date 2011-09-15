package org.japan.techbooster.sample.BlueTooth;

import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class BlueToothSample extends Activity {
    /** Called when the activity is first created. */
	
	static BluetoothAdapter mBtAdapter;
	int REQUEST_ENABLE_BLUETOOTH = 0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        boolean suportRet = supportConfirm();
        if(suportRet == false){
        	//��T�|�[�g�������ꍇ
        	Toast.makeText(this, "BT��T�|", Toast.LENGTH_SHORT).show();
        	finish();
        }else{
	        Toast.makeText(this, "BT�T�|�[�g����Ă܂�", Toast.LENGTH_SHORT).show();
	        
	        //Bluetooth��On��Off�����f����
	        //Off�������ꍇ�̓_�C�A���O�\������ON�ɂ���悤����
	        boolean btEnabledRet = OnOffConfirm();
	        if(btEnabledRet == false){
	        	//Off�������ꍇ
	        	//Intent���������ƁAON�ɂ���O�ɂ��̏����ɓ��邽�߁AON�ɂ�����̏����͂����ɏ����Ȃ��B
	        }
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
    	boolean btEnable = mBtAdapter.isEnabled();
    	if(btEnable == true){
    		Intent intent = new Intent(getApplicationContext(), DeviceListActivity.class);
    		startActivity(intent);        		
    		return true;
    	}
    	//On�łȂ��ꍇ�AOn�ɂ��邽�߂̃_�C�A���O��\������
    	Intent BtOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
    	startActivityForResult(BtOn, REQUEST_ENABLE_BLUETOOTH);
    	return false;
    }
    
    @Override
    protected void onActivityResult(int requestCode, int ResultCode, Intent date){
    	if(requestCode == REQUEST_ENABLE_BLUETOOTH){
    		if(ResultCode == Activity.RESULT_OK){
    			//Bluetooth��On�������ꍇ�̏���
    			Log("BT��On�ɂȂ�܂���");
    			//�y�A�����O��ʂɑJ�ڂ���
        		Intent intent = new Intent(getApplicationContext(), DeviceListActivity.class);
        		startActivity(intent);        		
    		}else{
    			Log("BT��On�ɂ��Ă��炦�܂���ł���");
    		}
    	}
    }
    
    public void Log(String string){
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();    	
    }
}