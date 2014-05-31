package com.TtMyth123.examsys.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;

import com.TtMyth123.examsys.bean.SubItemTitle;

public class MultiChangeTestView extends TopicView {
	public MultiChangeTestView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public MultiChangeTestView(Context context) {
		super(context, null);
	}

	@Override
	protected void loadSubItemView() {
		for (View iterable_elementView : subViewList) {
			subLayout.removeView(iterable_elementView);
			iterable_elementView = null;
		}
		subViewList.clear();
		
		
		for (SubItemTitle iterable_element : m_topic.getSubItemTitle()) {
			String value = iterable_element.getItem().toString();
			CheckBox subView = new CheckBox(m_context);
			subView.setText(value);	
			subView.setVisibility(textViewTitle.getVisibility());
			subView.setTextColor(subTitleTextColor);
			subView.setBackgroundColor(subBackgroundColor);
			subView.setTextSize(getPracticalSubTitleTextSize());
			
			subViewList.add(subView);
			subLayout.addView(subView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		}
	}

}
