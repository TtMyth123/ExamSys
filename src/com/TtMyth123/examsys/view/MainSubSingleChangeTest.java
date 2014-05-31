package com.TtMyth123.examsys.view;

import java.util.List;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.TtMyth123.examsys.bean.SubItemTitle;
import com.TtMyth123.examsys.bean.Topic;

public class MainSubSingleChangeTest extends TopicView {
	public MainSubSingleChangeTest(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public MainSubSingleChangeTest(Context context) {
		super(context, null);
	}
	
	@Override
	protected Topic getIniTopic() {
		Topic topic = new Topic();
		topic.setAnswer(mainTitleText);
		List<SubItemTitle> subItemTitle= new java.util.Vector<SubItemTitle>();
		SubItemTitle item = new SubItemTitle();
		
		Topic topicSub1 = new Topic();
		topicSub1.setAnswer("SubItemTitle1");
		List<SubItemTitle> subItemTitleSub1= new java.util.Vector<SubItemTitle>();
		SubItemTitle subItem1 = new SubItemTitle();
		subItem1.setItem("SubItemTitle1-1");
		subItemTitleSub1.add(subItem1);
		subItem1 = new SubItemTitle();
		subItem1.setItem("SubItemTitle1-2");
		subItemTitleSub1.add(subItem1);
		topicSub1.setSubItemTitle(subItemTitleSub1);
		
		item.setItem(topicSub1);
		subItemTitle.add(item);
//		item = new SubItemTitle();
//		Topic topicSub2 = new Topic();
//		topicSub2.setAnswer("SubItemTitle1");
//		item.setItem(topicSub2);
//		subItemTitle.add(item);
		topic.setSubItemTitle(subItemTitle);
		
		return topic;
	}

	@Override
	protected void loadSubItemView() {
		 for (View iterable_elementView : subViewList) {
		 subLayout.removeView(iterable_elementView);
		 iterable_elementView = null;
		 }
		 subViewList.clear();
		
		for (SubItemTitle iterable_element : m_topic.getSubItemTitle()) {
			
			Topic t = (Topic) iterable_element.getItem();
			TextView textView = new TextView(m_context);
			textView.setText(t.getAnswer().toString());
			textView.setTextColor(subTitleTextColor);
			textView.setBackgroundColor(subBackgroundColor);
			textView.setTextSize(getPracticalSubTitleTextSize());
			textView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			subLayout.addView(textView);
			subViewList.add(textView);

			RadioGroup rg = new RadioGroup(m_context);
			rg.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			subLayout.addView(rg);
			subViewList.add(rg);

			for (SubItemTitle iterable_subElement : t.getSubItemTitle()) {
				String value = iterable_subElement.getItem().toString();
				RadioButton subView2 = new RadioButton(m_context);
				subView2.setText(value);
				subView2.setVisibility(textViewTitle.getVisibility());
				subView2.setTextColor(subTitleTextColor);
				subView2.setBackgroundColor(subBackgroundColor);
				subView2.setTextSize(subTitleTextSize);

				rg.addView(subView2, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				subViewList.add(subView2);
			}

		}
	}

}
