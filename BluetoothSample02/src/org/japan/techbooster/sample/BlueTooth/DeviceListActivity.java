package org.japan.techbooster.sample.BlueTooth;

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
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class DeviceListActivity extends Activity {
	
	private BluetoothAdapter mBtAdapter = BlueToothSample.mBtAdapter;
	private ArrayAdapter<String> pairedDeviceAdapter;
	private ArrayAdapter<String> nonPairedDeviceAdapter;
	
	public static final String ACTION_DISCOVERY_STARTED = BluetoothAdapter.ACTION_DISCOVERY_STARTED;
	public static final String ACTION_FOUND = BluetoothDevice.ACTION_FOUND;
	public static final String ACTION_NAME_CHANGED = BluetoothDevice.ACTION_NAME_CHANGED;
	public static final String ACTION_DISCOVERY_FINISHED = BluetoothAdapter.ACTION_DISCOVERY_FINISHED;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.devicelist);
        
        //�ڑ������̂���f�o�C�X���擾
        pairedDeviceAdapter = new ArrayAdapter<String>(this, R.layout.rowdata);
        //BluetoothAdapter����A�ڑ������̂���f�o�C�X�̏����擾
        Set<BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();
        if(pairedDevices.size() > 0){
        	//�ڑ������̂���f�o�C�X�����݂���
        	for(BluetoothDevice device:pairedDevices){
        		//�ڑ������̂���f�o�C�X�̏������Ɏ擾���ăA�_�v�^�ɋl�߂�
        		//getName()�E�E�E�f�o�C�X���擾���\�b�h
        		//getAddress()�E�E�E�f�o�C�X��MAC�A�h���X�擾���\�b�h
        		pairedDeviceAdapter.add(device.getName() + "\n" + device.getAddress());
        	}
        	ListView deviceList = (ListView)findViewById(R.id.pairedDeviceList);
        	deviceList.setAdapter(pairedDeviceAdapter);
        }
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	menu.add(0, Menu.FIRST, Menu.NONE, "�V�K�f�o�C�X���o");
		return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	//�I�v�V�������j���[���I�����ꂽ���̏���
        //���f�o�C�X�̌��o��L���ɂ���
        Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        startActivity(discoverableIntent);
        
    	TextView nonPairedListTitle = (TextView)findViewById(R.id.nonPairedListTitle);
    	nonPairedListTitle.setText("�ڑ������Ȃ��f�o�C�X�ꗗ");
    	
    	if(item.getItemId() == Menu.FIRST){
    		//�C���e���g�t�B���^�[��BroadcastReceiver�̓o�^
	        IntentFilter filter = new IntentFilter();
	        filter.addAction(ACTION_DISCOVERY_STARTED);
	        filter.addAction(ACTION_FOUND);
	        filter.addAction(ACTION_NAME_CHANGED);
	        filter.addAction(ACTION_DISCOVERY_FINISHED);
	        registerReceiver(DevieFoundReceiver, filter);
	        
    		nonPairedDeviceAdapter = new ArrayAdapter<String>(this, R.layout.rowdata);
	        //�ڑ��\�ȃf�o�C�X�����o
	        if(mBtAdapter.isDiscovering()){
	        	//�������̏ꍇ�͌��o���L�����Z������
	        	mBtAdapter.cancelDiscovery();
	        }
	        //�f�o�C�X����������
	        //��莞�Ԃ̊Ԍ��o���s��
	        mBtAdapter.startDiscovery();
    	}
		return false;
    }
    
    private final BroadcastReceiver DevieFoundReceiver = new BroadcastReceiver(){
    	//���o���ꂽ�f�o�C�X����̃u���[�h�L���X�g���󂯂�
    	@Override
    	public void onReceive(Context context, Intent intent){
    		String action = intent.getAction();
    		String dName = null;
    		BluetoothDevice foundDevice;
    		ListView nonpairedList = (ListView)findViewById(R.id.nonPairedDeviceList);;
    		if(ACTION_DISCOVERY_STARTED.equals(action)){
    			Log("�X�L�����J�n");
    		}
    		if(ACTION_FOUND.equals(action)){
    			//�f�o�C�X�����o���ꂽ
    			foundDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
    			if((dName = foundDevice.getName()) != null){
		    		if(foundDevice.getBondState() != BluetoothDevice.BOND_BONDED){
		    			//�ڑ��������Ƃ̂Ȃ��f�o�C�X�̂݃A�_�v�^�ɋl�߂�
		        		nonPairedDeviceAdapter.add(dName + "\n" + foundDevice.getAddress());  
	        			Log.d("ACTION_FOUND", dName);
		    		}
    			}
            	nonpairedList.setAdapter(nonPairedDeviceAdapter);
    		}    
    		if(ACTION_NAME_CHANGED.equals(action)){
    			//���O�����o���ꂽ
    			Log.d("ACTION_NAME_CHANGED", dName);
    			foundDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	    		if(foundDevice.getBondState() != BluetoothDevice.BOND_BONDED){
	    			//�ڑ��������Ƃ̂Ȃ��f�o�C�X�̂݃A�_�v�^�ɋl�߂�
	        		nonPairedDeviceAdapter.add(dName + "\n" + foundDevice.getAddress());    				
	    		}
            	nonpairedList.setAdapter(nonPairedDeviceAdapter);
    		}

    		if(ACTION_DISCOVERY_FINISHED.equals(action)){
    			Log("�X�L�����I��");
    		}
    	}
    };
    
    public void Log(String string){
		Toast.makeText(this, string, Toast.LENGTH_SHORT).show();    	
    }
}
