package com.TtMyth123.examsys;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.TtMyth123.examsys.bean.ChapterInfo;

/**
 * йт╬М╪Р╫И
 * 
 * @author S5
 * 
 */
public class ExaminationIntroActivity extends Activity {

	ChapterInfo chapterInfo;
	TextView textViewExamTitle;
	Button buttonReturnExaminationPaper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.examinationintro_layout);

		textViewExamTitle = (TextView) findViewById(R.id.textViewExamTitle);
		chapterInfo = new ChapterInfo();
		chapterInfo.copyValue(this.getIntent());

		textViewExamTitle.setText(chapterInfo.getChapter());

		iniButtonReturnExaminationPaper();
	}

	private void iniButtonReturnExaminationPaper() {
		buttonReturnExaminationPaper = (Button) findViewById(R.id.buttonReturnExaminationPaper);
		buttonReturnExaminationPaper.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ExaminationIntroActivity.this.finish();
			}
		});
	}

}
