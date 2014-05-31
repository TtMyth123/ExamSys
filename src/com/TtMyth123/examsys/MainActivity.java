package com.TtMyth123.examsys;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

import com.TtMyth123.examsys.bean.SubItemTitle;
import com.TtMyth123.examsys.bean.Topic;
import com.TtMyth123.examsys.view.TopicView;


public class MainActivity extends Activity{
	TopicView  topicView1 ;
	LinearLayout ll1;
	Button btn1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.mainlayout);
		
		  topicView1 = (TopicView) findViewById(R.id.topicView1);
		
		btn1= (Button) findViewById(R.id.btnB);
		ll1 = (LinearLayout)findViewById(R.id.linearLayout1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
//				Button btnA = new Button(ll1.getContext());
//				btnA.setText("aabbcc");
//				ll1.addView(btnA);
				Topic topic = new Topic();
				topic.setAnswer("bbdfa fdafdsa faf das fa fdas fsa");
				List<SubItemTitle> subItemTitle= new java.util.Vector<SubItemTitle>();
				SubItemTitle item = new SubItemTitle();
				item.setItem("aabbcc");
				subItemTitle.add(item);
				item = new SubItemTitle();
				item.setItem( "cccccc");
				subItemTitle.add(item);
				topic.setSubItemTitle(subItemTitle);
				topicView1.setTopic(topic);
				
				
				
			}
		});
		
		
	}

}
