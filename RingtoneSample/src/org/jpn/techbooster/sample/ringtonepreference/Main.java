package org.jpn.techbooster.sample.ringtonepreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class Main extends PreferenceActivity implements
OnSharedPreferenceChangeListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

       /* �f�t�H���g��preference���擾 */
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		/* RingtonePreference�̐ݒ�l�擾 */
		String url = sp.getString("alarm_music_key", "");
		if(url == null){
			/* �T�C�����g�̏ꍇ */
		}else{
			/* ���̑� */
			Uri uri = Uri.parse(url);
			MediaPlayer mp = MediaPlayer.create(this, uri);
			mp.setLooping(true);
			mp.seekTo(0);
			mp.start();
		}

    }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		/* �f�t�H���g��preference���擾 */
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		
		/* RingtonePreference�̐ݒ�l�擾 */
		String url = sp.getString("alarm_music_key", "");
		if(url == null){
			/* �T�C�����g�̏ꍇ */
		}else{
			/* ���̑� */
			Uri uri = Uri.parse(url);
			MediaPlayer mp = MediaPlayer.create(this, uri);
			mp.setLooping(true);
			mp.seekTo(0);
			mp.start();
		}
		
	}
}