package com.TtMyth123.examsys.view;

import android.content.Context;
import android.util.AttributeSet;

public class NotGIvenTestView extends TopicView {
	public NotGIvenTestView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public NotGIvenTestView(Context context) {
		super(context, null);
	}

	@Override
	protected void loadSubItemView() {
		// for (View iterable_elementView : subViewList) {
		// Log.i("Tt", "removeView_textView.Title1:" + ((TextView) iterable_elementView).getText().toString());
		// subLayout.removeView(iterable_elementView);
		// iterable_elementView = null;
		// }
		// subViewList.clear();
		//
		// RadioGroup rg = new RadioGroup(m_context);
		// rg.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		// subLayout.addView(rg);
		//
		// for (SubItemTitle iterable_element : m_topic.getSubItemTitle()) {
		// String value = iterable_element.Title;
		// RadioButton subView = new RadioButton(m_context);
		// subView.setText(value);
		// subView.setVisibility(textViewTitle.getVisibility());
		// subView.setTextColor(subTitleTextColor);
		// subView.setBackgroundColor(subBackgroundColor);
		// subView.setTextSize(subTitleTextSize);
		//
		// subViewList.add(subView);
		// rg.addView(subView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		// }
	}

}
