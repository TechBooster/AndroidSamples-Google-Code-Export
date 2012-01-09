package org.japan.techbooster.sample.TextLink;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class TextLink extends Activity {
    /** Called when the activity is first created. */
	
	String htmlNameStr = "<FONT color=\"red\"><I><B><BIG>seit</BIG></B></I></FONT>";
	//�u���O��URL��`
	String htmlBlogStr = "������<a href=\"http://techbooster.jpn.org/\">Tech Booster</a>�ł�";
	//���[���A�h���X��`
	String addressStr = "<���[���A�h���X>";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);

    	TextView nameLink = (TextView)findViewById(R.id.name_link);
    	TextView blogLink = (TextView)findViewById(R.id.blog_link);
    	TextView addressLink = (TextView)findViewById(R.id.address_link);
    
    	//TextView���N���b�J�u���ɂ���
    	MovementMethod mMethod = LinkMovementMethod.getInstance();
    	blogLink.setMovementMethod(mMethod);

    	//String�������HTML�^�O�𐶂������`���ɕϊ�
    	CharSequence nameChar = Html.fromHtml(htmlNameStr);
    	CharSequence blogChar = Html.fromHtml(htmlBlogStr);

    	nameLink.setText(nameChar);
    	blogLink.setText(blogChar);
    	addressLink.setText(addressStr);

    }
}