package com.TtMyth123.examsys.view;

import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.TtMyth123.examsys.R;
import com.TtMyth123.examsys.bean.SubItemTitle;
import com.TtMyth123.examsys.bean.Topic;

public class TopicView extends LinearLayout {
	protected Topic m_topic =null;
	protected Context m_context;  
	protected TypedArray m_typedArray;  
	protected LayoutParams m_params;  
    
    LinearLayout subLayout;
    
	TextView textViewTitle;
	
	TextView textViewTitle1;
	
	/**
	 * 
	 */
	List<View> subViewList= new java.util.Vector<View>();

	/**
	 * 标题文本内容
	 */
	protected String mainTitleText = "mainTitleText";
	/** 
	 * 标题文本字体大小
	 */
	protected float mainTitleTextSize = 2;
	
	public float getMainTitleTextSize() {
		return mainTitleTextSize;
	}

	public void setMainTitleTextSize(float mainTitleTextSize) {
		this.mainTitleTextSize = mainTitleTextSize;
		if(mainTitleTextSize<2) {
			this.mainTitleTextSize = 2;
		}
	}
	/**
	 * 标题文本字体颜色
	 */
	protected int mainTitleTextColor = Color.WHITE;
	
	/**
	 * 标题文本字体背景颜色
	 */
	protected int mainBackgroundColor = Color.BLACK;
	
	/** 
	 * 
	 * 标题文本区域左padding
	 */
	protected int mainTitlePaddingLeft = 0;
	/** 
	 * 标题文本区域上padding 
	 */
	protected int mainTitlePaddingTop = 0;
	/**
	 * 标题文本区域右padding
	 */
	protected int mainTitlePaddingRight = 0;
	/**
	 * 标题文本区域下padding
	 */
	protected int mainTitlePaddingBottom = 0;
	
	/** 
	 * 子项目文本字体大小
	 */
	protected float subTitleTextSize = -2;
	
	/**
	 * 实际子项目的文本字体大小.
	 * @return 实际子项目的文本字体大小.
	 */
	protected float getPracticalSubTitleTextSize() {
		float practicalSubTitleTextSize = getMainTitleTextSize();
		if (subTitleTextSize < 0) {
			practicalSubTitleTextSize = practicalSubTitleTextSize - subTitleTextSize;

			if (practicalSubTitleTextSize < 0) {
				practicalSubTitleTextSize = getMainTitleTextSize();
			}
		}

		return practicalSubTitleTextSize;
	}
	/**
	 * 子项目文本字体颜色
	 */
	protected int subTitleTextColor = Color.WHITE;
	
	/**
	 * 子项目文本字体背景颜色
	 */
	protected int subBackgroundColor = Color.BLACK;
	
	/** 
	 * 
	 * 子项目文本区域左padding
	 */
	protected int subTitlePaddingLeft = 0;
	/** 
	 * 子项目文本区域上padding 
	 */
	protected int subTitlePaddingTop = 0;
	/**
	 * 子项目文本区域右padding
	 */
	protected int subTitlePaddingRight = 0;
	/**
	 * 子项目文本区域下padding
	 */
	protected int subTitlePaddingBottom = 0;

	public TopicView(Context context, AttributeSet attrs) {
		super(context, attrs);
		m_context = context;
		this.setOrientation(VERTICAL);
		if (attrs != null) {
			TypedArray m_typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopicView);
			String tmpText = m_typedArray.getString(R.styleable.TopicView_mainText);
			if (tmpText != null) {
				mainTitleText = tmpText;
			}
			setMainTitleTextSize(m_typedArray.getDimension(R.styleable.TopicView_mainTextSize, 25));
			mainTitleTextColor = m_typedArray.getColor(R.styleable.TopicView_mainTextColor, Color.WHITE); 
			mainTitlePaddingLeft = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_mainPaddingLeft, 0);
			mainTitlePaddingTop = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_mainPaddingTop, 0);
			mainTitlePaddingRight = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_mainPaddingRight, 0);
			mainTitlePaddingBottom = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_mainPaddingBottom, 0);
			mainBackgroundColor = m_typedArray.getColor(R.styleable.TopicView_mainBackgroundColor, Color.BLACK);
			
			subTitleTextSize = m_typedArray.getDimension(R.styleable.TopicView_subTextSize, -2);
			subTitleTextColor = m_typedArray.getColor(R.styleable.TopicView_subTextColor, Color.WHITE);
			subTitlePaddingLeft = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_subPaddingLeft, 0);
			subTitlePaddingTop = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_subPaddingTop, 0);
			subTitlePaddingRight = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_subPaddingRight, 0);
			subTitlePaddingBottom = m_typedArray.getDimensionPixelSize(R.styleable.TopicView_subPaddingBottom, 0);
			subBackgroundColor = m_typedArray.getColor(R.styleable.TopicView_subBackgroundColor, Color.BLACK);
			m_typedArray.recycle();
		}
		
		
		
		textViewTitle = new TextView(context);
		addView(textViewTitle);
		
		subLayout = new LinearLayout(context);
		subLayout.setOrientation(VERTICAL);
		subLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		addView(subLayout);
		
		Topic topic = getIniTopic();
		setTopic(topic);
		Log.i("TtMyth","TopicView(Context context, AttributeSet attrs)");
	}
	
	protected Topic getIniTopic() {
		Topic topic = new Topic();
		topic.setAnswer(mainTitleText);
		List<SubItemTitle> subItemTitle= new java.util.Vector<SubItemTitle>();
		SubItemTitle item = new SubItemTitle();
		item.setItem("SubItemTitle1");
		subItemTitle.add(item);
		item = new SubItemTitle();
		item.setItem("SubItemTitle2");
		subItemTitle.add(item);
		topic.setSubItemTitle(subItemTitle);
		
		return topic;
	}
	
	public TopicView(Context context) {
		super(context, null);
		Log.i("TtMyth","TopicView(Context context)");
	}
	
	
	public void setTopic(Topic topic) {
		m_topic = topic;
		
		loadMainTitle();
		loadSubItemView();				
	}
	
	protected void loadMainTitle() {
		textViewTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		textViewTitle.setText(m_topic.getAnswer().toString());
		textViewTitle.setTextColor(mainTitleTextColor);
		textViewTitle.setTextSize(getMainTitleTextSize());
		textViewTitle.setBackgroundColor(mainBackgroundColor);
	}
	void loadSubItemView() {
		for (View iterable_elementView : subViewList) {
			Log.i("Tt", "removeView_textView.Title1:" + ((TextView) iterable_elementView).getText().toString());
			subLayout.removeView(iterable_elementView);
			iterable_elementView = null;
		}
		subViewList.clear();

		for (SubItemTitle iterable_element : m_topic.getSubItemTitle()) {
			String value = iterable_element.getItem().toString();
			TextView textView = new TextView(m_context);
			textView.setText(value);	
			textView.setVisibility(textViewTitle.getVisibility());
			textView.setTextColor(subTitleTextColor);
			textView.setBackgroundColor(subBackgroundColor);
			textView.setTextSize(getPracticalSubTitleTextSize());
			
			subViewList.add(textView);
			this.subLayout.addView(textView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			Log.i("TtMyth", "TextView:" + value + ",w:" + textView.getWidth() + ",h" + textView.getHeight()+",getTextSize:"+textView.getTextSize());
		}
	}
	
//	protected void loadSubItemView() {
//		for (View iterable_elementView : subViewList) {
//			Log.i("Tt", "removeView_textView.Title1:" + ((TextView) iterable_elementView).getText().toString());
//			subLayout.removeView(iterable_elementView);
//			iterable_elementView = null;
//		}
//		subViewList.clear();
//
//		RadioGroup rg = new RadioGroup(m_context);
//		rg.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//		subLayout.addView(rg);
//
//		for (SubItemTitle iterable_element : m_topic.getSubItemTitle()) {
//			String value = iterable_element.Title;
//			RadioButton subView = new RadioButton(m_context);
//			subView.setText(value);
//			subView.setVisibility(textViewTitle.getVisibility());
//			subView.setTextColor(subTitleTextColor);
//			subView.setBackgroundColor(subBackgroundColor);
//			subView.setTextSize(subTitleTextSize);
//
//			subViewList.add(subView);
//			rg.addView(subView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
//		}
//	}

}
